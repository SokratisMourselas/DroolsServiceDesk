package com.spring.springdemo.DAO;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(public void com.spring.springdemo.DAO.*DAO.add*())")
    public void beforeAddUserAdvice() {
        System.out.println("Executing @Before on addAccount()");
    }

}
