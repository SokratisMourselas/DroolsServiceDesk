<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>New Request page</title>
    <style>
        .error{color: red}
    </style>
    <style>
        .correct{color: green}
    </style>
</head>
<body>
<h1>New Request Page</h1>
<i class="correct"> Logged in as: ${user.username}</i>
<br><br>
<hr>

    <form:form action="/requests/addRequest-form" modelAttribute="newRequest">

        Related Project: <form:select path="projectName">
        <form:option value="AES 1.1">AES 1.1</form:option>
        <form:option value="NCTS 5.1">NCTS 5.1</form:option>
        <form:option value="ECS p2">ECS p2</form:option>
        <form:option value="NCTS p4">NCTS p4</form:option>
    </form:select>

        <br><br>

        Directed To: <form:select path="teamDirectedTo">
        <form:option value="DEV">Dev Team</form:option>
        <form:option value="SPECS">Specs Team</form:option>
        <form:option value="ANALYSTS">Analysts</form:option>
        <form:option value="TESTERS">Testing team</form:option>
    </form:select>
        <br><br>


        Message body:<br> <form:textarea cols="100" rows="5" path="message"/>
    <form:errors path="message" cssClass="error"/>
    <br><br>


    <input type="submit" value="Submit">
</form:form>



</body>
</html>