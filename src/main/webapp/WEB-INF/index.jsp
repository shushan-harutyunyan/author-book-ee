<%@ page import="authorbookee.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<%  User user = (User) session.getAttribute("user");%>
<% if (user != null) {%>
<span> Welcome! <%=user.getName()%></span> <a href="/logout">Log out</a>
<%} else { %>
<a href="/login"> Login </a>
<a href="/register"> Register </a>
<% }; %>
<br>
<a href="/books">View All Books</a>
<a href="/authors">View All Authors</a>

</body>
</html>