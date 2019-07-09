//package com.spring.springdemo.DAO;
//
//import com.spring.springdemo.Entity.User;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class UserDAOImpl implements UserDAO {
//
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<User> getUsers() {
//
//        //getting current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        //creating query
//        Query<User> theQuery = currentSession.createQuery("from User order by username", User.class);
//
//        // returning results
//        return theQuery.getResultList();
//    }
//
//    @Override
//    public void addUser(User theUser) {
//
//        //getting current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        //save User in database
//        currentSession.saveOrUpdate(theUser);
//
//    }
//
//    @Override
//    public User getUser(int theId) {
//
//        //getting current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        //retrieving user from database
//        User theUser = currentSession.get(User.class, theId);
//
//        //return the user
//        return theUser;
//    }
//
//    @Override
//    public void deleteUser(int theId) {
//
//        //getting current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        //creating query to delete user from database
//        Query theQuery = currentSession.createQuery("delete from User where id=:theUserId");
//        theQuery.setParameter("theUserId" , theId);
//
//        //confirm deleted User in database
//        theQuery.executeUpdate();
//    }
//
//    @Override
//    public List<User> searchUsers(String theSearchName) {
//
//        // get the current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        Query<User> theQuery;
//
//        //
//        // only search by name if theSearchName is not empty
//        //
//        if (theSearchName != null && theSearchName.trim().length() > 0) {
//
//            // search for firstName or lastName ... case insensitive
//            theQuery =currentSession.createQuery("from User where lower(username) like :theName order by username", User.class);
//            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
//
//        }
//        else {
//            // theSearchName is empty ... so just get all customers
//            theQuery =currentSession.createQuery("from User order by username", User.class);
//        }
//
//        // execute query and get result list
//        // return the results
//        return theQuery.getResultList();
//    }
//}
