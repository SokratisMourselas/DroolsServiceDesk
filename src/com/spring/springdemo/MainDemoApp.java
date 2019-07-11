package com.spring.springdemo;

import com.spring.springdemo.Config.DemoConfig;
import com.spring.springdemo.DAO.AccountDAO;
import com.spring.springdemo.DAO.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        //context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // retrieving bean from context
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //adding account to check @Before Aspect expression
        accountDAO.addAccount();
        membershipDAO.addMember();
        context.close();

    }

}
