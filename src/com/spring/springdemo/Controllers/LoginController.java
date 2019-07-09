package com.spring.springdemo.Controllers;

import com.spring.springdemo.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/proceed")
    public String goToLoginPage(Model theModel) {

        User theUser = new User();
        theModel.addAttribute("user", theUser);
        return "proceed";
    }

    @RequestMapping("/loginForm")
    public String loginUser(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult) {

        if (theBindingResult.hasErrors()) {
            return "proceed";
        } else {
//            System.out.println("LoginController.class >> The username is set to: "+ theUser.getUsername());
            return "actions-page";
        }
    }


}
