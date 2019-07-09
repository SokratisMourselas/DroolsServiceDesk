package com.spring.springdemo.DAO;

import com.spring.springdemo.Entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void addUser(User theUser);

    User getUser(int theId);

    void deleteUser(int theId);
}
