package com.spring.springdemo.DAO;

import com.spring.springdemo.Entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Account> findAllAccounts() {

        Session currentSession = sessionFactory.getCurrentSession();

        //creating query
        Query<Account> theQuery = currentSession.createQuery("from Account order by name", Account.class);

        // returning results
        return theQuery.getResultList();

    }


}
