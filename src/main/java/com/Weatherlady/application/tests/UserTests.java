package com.Weatherlady.application.tests;

import com.Weatherlady.application.entity.User;
import com.Weatherlady.application.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests {
    private final UserService userService = new UserService();

    @Test
    public void testRegisterUser() {
        //Given
        User user = userService.registerUser("Hello", "123456");

        //then
        assertEquals(user.getUserName(), "Hello");
        assertEquals(user.getPassword(), "123456");
    }

    @Test
    public void testRegisterUser_WithAlreadyRegisteredUser() {
        //Given
        User user = userService.registerUser("Hello", "123456");
        User user1 = userService.registerUser("Hello", "123456");

        //then
        assertNull(user1);
    }
}
