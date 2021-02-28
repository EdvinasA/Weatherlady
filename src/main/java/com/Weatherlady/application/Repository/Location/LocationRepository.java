package com.Weatherlady.application.Repository.Location;

import com.Weatherlady.application.Entity.Location;
import com.Weatherlady.application.Repository.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class LocationRepository extends AbstractRepository<Location, UUID> {

    public LocationRepository(EntityManager entityManager) {
        super(entityManager, Location.class);
    }

    @Override
    public List<Location> findAll() {
        return entityManager.createQuery("FROM Location", Location.class).getResultList();
    }

    public List<Location> findByName(String name) {
        TypedQuery<Location> query = entityManager.createQuery("FROM Location WHERE cityName=:cityName", Location.class);
        query.setParameter("cityName", name);
        return query.getResultList();
    }
}
