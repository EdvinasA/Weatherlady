package com.Weatherlady.application.Controller;

import com.Weatherlady.application.Entity.Weather;
import com.Weatherlady.application.Exceptions.InternalServerException;
import com.Weatherlady.application.Service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class WeatherController {

    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String addNewWeather(Double temperature, String windDirection, Double pressure, String location) throws InternalServerException {
        try {
            return objectMapper.writeValueAsString(weatherService.addNewWeather(temperature,windDirection, pressure, location));
        } catch (JsonProcessingException e) {
            throw new InternalServerException("HTTP 500 internal server error");
        }
    }

    public List<Weather> findAll() {
        return weatherService.readAllLocations();
    }
}
