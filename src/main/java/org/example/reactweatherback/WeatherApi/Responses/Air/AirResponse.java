package org.example.reactweatherback.WeatherApi.Responses.Air;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.reactweatherback.WeatherApi.Responses.Air.Components.AirRecord;
import org.example.reactweatherback.WeatherApi.Responses.Coords;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirResponse {
    private Coords coord;
    private List<AirRecord> list;
}
