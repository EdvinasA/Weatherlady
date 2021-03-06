package com.Weatherlady.application.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Weather")
public class Weather {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Double Temperature;

    @Column(nullable = false)
    private String windDirection;

    @Column(nullable = false)
    private Double windSpeed;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    public Weather() {
    }

    public Weather(Double temperature, String windDirection, Double windSpeed) {
        Temperature = temperature;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public Weather(Double temperature, String windDirection, Double windSpeed, Location location) {
        Temperature = temperature;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.location = location;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getTemperature() {
        return Temperature;
    }

    public void setTemperature(Double temperature) {
        Temperature = temperature;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
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
