package com.spring.springdemo;

import com.spring.springdemo.Config.DemoConfig;
import com.spring.springdemo.DAO.AccountDAO;
import com.spring.springdemo.DAO.MembershipDAO;
import com.spring.springdemo.Entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {
        //context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // retrieving bean from context
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //adding account to check @Before Aspect expression
        accountDAO.addAccount(123, "String Placeholder");
        membershipDAO.addMember();

        System.out.println("<------------       Adding random Accounts      ------------>\n");
        List<Account> list = accountDAO.findAllAccounts();

        accountDAO.printAccounts(list);

        context.close();

    }

}
