package com.Weatherlady;

import com.Weatherlady.application.Controller.WeatherClient;
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
    public static WeatherClient weatherClient = new WeatherClient();

    public void run(){
            transaction.begin();

            LocationService locationService = new LocationService();
            Location location = locationService.addNewLocation("Klaipėda", "Žemaitija", "Lithuania");
            Location location1 = locationService.addNewLocation("Vilnius", "Aukstaitija", "Lithuania");
            Location location2 = locationService.addNewLocation("Kaun2as", "Aukstaitija", "Lithuania");

            weatherClient.runClientInterface();


            User edvinas = new User("Edvinas", "123456789");
            User rimantas = new User("Rimantas", "123456789");

            userRepository.save(edvinas);
            userRepository.save(rimantas);

            Weather weather = new Weather(20d, "S" ,20d);
            Weather weather1 = new Weather(22d, "W" ,80d);

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
