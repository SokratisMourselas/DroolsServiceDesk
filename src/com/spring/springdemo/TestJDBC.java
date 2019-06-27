package com.spring.springdemo;

import com.spring.springdemo.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;

public class TestJDBC {

    public static void main(String[] args) {

        System.out.println("\nConnecting to Database");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
        System.out.println("<<Connection successful>>\n");

        Session session = factory.getCurrentSession();

        try {
            // Creating a dummy User
            User newUser = new User();
            newUser.setUsername("Sokratis MOURSELAS");
            newUser.setPassword("ExamplePassword");
            newUser.setEmail("example@springMVC.com");

            //Beginning Transaction
            session.beginTransaction();

            //Saving the Dummy User
            session.save(newUser);

            newUser.setPassword("ChangedPassword");


            // Retrieving and checking if the User was created
            System.out.println("\n<<Retrieving a Dummy User>>");
            User userFromDb = new User();

            String customHQLQuery = "from User u where u.username LIKE '%MOURSELAS'";

            try {
                userFromDb =(User) session.createQuery(customHQLQuery).getSingleResult();
            } catch (NoResultException n){

            }

            System.out.println("Dummy User successfully retrieved: \n"+ userFromDb);

            // Truncating table
            session.delete(newUser);
            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

}
