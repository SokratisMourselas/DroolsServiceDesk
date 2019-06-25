<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>
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
<i>How would you like to proceed ${user.username}?</i>
<hr>

<%--<ul>--%>
    <%--<li><a href="/requests/addRequest">New Request</a></li>--%>
    <%--<li><a href="/requests/listOfRequests">List of requests</a></li>--%>
<%--</ul>--%>

<form:form action="/requests/addRequest" modelAttribute="user">
    <form:input path="username" readonly="true"/>
    <input type="submit" value="New Request">
</form:form>


</body>
</html>