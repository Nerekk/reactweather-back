package org.example.reactweatherback.ApiControllers;

import lombok.RequiredArgsConstructor;
import org.example.reactweatherback.ApiDtos.LocationDTO;
import org.example.reactweatherback.ApiDtos.LocationRequest;
import org.example.reactweatherback.ApiEntities.User;
import org.example.reactweatherback.Auth.AuthenticationService;
import org.example.reactweatherback.Paths.Paths;
import org.example.reactweatherback.User.ChangePasswordRequest;
import org.example.reactweatherback.ApiServices.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Paths.USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final AuthenticationService authenticationService;

    @PatchMapping(path = "changepass")
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "locations/put")
    public ResponseEntity<String> updateLocations(@RequestBody LocationRequest locationRequest, @RequestHeader("Authorization") String token) {
        Optional<User> user = authenticationService.findUserByToken(token.substring(7));
        if (user.isEmpty()) return ResponseEntity.badRequest().body("Invalid token or user inside of token");

        return service.updateLocations(locationRequest, user.get());
    }

    @GetMapping(path = "locations/get")
    public ResponseEntity<?> getLocations(@RequestHeader("Authorization") String token) {
        Optional<User> user = authenticationService.findUserByToken(token.substring(7));
        if (user.isEmpty()) return ResponseEntity.badRequest().body("Invalid token or user inside of token");

        return ResponseEntity.ok(service.getLocations(user.get().getId()));
    }

    @GetMapping(path = "info")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String token) {
        Optional<User> user = authenticationService.findUserByToken(token.substring(7));
        if (user.isEmpty()) return ResponseEntity.badRequest().body("Invalid token or user inside of token");

        return ResponseEntity.ok(service.getUserInfo(user.get()));
    }
}
