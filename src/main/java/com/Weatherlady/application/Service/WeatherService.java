package com.Weatherlady.application.Service;

import com.Weatherlady.HibernateUtils;
import com.Weatherlady.application.Entity.Weather;
import com.Weatherlady.application.Repository.Location.LocationRepository;
import com.Weatherlady.application.Repository.Weather.WeatherRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class WeatherService {

    private final HibernateUtils hibernateUtils = new HibernateUtils();
    private final EntityManager entityManager = hibernateUtils.getSessionFactory().createEntityManager();
    private final WeatherRepository weatherRepository = new WeatherRepository(entityManager);
    private final LocationRepository locationRepository = new LocationRepository(entityManager);

    public Weather addNewWeather(Double temperature, String windDirection, Double pressure) {
//        List<Location> locationList = locationRepository.findAll();
//        Location location = new Location();
//        for (int i = 0; i < locationList.size(); i++) {
//            if (locationList.get(i).getCityName().equals(locationName)){
//                location = locationList.get(i);
//            }

            Weather weather = new Weather(temperature,windDirection, pressure);
            weatherRepository.save(weather);
//            weather.setLocation(location);
            return weather;
//        return null;
    }

    public List<Weather> readAllLocations() {
        return weatherRepository.findAll();
    }
}
