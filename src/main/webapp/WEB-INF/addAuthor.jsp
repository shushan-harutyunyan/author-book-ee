<%--
  Created by IntelliJ IDEA.
  User: shharutyunyan
  Date: 05.02.25
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
<hi>Add Author</hi>
<a href="/authors">Authors</a>
<a href="index.jsp">Main</a> <br>
<form action="/addAuthor" method="post">
    Name: <input type="text" name="name"><br>
    Surname: <input type="text" name="surname"><br>
    Phone:  <input type="text" name="phone"><br>
    Date of Birth: <input type="date" name="dob"><br>
    Gender: <select name="gender">
    <option value="Male">Male</option>
    <option value="Female">Female</option>
    <br>
</select>
    <input type="submit" value="Add">

</form>
</body>
</html>
