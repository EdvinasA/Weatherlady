package com.Weatherlady;

import com.Weatherlady.application.Entity.Location;
import com.Weatherlady.application.Entity.User;
import com.Weatherlady.application.Entity.Weather;
import com.Weatherlady.application.Repository.Location.LocationRepository;
import com.Weatherlady.application.Repository.User.UserRepository;
import com.Weatherlady.application.Repository.Weather.WeatherRepository;
import com.Weatherlady.application.Service.LocationService;
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
            .addAnnotatedClass(Weather.class)
            .buildSessionFactory();

    public static EntityManager entityManager = sessionFactory.createEntityManager();
    public static EntityTransaction transaction = entityManager.getTransaction();

    public static UserRepository userRepository = new UserRepository(entityManager);
    public static LocationRepository locationRepository = new LocationRepository(entityManager);
    public static WeatherRepository weatherRepository = new WeatherRepository(entityManager);

    public void run(){
            transaction.begin();

            Location location = new Location("Kaunas", "Aukstaitija", "Lithuania");
            Location location1 = new Location("Vilnius", "Aukstaitija", "Lithuania");
            LocationService locationService = new LocationService();
            locationService.addNewLocation("Klaipėda", "Žemaitija", "Lithuania");


            locationRepository.save(location);
            locationRepository.save(location1);

            User edvinas = new User("Edvinas", "123456789");
            User rimantas = new User("Rimantas", "123456789");

            userRepository.save(edvinas);
            userRepository.save(rimantas);

            Weather weather = new Weather(20f, "S" ,20f);
            Weather weather1 = new Weather(22f, "W" ,80f);

            weather.setLocation(location);
            weather1.setLocation(location);

            weatherRepository.save(weather);
            weatherRepository.save(weather1);

            List<User> users = userRepository.findAll();
            List<Location> locations = locationRepository.findAll();
            List<Weather> weatherList = weatherRepository.findAll();

            System.out.println(locations);
            System.out.println(weatherList);
            System.out.println(users);

            entityManager.close();
    }


}
