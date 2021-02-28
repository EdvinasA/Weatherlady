package com.Weatherlady.application.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Locations")
public class Location {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String cityName;

    private String region;

    @Column(nullable = false)
    String countryName;

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
}




