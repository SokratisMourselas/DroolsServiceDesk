package com.spring.springdemo.Controllers;


import com.spring.springdemo.DAO.UserDAO;
import com.spring.springdemo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequestMapping("/users")
public class UserController {

    //injecting UserDAO
    @Autowired
    private UserDAO userDAO;


    @RequestMapping("/list")
    public String listCustomers(Model theModel){

        //get users from dao

        List<User> theUsers = userDAO.getUsers();

        // add users to the SpringMVC model
        theModel.addAttribute("users", theUsers);

        return "list-users";
    }

}
