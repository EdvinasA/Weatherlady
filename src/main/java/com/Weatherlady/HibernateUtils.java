package com.Weatherlady;

import com.Weatherlady.application.entity.Location;
import com.Weatherlady.application.entity.User;
import com.Weatherlady.application.entity.Weather;
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