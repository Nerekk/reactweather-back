package org.example.reactweatherback.ApiDtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {
    private Integer id;
    private String email;
    private String password;
}
