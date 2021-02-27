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

    public void run(){
        EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();

            Location location = new Location("Kaunas", "Aukstaitija", "Lithuania");
            User edvinas = new User("Edvinas", "123456789");
            User edvinass = registerUser("Edvinass", "123456789");

            entityManager.persist(location);
            userRepository.save(edvinas);
//            userRepository.save(edvinass);

            transaction.commit();

            List<User> users = userRepository.findAll();
            System.out.println(users);

            entityManager.close();
    }

    public static User registerUser(String name, String password) throws IllegalArgumentException {
        List<User> listOfUser = userRepository.findAll();
        for (int i = 0; i < listOfUser.size(); i++) {
            if (listOfUser.get(i).getUserName().equals(name)) {
                return null;
            } else
                return new User(name, password);
        }
        return null;
    }
}
