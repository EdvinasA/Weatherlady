package com.Weatherlady.application.Service;

import com.Weatherlady.application.Controller.WeatherForecastClient;
import com.Weatherlady.application.Entity.Weather;
import com.Weatherlady.application.Repository.Weather.WeatherRepository;
import com.Weatherlady.application.WeatherResponse;
import com.Weatherlady.application.WeatherResponseMapper;

public class WeatherService {
    private final WeatherForecastClient weatherForecastClient = new WeatherForecastClient();
    private final WeatherResponseMapper weatherResponseMapper = new WeatherResponseMapper();
    private final WeatherRepository weatherRepository = new WeatherRepository();

    public Weather getWeather(String cityName, Integer daysToAdd) {
        WeatherResponse.ListItem weatherList = weatherForecastClient.getWeather(cityName,daysToAdd);
        Weather weather = weatherResponseMapper.mapToWeather(weatherList);
        return weatherRepository.saveNewWeatherForecast(weather);
    }


}
