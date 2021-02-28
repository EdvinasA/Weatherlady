package com.Weatherlady.application.WheatherInterface;

import com.Weatherlady.application.utils.AbstractRepository;

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

    public List<Weather> find(String entity) {
        TypedQuery<Weather> query = entityManager.createQuery("FROM Weather " + entity, Weather.class);
        return query.getResultList();
    }

}
