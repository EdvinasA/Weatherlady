package com.Weatherlady.application.Service;

import com.Weatherlady.HibernateUtils;
import com.Weatherlady.application.Entity.Weather;
import com.Weatherlady.application.Repository.Weather.WeatherRepository;

import javax.persistence.EntityManager;

public class WeatherService {

    private final HibernateUtils hibernateUtils = new HibernateUtils();
    private final EntityManager entityManager = hibernateUtils.getSessionFactory().createEntityManager();
    private final WeatherRepository weatherRepository = new WeatherRepository(entityManager);

    public Weather addNewWeather(Double temperature, String windDirection, Double pressure) {
        Weather weather = new Weather(temperature,windDirection, pressure);
        weatherRepository.save(weather);

        return weather;
    }
}
