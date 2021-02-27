package com.Weatherlady.application;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Locations")
public class Location {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private UUID id;
        private String locationName;
        private String longitude;
        private String latitude;
        private String region;
        private String countryName;

        public Location(String locationName) {
            this.locationName = locationName;
        }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

