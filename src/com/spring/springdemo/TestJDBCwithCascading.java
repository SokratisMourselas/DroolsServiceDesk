package com.spring.springdemo;

import com.spring.springdemo.Model.Request;
import com.spring.springdemo.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

            Query<User> query = session.createQuery("select i from User i JOIN fetch i.requestList where i.id =:userId", User.class);
            query.setParameter("userId", 3);

//            theUser = session.get(User.class, 3);

            theUser = query.getSingleResult();

            System.out.println(theUser);
            System.out.println(theUser.getRequestList());

            session.getTransaction().commit();
            
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

}
