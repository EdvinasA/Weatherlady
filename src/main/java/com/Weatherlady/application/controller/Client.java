package com.Weatherlady.application.controller;

import com.Weatherlady.application.entity.Weather;
import com.Weatherlady.application.service.UserService;

import java.util.List;
import java.util.Scanner;

public class Client {

    private final LocationController locationController = new LocationController();
    private final WeatherController weatherController = new WeatherController();
    private final UserService userService = new UserService();

    public void runClientInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your application has started");

        boolean logIn = logInInterface();
        if (logIn) {
            while (true) {
                applicationMenu();

                int response = scanner.nextInt();

                switch (response) {
                    case 1:
                        addNewEntry();
                        break;
                    case 2:
                        printLocationList();
                        break;
                    case 3:
                        getAverageWeatherInCity();
                        break;
                    case 4:
                        addWeatherForecast();
                        break;
                    case 5:
                        printWeatherList();
                        break;
                    case 6:
                        System.out.println("Your application is shutting down");
                        return;
                }
            }
        }
    }

    private void applicationMenu() {
        System.out.println("Welcome to the weather app what you want to do: ");
        System.out.println("1. Add a new location to the database.");
        System.out.println("2. View currently added locations.");
        System.out.println("3. Find city Average Temperature values of days.");
        System.out.println("4. Add weather forecast.");
        System.out.println("5. Print weather forecast.");
        System.out.println("6. Exit the application.");
    }

    public boolean logInInterface() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = true;
        while (quit) {
            loginInMenu();

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    return logInUser();
                case 2:
                    registerUser();
                    break;
                case 3:
                    System.out.println("Your application is shutting down");
                    quit = false;
                    break;
            }
        }
        return false;
    }

    private void addWeatherForecast() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature:");
        double temperature = scanner.nextDouble();
        System.out.println("Enter wind direction(W,S,E,N): ");
        String direction = scanner.next();
        System.out.println("Enter wind speed: ");
        double windSpeed = scanner.nextDouble();
        System.out.println("Enter city: ");
        String city = scanner.next();
        weatherController.addNewWeather(temperature,direction,windSpeed,city);
    }

    private void loginInMenu() {
        System.out.println("1.Sign in.");
        System.out.println("2.Register.");
        System.out.println("3.Exit the application.");
    }

    private boolean logInUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account User Name:");
        String userName = scanner.nextLine();
        System.out.println("Enter your account password:");
        String password = scanner.nextLine();
        return userService.loginUser(userName, password);
    }

    private void registerUser () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account User Name:");
        String userName = scanner.nextLine();
        System.out.println("Enter account password:");
        String password = scanner.nextLine();
        userService.registerUser(userName, password);
    }

    private void getAverageWeatherInCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name for the location: ");
        String cityName = scanner.nextLine();
        List<Weather> weatherList = weatherController.findAll();
        double temperature = 0;
        for (int i = 0; i < weatherList.size(); i++) {
            if (weatherList.get(i).getLocation().getCityName().equals(cityName)){
                temperature += weatherList.get(i).getTemperature();
            }
        }
        System.out.println("Average temperature in " + cityName + " is: " + temperature / weatherList.size());

    }

    private void addNewEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name for the location: ");
        String locationName = scanner.nextLine();
        System.out.print("Enter a region: ");
        String region = scanner.nextLine();
        System.out.print("Enter a country: ");
        String countryName = scanner.nextLine();
        String response = locationController.addNewLocation(locationName, region, countryName);
        System.out.println("The new entry has been added: " + response + "\n");
    }

    private void printLocationList() {
        System.out.println(locationController.findAll());
    }

    private void printWeatherList() {
        System.out.println(weatherController.findAll());
    }

}
