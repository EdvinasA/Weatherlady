package com.Weatherlady;

import com.Weatherlady.application.Location;
import com.Weatherlady.application.UserInterface.User;
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

            Location location = new Location("Kaunas", "Aukstaitija", "Lithuania");
            User edvinas = new User();
            edvinas.setUserName("Edvinas");
            edvinas.setPassword("123456789");

            entityManager.persist(location);
            entityManager.persist(edvinas);

            transaction.commit();
            entityManager.close();

    }
}
