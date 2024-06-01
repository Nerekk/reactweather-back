package org.example.reactweatherback.WeatherApi.Responses.Weather.Components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherSys {
    private Integer type;
    private Integer id;
    private String country;
}
