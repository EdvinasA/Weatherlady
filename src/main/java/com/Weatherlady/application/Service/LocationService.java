package com.Weatherlady.application.Service;

import com.Weatherlady.application.Entity.Location;
import com.Weatherlady.application.Entity.User;
import com.Weatherlady.application.Entity.Weather;
import com.Weatherlady.application.Exceptions.BadRequestException;
import com.Weatherlady.application.Repository.Location.LocationRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.List;

public class LocationService {

    private final SessionFactory sessionFactory = new Configuration()
            .configure("persistence.cfg.xml")
            .addAnnotatedClass(Location.class)
            .addAnnotatedClass(User.class)
            .addAnnotatedClass(Weather.class)
            .buildSessionFactory();

    private final EntityManager entityManager = sessionFactory.createEntityManager();
    private final LocationRepository locationRepository = new LocationRepository(entityManager);

    public Location addNewLocation(String locationName, String region, String countryName) {
        if (locationName == null || locationName.isBlank()) {
            throw new BadRequestException("Wrong name or blank");
        }

        if (countryName == null || countryName.isBlank()) {
            throw new BadRequestException("Wrong name or blank");
        }

        Location location = new Location(locationName,region, countryName);
        locationRepository.save(location);

        return location;
    }

    public List<Location> readAllLocations() {
        return locationRepository.findAll();
    }
}
