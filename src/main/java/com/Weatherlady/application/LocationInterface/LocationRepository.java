package com.Weatherlady.application.LocationInterface;

import com.Weatherlady.application.utils.AbstractRepository;

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

    public List<Location> find(String entity) {
        TypedQuery<Location> query = entityManager.createQuery("FROM Location " + entity, Location.class);
        return query.getResultList();
    }
}
