package org.example.reactweatherback.ApiServices;

import lombok.RequiredArgsConstructor;
import org.example.reactweatherback.ApiEntities.User;
import org.example.reactweatherback.ApiRepos.UserRepository;
import org.example.reactweatherback.ApiEntities.Location;
import org.example.reactweatherback.ApiDtos.LocationDTO;
import org.example.reactweatherback.ApiRepos.LocationRepository;
import org.example.reactweatherback.ApiDtos.LocationRequest;
import org.example.reactweatherback.User.ChangePasswordRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        userRepository.save(user);
    }

    public ResponseEntity<String> updateLocations(LocationRequest locationRequest) {
        locationRepository.deleteAllForUserId(locationRequest.getId());
        User user = userRepository.findById(locationRequest.getId()).orElse(null);
        if (user == null) return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);

        List<LocationDTO> dtos = locationRequest.getLocations();
        for (LocationDTO dto : dtos) {
            Location location = new Location();
            location.setUser(user);
            location.setName(dto.getName());
            location.setCountry(dto.getCountry());
            location.setLon(dto.getLon());
            location.setLat(dto.getLat());

            locationRepository.save(location);
        }

        return new ResponseEntity<>("User locations updated", HttpStatus.OK);
    }

    public List<LocationDTO> getLocations(Integer userId) {
        List<Location> locations = locationRepository.getAllForUserId(userId);
        List<LocationDTO> dtos = new ArrayList<>();

        locations.forEach((location -> dtos.add(new LocationDTO(
                location.getName(),
                location.getCountry(),
                location.getLon(),
                location.getLat()))));

        return dtos;
    }
}
