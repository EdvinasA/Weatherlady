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

    public String addNewLocation(String locationName, String region, String countryName) throws InternalServerException {
        try {
            return objectMapper.writeValueAsString(locationService.addNewLocation(locationName,region, countryName));
        } catch (JsonProcessingException e) {
            throw new InternalServerException("HTTP 500 internal server error");
        }
    }

    public List<Location> findAll() {
        return locationService.readAllLocations();
    }
}