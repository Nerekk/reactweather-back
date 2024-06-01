package org.example.reactweatherback.WeatherApi.Responses.Forecast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.reactweatherback.WeatherApi.Responses.Forecast.Components.ForecastRecord;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ForecastResponse {
    private Integer cod;
    private List<ForecastRecord> list;
}
