package com.spring.springdemo.DAO;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.spring.springdemo.DAO.*DAO.add*())")
    private void forDAOPackage(){}

    @Before("forDAOPackage()")
    public void beforeAddUserAdvice() {
        System.out.println("\n   =======   >>>>> Executing @Before on add*()");
    }

    @Before("forDAOPackage()")
    public void printAnalytics(){
        System.out.println("   =======   >>>>> Performing some API Analytics");
    }

}
