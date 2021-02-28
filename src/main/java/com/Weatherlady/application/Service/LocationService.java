package com.Weatherlady.application.Service;

import com.Weatherlady.application.Entity.Location;
import com.Weatherlady.application.Exceptions.BadRequestException;
import com.Weatherlady.application.HibernateUtils;
import com.Weatherlady.application.Repository.Location.LocationRepository;

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
