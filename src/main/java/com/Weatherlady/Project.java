package com.Weatherlady;

import com.Weatherlady.application.Location;
import com.Weatherlady.application.UserInterface.User;
import com.Weatherlady.application.UserInterface.UserRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Project {

    public static SessionFactory sessionFactory = new Configuration()
            .configure("persistence.cfg.xml")
            .addAnnotatedClass(Location.class)
            .addAnnotatedClass(User.class)
            .buildSessionFactory();

    public static EntityManager entityManager = sessionFactory.createEntityManager();
    public static UserRepository userRepository = new UserRepository(entityManager);
    public static EntityTransaction transaction = entityManager.getTransaction();

    public void run(){


            transaction.begin();

//            Location location = new Location("Kaunas", "Aukstaitija", "Lithuania");
            User edvinas = new User("Edvinas", "123456789");

//            entityManager.persist(location);
            userRepository.save(edvinas);
            User edvinass = new User("Edvinass", "123456789");
            userRepository.save(edvinass);

            List<User> users = userRepository.findAll();
            System.out.println(users);

            entityManager.close();
    }

}
