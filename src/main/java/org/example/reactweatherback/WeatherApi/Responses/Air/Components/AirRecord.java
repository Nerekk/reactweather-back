package org.example.reactweatherback.WeatherApi.Responses.Air.Components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirRecord {
    private AirMain main;
    private Components components;
}
