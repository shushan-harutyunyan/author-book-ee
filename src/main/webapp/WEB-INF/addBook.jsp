<%@ page import="authorbookee.model.Author" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shharutyunyan
  Date: 05.02.25
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<%List<Author> authors = (List<Author>) request.getAttribute("authors");%>
<hi>Add Book</hi>
<a href="/books">Books Page</a>
<a href="index.jsp">Main</a> <br>
<form action="/addBook" method="post" enctype="multipart/form-data">
    Title: <input type="text" name="title"><br>
    Price: <input type="number" name="price"><br>
    Quantity:  <input type="number" name="qty"><br>
    Author: <select name="author_id">
    <% for (Author author: authors){ %>
    <option value="<%=author.getId()%>"><%=author.getName()%>
    </option>
    <%}%>
</select><br>
    <input type="file" name="img">
    <input type="submit" value="Add">

</form>
</body>
</html>
