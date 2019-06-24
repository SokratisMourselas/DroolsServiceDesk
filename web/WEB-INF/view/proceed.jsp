<%--
  Created by IntelliJ IDEA.
  User: smoursel
  Date: 24-Jun-19
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Login page</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>
    <h1>Login Page</h1>
    <i>Asterisk (*) means required field.</i>
    <br><br>
    <hr>

    <form:form action="/login/loginForm" modelAttribute="user">
        Username (*): <form:input path="username"/>
        <form:errors path="username" cssClass="error"/>
        <br><br>

        Password (*): <form:password path="password" />
        <form:errors path="password" cssClass="error"/>
        <br><br>
        <input type="submit" value="Submit">
    </form:form>

</body>
</html>
