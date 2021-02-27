package com.Weatherlady.application.UserInterface;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, name = "User_Name")
    private String userName;

    @Column(nullable = false, name = "Password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
