package com.Weatherlady.application;

import com.Weatherlady.application.Entity.Weather;

public class WeatherResponseMapper {

    public static Weather mapToWeather(WeatherResponse.ListItem listItem) {

        String windDirection = "";
        float tempWindDirection = listItem.wind.getDeg();
        if (tempWindDirection >= 45 && tempWindDirection < 135) {
            windDirection = "E";
        } else if (tempWindDirection >= 135 && tempWindDirection < 225) {
            windDirection = "S";
        } else if (tempWindDirection >= 225 && tempWindDirection <315){
            windDirection = "W";
        } else windDirection = "N";

        float temperature = listItem.main.getTemp();
        float pressure = listItem.main.getPressure();
        float humidity = listItem.main.getHumidity();

        float windSpeed = listItem.wind.getSpeed();

        return new Weather(temperature, pressure, humidity, windDirection, windSpeed);
    }
}