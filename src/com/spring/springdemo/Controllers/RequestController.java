package com.spring.springdemo.Controllers;

import com.spring.springdemo.Model.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/requests")
public class RequestController {

    @RequestMapping("/addRequest")
    public String addNewRequest(Model theModel){

        Request theRequest = new Request();

        theModel.addAttribute("newRequest", theRequest);

        return "new-request-page";

    }

    @RequestMapping("/addRequest-form")
    public String addNewRequestForm(Model theModel){
        return "proceed";
    }
}
