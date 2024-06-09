package org.example.reactweatherback.ApiDtos;

import lombok.*;
import org.example.reactweatherback.User.Role;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {
    private Integer id;
    private String email;
    private String password;
    private Role role;
    private List<LocationDTO> locations;
}
