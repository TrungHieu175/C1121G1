<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/23/2022
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">

</head>

<body>

<style>
    h1, p {
        text-align: center;
    }

    form {
        display: inline-block;
    }
</style>


<h1>Customer list</h1>
<p>
    <a class="btn btn-success" href="/product?action=create">Add new Customer</a>
</p>


<form>
    Search By Name<input type="search" name="search" placeholder="Search">
    <input type="text" name="action" hidden value="search">
    <input type="submit" value="search" hidden>
</form>

<table border="1" id="product" class="table table-striped table-bordered" style="width:100%">
    <thead>
    <tr>

        <td scope="col">STT</td>
        <td scope="col">Product Name</td>
        <td scope="col">Product Price</td>
        <td scope="col">Product Quantity</td>
        <td scope="col">Product Color</td>
        <td scope="col">Product Category</td>
        <td scope="col">Action</td>
        <td scope="col">Delete</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}">
        <tr>

            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.productPrice}</td>
            <td>${product.productQuantity}</td>
            <td>${product.productColor}</td>
            <td>${product.categoryName}</td>

            <td>
                <a class="btn btn-warning" href="/product?action=update&id=${product.productId}">Edit</a>
            </td>
            <td>
                <button onclick="deleteCustomer('${product.productId}','${product.productName}')" type="button"
                        class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure delete <span class="text-danger" id="product-name"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>

<form hidden id="form-delete" method="post" action="/product?action=delete=${product.productId}">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="product-id">
</form>


<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(document).ready(function () {
        $('#product').DataTable();
    });
</script>

<script>
    function deleteCustomer(id, name) {
        document.getElementById("product-id").value = id;
        document.getElementById("product-name").innerText = name;
    }

    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>

</body>
</html>