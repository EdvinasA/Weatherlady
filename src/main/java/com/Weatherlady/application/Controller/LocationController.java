package com.Weatherlady.application.Controller;

import com.Weatherlady.application.Entity.Location;
import com.Weatherlady.application.Exceptions.InternalServerException;
import com.Weatherlady.application.Service.LocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;




public class LocationController {

    private final LocationService locationService = new LocationService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String addNewLocation(String locationName, String longitude, String latitude, String region, String countryName) throws InternalServerException {
        Location location = locationService.addNewLocation(locationName, longitude, latitude, region, countryName);

        try {
            return objectMapper.writeValueAsString(location);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("HTTP 500 internal server error");
        }
    }

    public String readAllLocations() throws InternalServerException {
        List<Location> locations = locationService.readAllLocations();
        try {
            return objectMapper.writeValueAsString(locations);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("HTTP 500 internal server error");
        }
    }
}
