package com.Weatherlady.application.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Locations")
public class Location implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String cityName;

    private String region;

    @Column(nullable = false)
    private String countryName;

    @OneToMany(targetEntity = Weather.class,cascade = CascadeType.ALL)
    private Set<Weather> weatherList = new HashSet<>();

    public Location() {
    }

    public Location(String cityName, String region, String countryName) {
        this.cityName = cityName;
        this.region = region;
        this.countryName = countryName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set<Weather> getWeatherList() {
        return weatherList;
    }

    public void addWeatherList(Weather weather) {
        this.weatherList.add(weather);
    }

    @Override
    public String toString() {
        return "Location{" +
                ", cityName='" + cityName + '\'' +
                ", region='" + region + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}




