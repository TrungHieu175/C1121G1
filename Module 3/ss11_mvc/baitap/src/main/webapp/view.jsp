<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/15/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["products"].getName()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope["products"].getEmail()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["products"].getAddress()}</td>
    </tr>
</table>
</body>
</html>