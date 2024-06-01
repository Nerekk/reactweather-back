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

    @GetMapping(path = "current/{city}")
    public WeatherResponse getCurrentWeather(@PathVariable("city") String city) {
        return weatherService.getWeather(city);
    }

    @GetMapping(path = "forecast/{city}")
    public ForecastResponse getForecastWeather(@PathVariable("city") String city) {
        return weatherService.getForecast(city);
    }

    @GetMapping(path = "air/{lon}/{lat}")
    public AirResponse getAirQuality(@PathVariable("lon") Double lon, @PathVariable("lat") Double lat) {
        return weatherService.getAirPollution(lat, lon);
    }

    @GetMapping(path = "combined/{city}")
    public CombinedWeatherResponse getCombinedWeather(@PathVariable("city") String city) {
        return weatherService.getCombined(city);
    }
}
