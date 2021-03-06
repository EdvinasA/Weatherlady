package com.Weatherlady;

import com.Weatherlady.application.controller.Client;
import com.Weatherlady.application.entity.Location;
import com.Weatherlady.application.entity.User;
import com.Weatherlady.application.entity.Weather;
import com.Weatherlady.application.service.LocationService;
import com.Weatherlady.application.service.UserService;
import com.Weatherlady.application.service.WeatherService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Project {

    public static SessionFactory sessionFactory = new Configuration()
            .configure("persistence.cfg.xml")
            .addAnnotatedClass(Location.class)
            .addAnnotatedClass(User.class)
            .addAnnotatedClass(Weather.class)
            .buildSessionFactory();

    public static EntityManager entityManager = sessionFactory.createEntityManager();
    public static EntityTransaction transaction = entityManager.getTransaction();

    public static LocationService locationService = new LocationService();
    public static WeatherService weatherService = new WeatherService();
    public static UserService userService = new UserService();
    public static Client client = new Client();

    public void run(){
            transaction.begin();

            Location location = locationService.addNewLocation("Klaipėda", "Žemaitija", "Lithuania");
            Location location1 = locationService.addNewLocation("Vilnius", "Aukstaitija", "Lithuania");
            Location location2 = locationService.addNewLocation("Kaunas", "Aukstaitija", "Lithuania");

            Weather weather = weatherService.addNewWeather(20d, "S" ,20d, "Kaunas");
            Weather weather1 = weatherService.addNewWeather(22d, "W" ,80d, "Kaunas");

            userService.registerUser("Edvinas", "123456789");
            userService.registerUser("Rimantas", "123456789");

            client.runClientInterface();

            entityManager.close();
    }
}
