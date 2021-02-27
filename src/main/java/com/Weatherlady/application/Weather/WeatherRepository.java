package com.Weatherlady.application.Weather;

import com.Weatherlady.application.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class WeatherRepository {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public Weather saveNewWeatherForecast(Weather weather) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(weather);

        transaction.commit();
        session.close();

        return weather;
    }

    public List<Weather> readAllWeatherForecasts() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Weather> result = session.createQuery("FROM Weather").getResultList();

        transaction.commit();
        session.close();

        return result;
    }
}
