package com.spring.springdemo.DAO;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.spring.springdemo.DAO.*DAO.add*(..))")
    private void forDAOPackage(){}

    @Pointcut("execution(* com.spring.springdemo.DAO.*DAO.get*())")
    private void getter(){}

    @Pointcut("execution(* com.spring.springdemo.DAO.*DAO.set*())")
    private void setter(){}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    private void forDAOPackageNoGetterSetter(){}

    @Before("forDAOPackage()")
    public void beforeAddUserAdvice(JoinPoint joinPoint) {

        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        System.out.println(" \n " + methodSig + "\n   =======   >>>>> Executing @Before on add*()");

        Object[] args = joinPoint.getArgs();

        for (Object tempArg: args){

            if (tempArg instanceof String){
                System.out.println("'String' arg with value: " + ((String) tempArg).toUpperCase());
            } else {
                System.out.println("int: " + tempArg);
            }
        }

    }

    @Before("forDAOPackageNoGetterSetter()")
    public void printAnalyticsForAddMethods(){
        System.out.println("   =======   >>>>> Performing some API Analytics");
    }


    @Pointcut("execution(* com.spring.springdemo.DAO.*DAO.print*(..))")
    private void forDAOPackageFindMethods(){}


    @AfterReturning("forDAOPackageFindMethods()")
    public void printAnalyticsForAddMethodsOnReturn(JoinPoint joinPoint){
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        System.out.println(methodSig+"   =======   >>>>> Accounts Returned successfully");
    }



}
