package com.spring.springdemo.Controllers;

import com.spring.springdemo.Entity.Request;
import com.spring.springdemo.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/viewAllRequests")
    public String viewAllRequests(Model theModel){
        List<Request> listOfRequests = createMockListOfRequests();

        Map<Integer,Request> mapOfRequests = new HashMap<Integer,Request>();

        mapOfRequests.put(1, listOfRequests.get(0));
        mapOfRequests.put(2, listOfRequests.get(1));

        theModel.addAttribute("listOfRequests", mapOfRequests);
        return "list-of-requests";
    }




    private List<Request> createMockListOfRequests() {
        User user = new User();
        user.setUsername("John Appleseed");

        Request request = new Request();
        request.setUser(user);
        request.setProjectName("NCTS 5.1");
        request.setTeamDirectedTo("DEV");
        request.setMessage("Loren Ipsum Dolor et mpla sushi and mplampla");

        Request request2 = new Request();
        request2.setUser(user);
        request2.setProjectName("NCTS 5.1");
        request2.setTeamDirectedTo("DEV");
        request2.setMessage("Loren Ipsum Dolor et mpla sushi and mplampla");

        List<Request> listOfRequests = new ArrayList<Request>();
        listOfRequests.add(request);
        listOfRequests.add(request2);

        return listOfRequests;
    }
}
