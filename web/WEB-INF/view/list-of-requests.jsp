<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of requests page</title>
    <style>
        .error{color: red}
    </style>
    <style>
        .correct{color: green}
    </style>
</head>
<body>
<h1>List of requests</h1><br>
<a href="/login/loginForm">Go Back</a>
<br><br>
<hr>

<form:form action="">
<table border="1">
    <tr>
        <th>No.</th>
        <th>Project Name</th>
        <th>Directed to</th>
        <th>Message Body</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="temp" items="${listOfRequests}">
       <tr>
           <td>${temp.key}</td>
           <td>${temp.value.projectName}</td>
           <td>${temp.value.teamDirectedTo}</td>
           <td>${temp.value.message}</td>
           <td><input type="submit" value="View"/></td>
       </tr>
    </c:forEach>
</table>
</form:form>


</body>
</html>