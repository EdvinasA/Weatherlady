package com.Weatherlady.application.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Weather")
public class Weather {

    @Column(nullable = false)
    private Float Temperature;

    @Column(nullable = false)
    private Float windDirection;

    @Column(nullable = false)
    private Float windSpeed;

    @OneToMany
    private Location location;

    public Weather(Float temperature, Float windDirection, Float windSpeed) {
        Temperature = temperature;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public Float getTemperature() {
        return Temperature;
    }

    public void setTemperature(Float temperature) {
        Temperature = temperature;
    }

    public Float getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Float windDirection) {
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
                "Temperature=" + Temperature +
                ", windDirection=" + windDirection +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
