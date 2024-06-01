package org.example.reactweatherback.WeatherApi.Responses.Forecast.Components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ForecastRecord {
    private Long dt;
    private ForecastMain main;
    private List<ForecastWeather> weather;
    private ForecastWind wind;
}
