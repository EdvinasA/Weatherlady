package com.Weatherlady.application.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Weather")
public class Weather {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Float Temperature;

    @Column(nullable = false)
    private String windDirection;

    @Column(nullable = false)
    private Float windSpeed;

    @ManyToOne
    private Location location;

    public Weather(Float temperature, String windDirection, Float windSpeed) {
        Temperature = temperature;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getTemperature() {
        return Temperature;
    }

    public void setTemperature(Float temperature) {
        Temperature = temperature;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Weather{" +
                ", Temperature=" + Temperature +
                ", windDirection='" + windDirection + '\'' +
                ", windSpeed=" + windSpeed +
                ", location=" + location.getCityName() +
                '}';
    }
}
