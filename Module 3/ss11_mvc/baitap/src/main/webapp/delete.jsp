<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/15/2022
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name Product:</td>
                <td>${requestScope["products"].getName()}</td>
            </tr>
            <tr>
                <td>Price Product:</td>
                <td>${requestScope["products"].getPrice()}</td>
            </tr>
            <tr>
                <td>Description Product:</td>
                <td>${product.getDescription()}</td>
            </tr>
            <tr>
                <td>Producer:</td>
                <td>${requestScope["products"].getProducer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>