package com.spring.springdemo;

import com.spring.springdemo.Model.Comment;
import com.spring.springdemo.Model.Request;
import com.spring.springdemo.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestJDBCManyToManyRelationship {

    public static void main(String[] args) {

        System.out.println("\nConnecting to Database");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") .addAnnotatedClass(Request.class)
                                                                                    .addAnnotatedClass(User.class)
                                                                                    .addAnnotatedClass(Comment.class)
                                                                                    .buildSessionFactory();
        System.out.println("<<Connection successful>>\n");

        Session session = factory.getCurrentSession();

        try {

            //Beginning Transaction
            session.beginTransaction();

            // Getting a User from Database
            User newUser = session.get(User.class, 3);

            // creating the new Request
            Request newRequest = new Request();
            newRequest.setUser(newUser);
            newRequest.setMessage("Checking ManyToMany relation");
            newRequest.setProjectName("AES 1.1");
            newRequest.setRule("R0987");
            newRequest.setTeamDirectedTo("SPECS");


            User anotherUser = new User();
            anotherUser.setUsername("John Doe");
            anotherUser.setEmail("johndoe@gmail.com");
            anotherUser.setPassword("newPassword");

            // creating a comment
            Comment newComment = new Comment();
            newComment.setComment("This comment has been added with two users");
            session.save(newComment);
            newComment.setRequest(newRequest);
            newComment.addUser(newUser);
            newComment.addUser(anotherUser);

            // saving the new Request
            session.save(newRequest);
            System.out.println("Saved a request to add in comment: "+ newRequest);

            session.save(anotherUser);
            System.out.println("Saved another user to add in comment: "+ anotherUser);


            // adding comment to the request

            // saving the comment

            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

}
