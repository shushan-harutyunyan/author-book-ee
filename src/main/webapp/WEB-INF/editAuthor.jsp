<%@ page import="authorbookee.model.Author" %>
<%@ page import="authorbookee.model.Gender" %>
<%@ page import="authorbookee.util.DateUtil" %><%--
  Created by IntelliJ IDEA.
  User: shharutyunyan
  Date: 05.02.25
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Author</title>
</head>
<body>
<%Author author = (Author) request.getAttribute("author"); %>
<hi>Edit Author</hi>
<a href="/authors">Authors</a>
<a href="index.jsp">Main</a> <br>
<form action="/editAuthor" method="post">
    Id: <input type="text" name="id" value="<%author.getId();%>" disabled>
    Name: <input type="text" name="name" value="<%author.getName();%>"><br>
    Surname: <input type="text" name="surname" value="<%author.getSurname();%>"><br>
    Phone:  <input type="text" name="phone" value="<%author.getPhone();%>"><br>
    Date of Birth: <input type="date" name="dob" value="<%DateUtil.fromDateToWebString(author.getDateOfBirth());%>"><br>
    Gender: <select name="gender">
    <%if (author.getGender() == Gender.MALE){%>
    <option value="Male" selected>Male</option>
    <option value="Female">Female</option>
    <%}else{%>
    <option value="Male">Male</option>
    <option value="Female" selected>Female</option>
    <%}%>
    <br>
</select>
    <input type="submit" value="Update">

</form>
</body>
</html>
