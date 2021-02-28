package com.Weatherlady.application.UserInterface;

import com.Weatherlady.application.utils.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class UserRepository extends AbstractRepository<User, UUID> {

    public UserRepository(EntityManager entityManager) {
        super(entityManager, User.class);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public List<User> findLongerThan() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }
}