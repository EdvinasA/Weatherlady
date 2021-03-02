package com.Weatherlady.application.Controller;

import com.Weatherlady.application.Service.UserService;

public class UserController {

    private final UserService userService = new UserService();



    private void loginInMenu() {
        System.out.println("1.Sign in.");
        System.out.println("2.Register.");
    }


}
