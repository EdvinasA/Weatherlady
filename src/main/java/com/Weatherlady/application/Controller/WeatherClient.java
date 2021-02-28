package com.Weatherlady.application.Controller;



import java.util.Scanner;


public class WeatherClient {

    private final LocationController locationController = new LocationController();
    private final WeatherController weatherController = new WeatherController();

    public void runClientInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your application has started");

        while (true) {
            System.out.println("Welcome to the weather app what you want to do: ");
            System.out.println("1. Add a new location to the database");
            System.out.println("2. View currently added locations");
            System.out.println("3. Download weather values");
            System.out.println("4. Exit the application");

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    addNewEntry();
                    break;
                case 2:
                    readAllEntries();
                    break;
                case 3:
                    getWeather();
                    break;
                case 4:
                    System.out.println("Your application is shutting down");
                    return;
            }
        }
}
    private void getWeather() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name for the location: ");
        String cityName = scanner.nextLine();
        System.out.println("Enter how many days ahead you would like to download the forecast: (1-5)");
        Integer daysToAdd = scanner.nextInt();

        String response = weatherController.getWeatherValues(cityName, daysToAdd);
        System.out.println("Your forecast: " + response);
    }
    private void addNewEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name for the location: ");
        String locationName = scanner.nextLine();
        System.out.print("Enter the longitude, an integer from the range: -180(W) do 180(E): ");
        String longitude = scanner.nextLine();
        System.out.print("Enter the latitude, integer from range: -90(S) do 90(N): ");
        String latitude = scanner.nextLine();
        System.out.print("Enter a region: ");
        String region = scanner.nextLine();
        System.out.print("Enter a country: ");
        String countryName = scanner.nextLine();
        String response = locationController.addNewLocation(locationName, longitude, latitude, region, countryName);
        System.out.println("The new entry has been added: " + response + "\n");
    }
    private void readAllEntries() {
        String response = locationController.readAllLocations();
        response = response.replaceAll("\\[]", "\n")
                .replaceAll("\\{", "\n")
                .replaceAll("\\}", "")
                .replaceAll("\\]", "");

        System.out.println("Your entries: " + response);
    }

}