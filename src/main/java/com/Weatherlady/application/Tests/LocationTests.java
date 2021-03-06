package com.Weatherlady.application.Tests;

import com.Weatherlady.application.Entity.Location;
import com.Weatherlady.application.Service.LocationService;
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
        assertThrows(Exception.class, () -> locationService.addNewLocation("", "region", "country"));
    }


    @Test
    void addNewLocation_whenCountryNameInEmpty_shouldThrowException () {
        assertThrows(Exception.class, () -> locationService.addNewLocation("city", "region", ""));
    }

    @Test
    void addNewLocation_whenRegionNameInEmpty_shouldThrowException () {
        assertThrows(Exception.class, () -> locationService.addNewLocation("city", "", ""));
    }
}