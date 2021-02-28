package com.Weatherlady;

import com.Weatherlady.application.Entity.Location;
import com.Weatherlady.application.Entity.User;
import com.Weatherlady.application.Entity.Weather;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private final SessionFactory sessionFactory = new Configuration()
            .configure("persistence.cfg.xml")
            .addAnnotatedClass(Location.class)
            .addAnnotatedClass(User.class)
            .addAnnotatedClass(Weather.class)
            .buildSessionFactory();

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}