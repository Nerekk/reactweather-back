package org.example.reactweatherback.WeatherApi.Handling;

import lombok.RequiredArgsConstructor;
import org.example.reactweatherback.Paths.Paths;
import org.example.reactweatherback.WeatherApi.Responses.Air.AirResponse;
import org.example.reactweatherback.WeatherApi.Responses.CombinedWeatherResponse;
import org.example.reactweatherback.WeatherApi.Responses.Forecast.ForecastResponse;
import org.example.reactweatherback.WeatherApi.Responses.Weather.WeatherResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Paths.WEATHER)
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping(path = "combined/{city}")
    public CombinedWeatherResponse getCombinedWeather(@PathVariable("city") String city) {
        return weatherService.getCombined(city);
    }
}
