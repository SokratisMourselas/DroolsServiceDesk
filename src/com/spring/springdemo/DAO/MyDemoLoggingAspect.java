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

    @Pointcut("execution(* com.spring.springdemo.DAO.*DAO.get*())")
    private void getter(){}

    @Pointcut("execution(* com.spring.springdemo.DAO.*DAO.set*())")
    private void setter(){}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    private void forDAOPackageNoGetterSetter(){}

    @Before("forDAOPackage()")
    public void beforeAddUserAdvice() {
        System.out.println("\n   =======   >>>>> Executing @Before on add*()");
    }

    @Before("forDAOPackageNoGetterSetter()")
    public void printAnalyticsForAddMethods(){
        System.out.println("   =======   >>>>> Performing some API Analytics");
    }

}
