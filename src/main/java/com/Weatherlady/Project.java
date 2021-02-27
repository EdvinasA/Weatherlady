package com.Weatherlady;

import com.Weatherlady.application.Location;
import com.Weatherlady.application.UserInterface.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Project {

    public void run(){
        SessionFactory sessionFactory = new Configuration()
                .configure("persistence.cfg.xml")
                .addAnnotatedClass(Location.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();

            Location location = new Location("Kaunas", "Aukstaitija", "Lithuania");
            User edvinas = new User();
            edvinas.registerUser("Edvinas", "123456789");

            entityManager.persist(location);
            entityManager.persist(edvinas);

            transaction.commit();

            List<User> users = entityManager.createQuery("FROM User", User.class).getResultList();
            System.out.println(users);

            entityManager.close();

    }
}
