package com.Weatherlady.application.Controller;

import com.Weatherlady.application.Exceptions.BadGatawayException;
import com.Weatherlady.application.Exceptions.BadParametersGainFromUserException;
import com.Weatherlady.application.WeatherResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.List;

public class WeatherForecastClient {

    private final String API_KEY = "??????????";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherForecastClient() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();
    }

    public WeatherResponse.ListItem getWeather(String cityName, int daysToAdd) {
        String uri = String.format("http:???" , cityName, API_KEY);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();

            WeatherResponse weatherResponse = objectMapper.readValue(responseBody, WeatherResponse.class);
            List<WeatherResponse.ListItem> list = weatherResponse.getList();

            return list.stream()
                    .filter(dt -> dt.getDt_txt().equals(LocalDate.now().plusDays(daysToAdd) + " 12:00:00"))
                    .findFirst()
                    .orElseThrow(() -> new BadParametersGainFromUserException("Incorrect parameters provided by the user"));
        } catch (Exception e) {
            System.out.println("Failed attempt to connect to the service: " + e.getMessage());
            throw new BadGatawayException("Failed attempt to connect to the service, 502");
        }
    }

}
