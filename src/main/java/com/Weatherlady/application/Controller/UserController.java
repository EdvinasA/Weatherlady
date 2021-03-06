package com.Weatherlady.application.Controller;

import com.Weatherlady.application.Service.UserService;

import java.util.Scanner;

public class UserController {

    private final UserService userService = new UserService();

    public boolean logInInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
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
                    return false;
            }
        }
    }

    private boolean logInUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account User Name:");
        String userName = scanner.nextLine();
        System.out.println("Enter your account password:");
        String password = scanner.nextLine();
        return userService.loginUser(userName, password);
    }

    private boolean registerUser () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account User Name:");
        String userName = scanner.nextLine();
        System.out.println("Enter account password:");
        String password = scanner.nextLine();
        return userService.registerUser(userName, password);
    }

    private void loginInMenu() {
        System.out.println("1.Sign in.");
        System.out.println("2.Register.");
        System.out.println("3.Exit the application.");
    }


}
