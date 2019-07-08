package com.spring.springdemo.TestDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class Servlet extends javax.servlet.http.HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "root";
        String password = "root";
        String jdbcUrl = "jdbc:mysql://localhost:3306/springdrools?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        //getting connection
        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to: "+ jdbcUrl);
            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            out.println("CONNECTION SUCCESSFUL!!!!");
            myConn.close();

        } catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
