<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/10/2022
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>
<body>
<form action="/display-discount" method="post">
    Product Description:<input type="text" id="description" name="description">
    List Price:<input type="text" id="price" name="price">
    <br><br>
    Discount Percent:<input id="discount" name="discount">
    <br><br>
    <input type = "submit" id = "submit" value = "Discount"/>
    <br><br>
</form>
</body>
</html>