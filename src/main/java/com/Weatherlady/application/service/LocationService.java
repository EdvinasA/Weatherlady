package com.Weatherlady.application.service;

import com.Weatherlady.application.entity.Location;
import com.Weatherlady.application.exceptions.BadRequestException;
import com.Weatherlady.HibernateUtils;
import com.Weatherlady.application.repository.location.LocationRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class LocationService {

    private final HibernateUtils hibernateUtils = new HibernateUtils();
    private final EntityManager entityManager = hibernateUtils.getSessionFactory().createEntityManager();
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
