<%--
  Created by IntelliJ IDEA.
  User: smoursel
  Date: 09-Jul-19
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
    <style>
        .error{color: red}
    </style>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Add User</h3>

        <form:form action="saveUser" modelAttribute="user" method="post">

            <%--assosiating this data to the user id--%>
            <form:hidden path="id"/>

            <table>
                <tbody>
                    <tr>
                        <td><label>Username: </label></td>
                        <td><form:input path="username" /><form:errors path="username" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label>Password: </label></td>
                        <td><form:input path="password" /><form:errors path="password" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label>Email: </label></td>
                        <td><form:input path="email" /></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"/></td>
                    </tr>
                </tbody>
            </table>
        </form:form>
    </div>

    <div style="clear: both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/users/list">Back to List</a>
    </p>

</body>
</html>
