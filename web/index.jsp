<%--
  Created by IntelliJ IDEA.
  User: smoursel
  Date: 24-Jun-19
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% response.sendRedirect("/users/list");%>--%>
<html>
  <head>
    <title>Drools Service Desk Application</title>
  </head>
  <body>
  <h1>Welcome to Drools Service Desk (Local Version)</h1>
  <hr>
  <%--<a href="/login/proceed">Proceed</a>--%>
  <a href="${pageContext.request.contextPath}/users/list">Proceed</a>
  <a href="${pageContext.request.contextPath}/accounts/list">Proceed</a>

  </body>
</html>
