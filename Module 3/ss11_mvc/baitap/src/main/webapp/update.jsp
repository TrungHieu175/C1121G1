<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/15/2022
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<h1>Edit product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <<tr>
            <td>Name Product:</td>
            <td><input type="text" name="name" id="name" value="${products.name}"/></td>
        </tr>
            <tr>
                <td>Price Product:</td>
                <td><input type="text" name="price" id="price" value="${products.price}"/></td>
            </tr>
            <tr>
                <td>Description Product:</td>
                <td><input type="text" name="description" id="description" value="${products.description}"/></td>
            </tr>
            <tr>
                <td>Producer:</td>
                <td><input type="text" name="producer" id="producer" value="${products.producer}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>