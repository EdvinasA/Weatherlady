package com.Weatherlady.application.Controller;

import com.Weatherlady.application.Entity.Weather;
import com.Weatherlady.application.Exceptions.InternalServerException;
import com.Weatherlady.application.Service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class WeatherController {

    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getWeatherValues(String cityName, Integer daysToAdd) {
        Weather weather = weatherService.getWeather(cityName, daysToAdd);
        try {
            return objectMapper.writeValueAsString(weather);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("HTTP 500 internal server error");
        }
    }

}
