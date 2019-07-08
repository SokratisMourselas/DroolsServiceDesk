package com.spring.springdemo.Controllers;


import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/list")
    public String listCustomers(Model theModel){
        return "list-users";
    }

}
