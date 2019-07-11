package com.spring.springdemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember() {
        System.out.println(getClass() + " --> DB work in addMember()");

        return true;
    }

}
