package com.Weatherlady;

import com.Weatherlady.application.Controller.UserController;
import com.Weatherlady.application.Controller.Client;
import com.Weatherlady.application.Entity.Location;
import com.Weatherlady.application.Entity.User;
import com.Weatherlady.application.Entity.Weather;
import com.Weatherlady.application.Service.LocationService;
import com.Weatherlady.application.Service.UserService;
import com.Weatherlady.application.Service.WeatherService;
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

            Weather weather = weatherService.addNewWeather(20d, "S" ,20d);
            Weather weather1 = weatherService.addNewWeather(22d, "W" ,80d);

            userService.registerUser("Edvinas", "123456789");
            userService.registerUser("Rimantas", "123456789");

            weather.setLocation(location);
            weather1.setLocation(location);

            client.runClientInterface();

            entityManager.close();
    }
}
