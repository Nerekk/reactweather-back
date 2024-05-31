package org.example.reactweatherback.ApiDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocationRequest {
    private Integer id;
    private List<LocationDTO> locations;
}
