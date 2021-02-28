package com.Weatherlady.application;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class WeatherResponse {

    List<ListItem> list = new ArrayList<>();

    @Data
    public static class ListItem {

        Main main;
        Wind wind;
        String dt_txt;

        @Data
        public static class Main {
            Float temp;
            Float pressure;
            Float humidity;
        }

        @Data
        public static class Wind {
            Float speed;
            Float deg;
        }


    }
}