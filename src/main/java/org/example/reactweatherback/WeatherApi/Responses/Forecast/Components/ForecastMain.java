package org.example.reactweatherback.WeatherApi.Responses.Forecast.Components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ForecastMain {
    private Double temp;
    private Integer pressure;
    private Integer humidity;
}
