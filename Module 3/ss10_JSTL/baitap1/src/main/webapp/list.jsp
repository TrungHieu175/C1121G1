<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/11/2022
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .image{
            width: 150px;
            height: 100px;
        }
        table tr th {
            font-weight: bold;
        }
        table{
            width: 450px;
            height: auto;
        }
    </style>
</head>
<center>
<body>
<table border="1">
    <h1>Danh sách khách hàng</h1>
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customer}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${customer.name}</td>
            <td>${customer.birthDay}</td>
            <td>${customer.address}</td>
            <td><img src="${customer.avatar}" class="image" alt="ét ô ét"></td>
        </tr>
    </c:forEach>
</table>
</body>
</center>
</html>
