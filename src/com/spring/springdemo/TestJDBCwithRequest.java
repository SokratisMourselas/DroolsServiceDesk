package com.spring.springdemo;

import com.spring.springdemo.Model.Request;
import com.spring.springdemo.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;

public class TestJDBCwithRequest {

    public static void main(String[] args) {

        System.out.println("\nConnecting to Database");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Request.class).addAnnotatedClass(User.class).buildSessionFactory();
        System.out.println("<<Connection successful>>\n");

        Session session = factory.getCurrentSession();

        try {
            // Creating a dummy User
//            User newUser = new User();
//            newUser.setUsername("Sokratis MOURSELAS");
//            newUser.setPassword("ExamplePassword");
//            newUser.setEmail("example@springMVC.com");

            //Beginning Transaction
            session.beginTransaction();

            User newUser = session.get(User.class,3 );

            // Creating a dummy Request
            Request newRequest = new Request();
            newRequest.setUser(newUser);
            newRequest.setMessage("Another dummy message from a dummy user");
            newRequest.setProjectName("NCTS 5.1");
            newRequest.setRule("C0557");
            newRequest.setTeamDirectedTo("DEV");

            //Saving the Dummy Request
            session.save(newRequest);

            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

}
