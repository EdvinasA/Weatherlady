package com.Weatherlady.application.repository.weather;

import com.Weatherlady.application.entity.Weather;
import com.Weatherlady.application.repository.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class WeatherRepository extends AbstractRepository<Weather, UUID> {

    public WeatherRepository(EntityManager entityManager) {
        super(entityManager, Weather.class);
    }

    @Override
    public List<Weather> findAll() {
        return entityManager.createQuery("FROM Weather", Weather.class).getResultList();
    }

    public List<Weather> find(String cityName) {
        TypedQuery<Weather> query = entityManager.createQuery("FROM Weather WHERE location.getCityName=:cityName", Weather.class);
        query.setParameter("cityName", cityName);
        return query.getResultList();
    }

}
