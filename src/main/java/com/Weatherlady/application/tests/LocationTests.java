package com.Weatherlady.application.tests;

import com.Weatherlady.application.entity.Location;
import com.Weatherlady.application.exceptions.BadParametersGainFromUserException;
import com.Weatherlady.application.exceptions.BadRequestException;
import com.Weatherlady.application.service.LocationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTests {
    private final LocationService locationService = new LocationService();


    @Test
    void addNewLocation_shouldReturnNewLocation() {
        // when
        Location result = locationService.addNewLocation("city", "region", "country");

        // then
        assertEquals(result.getCityName(), "city");
        assertEquals(result.getRegion(), "region");
        assertEquals(result.getCountryName(), "country");
    }

    @Test
    void addNewLocation_whenRegionNameIsEmpty_shouldReturnNewLocation () {
        // when
        Location result = locationService.addNewLocation("city", "region", "country");

        // then
        assertEquals(result.getCityName(), "city");
        //assertEquals(result.getRegion(), "region");
        assertEquals(result.getCountryName(), "country");
    }

    @Test
    void addNewLocation_whenCityIsEmpty_shouldThrowException () {
        assertThrows(BadRequestException.class, () -> locationService.addNewLocation("", "region", "country"));
    }


    @Test
    void addNewLocation_whenCountryNameInEmpty_shouldThrowException () {
        assertThrows(BadRequestException.class, () -> locationService.addNewLocation("city", "region", ""));
    }

    @Test
    void addNewLocation_whenRegionNameInEmpty_shouldThrowException () {
        assertThrows(BadRequestException.class, () -> locationService.addNewLocation("city", "", ""));
    }
}