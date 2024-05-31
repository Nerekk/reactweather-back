package org.example.reactweatherback.ApiDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocationDTO {
    private String name;
    private String country;
    private Double lon;
    private Double lat;
}
