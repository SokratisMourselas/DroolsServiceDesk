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
            System.out.println("Connecting to Database");

            User newUser = new User();
            newUser.setUsername("Sokratis");
            session.beginTransaction();
            session.save(newUser);
            session.getTransaction().commit();

            System.out.println("<<Connection successful>>");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

}
