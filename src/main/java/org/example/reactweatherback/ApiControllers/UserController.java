package org.example.reactweatherback.ApiControllers;

import lombok.RequiredArgsConstructor;
import org.example.reactweatherback.ApiDtos.LocationDTO;
import org.example.reactweatherback.ApiDtos.LocationRequest;
import org.example.reactweatherback.Paths.Paths;
import org.example.reactweatherback.User.ChangePasswordRequest;
import org.example.reactweatherback.ApiServices.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(Paths.USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "locations/put")
    public ResponseEntity<String> updateLocations(@RequestBody LocationRequest locationRequest) {
        return service.updateLocations(locationRequest);
    }

    @GetMapping(path = "locations/get/{id}")
    public ResponseEntity<List<LocationDTO>> getLocations(@PathVariable("id") Integer userId) {
        return ResponseEntity.ok(service.getLocations(userId));
    }
}
