package com.Weatherlady.application;

import javax.persistence.*;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "Locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private float longitude;

    private float latitude;

    @Column(nullable = false)
    private String cityName;

    @Column
    private String region;

    @Column(nullable = false)
    String countryName;

    public Location(float longitude, float latitude, String cityName, String region, String countryName) {
        this.longitude = longitude;
        this.latitude = latitude;
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

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
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
}




