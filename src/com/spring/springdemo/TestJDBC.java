package com.spring.springdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {


        String jdbcUrl = "jdbc:mysql://localhost:3306/springdrools?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";

        try {
            System.out.println("Connecting to Database");

            Connection myConn = DriverManager.getConnection(jdbcUrl,user, password);

            System.out.println("<<Connection successful>>");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
