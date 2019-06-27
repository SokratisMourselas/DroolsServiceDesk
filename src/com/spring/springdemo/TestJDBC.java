package com.spring.springdemo;

import com.spring.springdemo.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJDBC {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("\nConnecting to Database");

            User newUser = new User();
            newUser.setUsername("Sokratis");
            newUser.setPassword("ExamplePassword");
            newUser.setEmail("example@springMVC.com");
            session.beginTransaction();
            session.save(newUser);

            System.out.println("\nRetrieving a User: ");

            User userFromDb = session.get(User.class, 1);
            session.getTransaction().commit();

            System.out.println("<<Connection successful>>");

            System.out.println(userFromDb);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

}
