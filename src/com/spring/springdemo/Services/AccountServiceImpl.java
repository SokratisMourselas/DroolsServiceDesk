package com.spring.springdemo.Services;

import com.spring.springdemo.DAO.AccountDAO;
import com.spring.springdemo.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDAO accountDAO;

    @Transactional
    public List<Account> getAccounts() {
        return accountDAO.findAllAccounts();
    }
}
