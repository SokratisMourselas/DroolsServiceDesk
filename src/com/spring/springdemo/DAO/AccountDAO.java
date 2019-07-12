package com.spring.springdemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(int i, String value) {
        System.out.println(getClass() + " --> DB work in addAccount()");
    }

}
