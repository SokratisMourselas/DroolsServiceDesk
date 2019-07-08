package com.spring.springdemo.DAO;

import com.spring.springdemo.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> getUsers() {

        //getting current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //creating query
        Query<User> theQuery = currentSession.createQuery("from User", User.class);

        // returning results
        return theQuery.getResultList();
    }
}
