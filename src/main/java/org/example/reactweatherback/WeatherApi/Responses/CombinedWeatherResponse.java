package org.example.reactweatherback.WeatherApi.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.reactweatherback.WeatherApi.Responses.Air.AirResponse;
import org.example.reactweatherback.WeatherApi.Responses.Forecast.ForecastResponse;
import org.example.reactweatherback.WeatherApi.Responses.Weather.WeatherResponse;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CombinedWeatherResponse {
    private WeatherResponse weather;
    private AirResponse air;
    private ForecastResponse forecast;
}
