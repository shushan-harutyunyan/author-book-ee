<%@ page import="authorbookee.model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shharutyunyan
  Date: 05.02.25
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>books</title>
</head>
<body>
<h1>Books</h1>
<% List<Book> books = (List<Book>) request.getAttribute("books")%>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>price</th>
        <th>qty</th>
        <th>author name</th>
    </tr>
    <% for (Book book : books){ %>
    <tr>
        <td><%=book.getId()%></td>
        <td><%=book.getTitle()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getQty()%></td>
        <td><%=book.getAuthor()%></td>

    </tr>
    <% } %>
</table>
</body>
</html>
