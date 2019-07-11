package com.spring.springdemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + " --> DB work in addAccount()");
    }

}
