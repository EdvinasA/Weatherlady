package com.Weatherlady.application.tests;
import com.Weatherlady.application.entity.Location;
import com.Weatherlady.application.entity.Weather;
import com.Weatherlady.application.service.LocationService;
import com.Weatherlady.application.service.WeatherService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class WeatherServiceTest {

   private final WeatherService weatherService = new WeatherService();
   private final LocationService locationService = new LocationService();

    @Test
    void addNewWeather_shouldReturnNewWeather() {
        // when
        Location test = locationService.addNewLocation("city","region", "country");
        Weather response = weatherService.addNewWeather(20.00, "NW", 900.00,"city");


        // then
        assertTrue(response.getTemperature() > -100);
        assertFalse(response.getWindDirection().isBlank());
        assertTrue(response.getWindSpeed() >= 0);
        assertEquals(response.getLocation().getCityName(), test.getCityName());
    }


}
