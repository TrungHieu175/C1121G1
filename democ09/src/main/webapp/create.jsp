<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/23/2022
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/product?action=create" method="post">

                <div class="form-group">
                    <label for="customer_code">Product Name</label>
                    <input type="text" class="form-control" id="customer_code" name="product_name">
                </div>

                <div class="form-group">
                    <label for="customer_name">Price</label>
                    <input type="text" class="form-control" id="customer_name" name="product_price">
                </div>

                <div class="form-group">
                    <label for="customer_birthday">Quality</label>
                    <input type="text" class="form-control" id="customer_birthday" name="product_quantity">
                </div>
                <div class="form-group">
                    <label for="customer_gender">Color</label>
                    <input class="form-control" id="customer_gender" name="product_color">
                </div>
                <div class="form-group">
                    <label for="category">Category</label>
                    <select class="form-control" id="category" name="category_id">
                        <c:forEach var="type" items="${categoryList}">
                            <option value="${type.categoryId}">${type.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <a class="btn btn-success" href="/product">Back to list</a>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
