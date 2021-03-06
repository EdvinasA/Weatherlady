package com.Weatherlady.application.repository.user;

import com.Weatherlady.application.entity.User;
import com.Weatherlady.application.repository.AbstractRepository;

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

    public List<User> findWithName(String userName) {
        TypedQuery<User> query = entityManager.createQuery("FROM User WHERE userName=:userName", User.class);
        query.setParameter("userName", userName);
        return query.getResultList();
    }
}
