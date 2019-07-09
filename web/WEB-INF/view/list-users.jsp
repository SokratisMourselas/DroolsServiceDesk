<%--
  Created by IntelliJ IDEA.
  User: smoursel
  Date: 08-Jul-19
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Users</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>

        <div id="container">

            <div id="content">

                <%-- buuton to add new User--%>
                <input type="button" value="Add User"
                       onclick="window.location.href='showFormForAdd'; return false;"
                       class="add-button">

                <table>
                    <tr>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print users -->
                    <c:forEach var="tempUser" items="${users}">

                        <c:url var="updateLink" value="/users/showFormForUpdate">
                            <c:param name="userId" value="${tempUser.id}"/>
                        </c:url>

                        <tr>
                            <td>${tempUser.username}</td>
                            <td>${tempUser.email.length() != 0? tempUser.email: "-"}</td>

                            <td><a href="${updateLink}">Update</a> </td>

                        </tr>

                    </c:forEach>

                </table>
            </div>

        </div>
    </div>


</body>
</html>
