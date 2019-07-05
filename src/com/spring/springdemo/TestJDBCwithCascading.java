package com.spring.springdemo;

import com.spring.springdemo.Model.Request;
import com.spring.springdemo.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJDBCwithCascading {

    public static void main(String[] args) {

        System.out.println("\nConnecting to Database");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Request.class).addAnnotatedClass(User.class).buildSessionFactory();
        System.out.println("<<Connection successful>>\n");

        Session session = factory.getCurrentSession();
        User theUser = new User();

        try {

            //Beginning Transaction
            session.beginTransaction();

            theUser = session.get(User.class, 3);

            System.out.println(theUser);
            System.out.println(theUser.getRequestList());

            session.getTransaction().commit();

            session.close();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

}
