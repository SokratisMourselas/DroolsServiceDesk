package com.spring.springdemo.Controllers;


import com.spring.springdemo.Entity.User;
import com.spring.springdemo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Component
@RequestMapping("/users")
public class UserController {

    //injecting UserDAO
    @Autowired
    private UserService userService;


    @GetMapping("/list")
    public String listCustomers(Model theModel){

        //get users from dao
        List<User> theUsers = userService.getUsers();

        // add users to the SpringMVC model
        theModel.addAttribute("users", theUsers);

        return "list-users";
    }

    @GetMapping("/showFormForAdd")
    public String processForm(Model theModel){
        //create new model to bind data
        User newUser = new User();
        theModel.addAttribute("user", newUser);
        return "user-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult){

        if (theBindingResult.hasErrors()){
            return "user-form";
        }

        //save customer to database
        userService.saveUser(theUser);

        return "redirect:/users/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel){

        //get User from database
        User theUser = userService.getUser(theId);

        //set user as a model attribute to pre-populate
        theModel.addAttribute("user", theUser);

        //send over to the form

        return "user-form";
    }

    @GetMapping("delete")
    public String deleteUser(@RequestParam("userId") int theId){

        // delete the user
        userService.deleteCustomer(theId);

        return "redirect:/users/list";
    }
}
