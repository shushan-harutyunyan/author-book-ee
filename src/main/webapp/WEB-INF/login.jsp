<%--
  Created by IntelliJ IDEA.
  User: shharutyunyan
  Date: 15.02.25
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    if(session.getAttribute("msg") != null) {%>
<h3><%=session.getAttribute("msg")%></h3>
<% session.removeAttribute("msg");
    } %>
<form action="/login" method = "post">
    email: <input type="text" name = "email">
    password: <input type="password" name = "password"><br>
    <input type="submit">
</form>
</body>
</html>
