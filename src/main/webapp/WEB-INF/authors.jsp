<%@ page import="authorbookee.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="authorbookee.util.DateUtil" %>
<%@ page import="authorbookee.model.User" %>
<%@ page import="authorbookee.model.UserType" %><%--
  Created by IntelliJ IDEA.
  User: shharutyunyan
  Date: 04.02.25
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<hi>Authors</hi>
<a href="/addAuthor">Add Author</a>
Authors:
<%
    User user = (User) session.getAttribute("user");
    List<Author> authorList = (List<Author>)request.getAttribute("authors"); %>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>phone</th>
        <th>dob</th>
        <th>gender</th>
        <%
        if(user.getUserType() != null && user.getUserType() == UserType.admin){ %>
        <th>action</th>
        <%}%>
        <th>action</th>
    </tr>
    <% for (Author author : authorList){ %>
        <tr>
            <td><%=author.getId()%></td>
            <td><%=author.getName()%></td>
            <td><%=author.getSurname()%></td>
            <td><%=author.getPhone()%></td>
  <td><%=DateUtil.fromDateToString(author.getDateOfBirth())%></td>
            <td><%=author.getGender().name()%></td>
            <%         if(user.getUserType() != null && user.getUserType() == UserType.admin){ %>
            <td><a href="/deleteAuthor?id=<%author.getId();%>"> Delete </a>
                <a href="/editAuthor?id=<%author.getId();%>"> Edit </a></td>
<% }%>
        </tr>
<% }%>
</table>
</body>
</html>
