package com.spring.springdemo.Services;

import com.spring.springdemo.Entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void saveUser(User theUser);

    User getUser(int theId);

    void deleteCustomer(int theId);
}
