package com.spring.springdemo.Controllers;

import com.spring.springdemo.Model.Request;
import com.spring.springdemo.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/requests")
public class RequestController {

    @RequestMapping("/addRequest")
    public String addNewRequest(@ModelAttribute("user") User theUser, Model theModel){

//        System.out.println("RequestController.class >> The username is set to: "+ theUser.getUsername());

        Request theRequest = new Request();

        theRequest.setUser(theUser);

        theModel.addAttribute("newRequest", theRequest);

        return "new-request-page";

    }

    @RequestMapping("/addRequest-form")
    public String addNewRequestForm(@ModelAttribute("newRequest") Request requestMessage, Model theModel){

//        System.out.println("Message: "+ requestMessage.getMessage());
//        System.out.println("Message creator: "+ requestMessage.getUser().getUsername());

        theModel.addAttribute("user", new User(requestMessage.getUser().getUsername()));

        return "actions-page-return";
    }
}
