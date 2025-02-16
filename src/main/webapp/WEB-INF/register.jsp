<%--
  Created by IntelliJ IDEA.
  User: shharutyunyan
  Date: 15.02.25
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<span>
    <%
        if(session.getAttribute("msg") != null) {%>
            <h3><%=session.getAttribute("msg")%></h3>
    <% session.removeAttribute("msg");
        } %>
</span>
<form action="/register" method = "post">
    name: <input type="text" name="name"><br>
    surname" <input type="text" name="surname"><br>
  email: <input type="text" name="email">
  password: <input type="password" name="password">
  user type:
  <select name="user_type">
      <option value="user">User</option>
      <option value="admin">Admin</option>
  </select><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
