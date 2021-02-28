package com.Weatherlady.application.Service;

import com.Weatherlady.application.Entity.Location;
import com.Weatherlady.application.Exceptions.BadRequestException;
import com.Weatherlady.application.Repository.Location.LocationRepository;

import java.util.List;

public class LocationService {

    private final LocationRepository locationRepository = new LocationRepository();

    public Location addNewLocation(String locationName, String longitude, String latitude, String region, String countryName) {
        if (locationName == null || locationName.isBlank()) {
            throw new BadRequestException("The location cannot be empty!");
        }
        if (longitude == null || longitude.isBlank()) {
            throw new BadRequestException("Longitude cannot be empty!");
        }
        if (Integer.parseInt(longitude) < -180 || (Integer.parseInt(longitude) > 180)) {
            throw new BadRequestException("Invalid value, please enter a numeric value in the range <-90, 90>");
        }
        if (latitude == null || latitude.isBlank()) {
            throw new BadRequestException("Latitude cannot be empty!");
        }
        if (Integer.parseInt(latitude) < -90 || (Integer.parseInt(latitude) > 90)) {
            throw new BadRequestException("Invalid value, please enter a numeric value in the range <-90, 90>");
        }
        if (countryName == null || countryName.isBlank()) {
            throw new BadRequestException("Country name cannot be empty");
        }

        Location location = new Location(locationName, longitude, latitude, region, countryName);
        Location savedLocation = locationRepository.saveNewLocation(location);

        return savedLocation;
    }

    public List<Location> readAllLocations() {
        return locationRepository.readAllLocations();
    }

}
