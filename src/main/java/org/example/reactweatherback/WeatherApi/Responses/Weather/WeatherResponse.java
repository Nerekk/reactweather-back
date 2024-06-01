package org.example.reactweatherback.WeatherApi.Responses.Weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.reactweatherback.WeatherApi.Responses.Coords;
import org.example.reactweatherback.WeatherApi.Responses.Weather.Components.WeatherMain;
import org.example.reactweatherback.WeatherApi.Responses.Weather.Components.WeatherRecord;
import org.example.reactweatherback.WeatherApi.Responses.Weather.Components.WeatherSys;
import org.example.reactweatherback.WeatherApi.Responses.Weather.Components.WeatherWind;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WeatherResponse {
    private Coords coord;
    private List<WeatherRecord> weather;
    private WeatherMain main;
    private WeatherWind wind;
    private Long dt;
    private WeatherSys sys;
    private String name;
    private Integer cod;
}
