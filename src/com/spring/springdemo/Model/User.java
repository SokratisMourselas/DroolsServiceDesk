package com.spring.springdemo.Model;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class User {

    @NotNull(message = "*is required")
    @Size(min = 1, message = "*is required")
    private String username;

    @NotNull(message = "*is required")
    @Size(min = 1, message = "*is required")
    private String password;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
