package com.spring.springdemo.Controllers;


import com.spring.springdemo.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/users")
public class UserController {

    //injecting UserDAO
    @Autowired
    private UserDAO userDAO;


    @RequestMapping("/list")
    public String listCustomers(Model theModel){

        //get users from dao


        //add customers to SpringMVC model

        return "list-users";
    }

}
