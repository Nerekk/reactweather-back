package org.example.reactweatherback.WeatherApi.Handling;

import org.example.reactweatherback.WeatherApi.Responses.Air.AirResponse;
import org.example.reactweatherback.WeatherApi.Responses.CombinedWeatherResponse;
import org.example.reactweatherback.WeatherApi.Responses.Forecast.ForecastResponse;
import org.example.reactweatherback.WeatherApi.Responses.Weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public WeatherService(RestTemplate restTemplate, @Value("${weatherApiKey}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public WeatherResponse getWeather(String city) {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric", city, apiKey);
        return this.restTemplate.getForObject(url, WeatherResponse.class);
    }

    public ForecastResponse getForecast(String city) {
        String url = String.format("https://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric", city, apiKey);
        return this.restTemplate.getForObject(url, ForecastResponse.class);
    }

    public AirResponse getAirPollution(double lat, double lon) {
        String url = String.format("https://api.openweathermap.org/data/2.5/air_pollution?lat=%f&lon=%f&appid=%s", lat, lon, apiKey);
        return this.restTemplate.getForObject(url, AirResponse.class);
    }

    public CombinedWeatherResponse getCombined(String city) {
        WeatherResponse weatherResponse = getWeather(city);
        ForecastResponse forecastResponse = getForecast(city);
        AirResponse airResponse = getAirPollution(weatherResponse.getCoord().getLat(), weatherResponse.getCoord().getLon());

        CombinedWeatherResponse combined = new CombinedWeatherResponse(weatherResponse, airResponse, forecastResponse);
        return combined;
    }
}
