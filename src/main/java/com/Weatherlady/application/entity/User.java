package com.Weatherlady.application.entity;

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

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
