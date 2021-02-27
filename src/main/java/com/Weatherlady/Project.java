package com.Weatherlady;

import com.Weatherlady.application.Location;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Project {

    public void run(){
        SessionFactory sessionFactory = new Configuration()
                .configure("persistence.cfg.xml")
                .addAnnotatedClass(Location.class)
                .buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();

            Location location = new Location("a");

            entityManager.persist(location);
            transaction.commit();
            entityManager.close();

    }
}
