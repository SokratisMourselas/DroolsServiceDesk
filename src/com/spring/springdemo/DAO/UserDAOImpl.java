package com.spring.springdemo.DAO;

import com.spring.springdemo.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {

        //getting current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //creating query
        Query<User> theQuery = currentSession.createQuery("from User order by username", User.class);

        // returning results
        return theQuery.getResultList();
    }

    @Override
    public void addUser(User theUser) {

        //getting current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //save User in database
        currentSession.save(theUser);

    }
}
