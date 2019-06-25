<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Actions page</title>
    <style>
        .error{color: red}
    </style>
    <style>
        .correct{color: green}
    </style>
</head>
<body>
<h1>Actions Page</h1>
<i class="correct"> Logged in Successfully!</i>
<br><br>
<i>How would you like to proceed ${user.username!= null? user.username : "Username will appear here..."}?</i>
<hr>

<%--<ul>--%>
    <%--<li><a href="/requests/addRequest">New Request</a></li>--%>
    <%--<li><a href="/requests/listOfRequests">List of requests</a></li>--%>
<%--</ul>--%>

<form:form action="/requests/addRequest" modelAttribute="user">
    Your Username: <form:input path="username" readonly="true"/><br><br>
    <input type="submit" value="New Request">
</form:form>


<form:form action="/requests/viewAllRequests" >
    <input type="submit" value="View All Requests">
</form:form>


</body>
</html>