package com.Weatherlady.application.WheatherInterface;

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
    private Float windDirection;

    @Column(nullable = false)
    private Float windSpeed;

    public Weather(Float temperature, Float windDirection, Float windSpeed) {
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
}
