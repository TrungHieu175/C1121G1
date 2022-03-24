<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/22/2022
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        input {
            font-size: small;
        }
    </style>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <tr>
        <h2>
            <a href="/customers?action=create">Add New User</a>
            <br>
            <a href="/customers?action=customers">Back To List</a>
        </h2>
    </tr>
    <tr>
        <form action="/customers" method="get">
            <div class="input-group mt-3 mb-3">
                <div class="input-group-prepend">
                    <select class="btn-outline-primary" name="" id="" onchange="changeValueSearch(this)">
                        <option value="searchByName">Search By Name</option>
                        <option value="searchById">Search By ID</option>
                        <option value="searchByAddress">Search By Address</option>
                    </select>
                </div>
                <input type="hidden" value="searchByName" name="search">
                <input class="form-control" value="${searchValue}" name="searchValue" type="text" id="searchName">
                <input type="text" id="action" name="action" value="searchByName" hidden>
                <input class="btn-outline-primary" type="submit" value="Search">
            </div>
        </form>
    </tr>
</center>
<div align="center">
</div>
<table border="1" id="example" class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Code</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>IdCard</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>TypeName</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customers" items="${customerList}">
        <tr>
            <td><c:out value="${customers.id}"/></td>
            <td><c:out value="${customers.code}"/></td>
            <td><c:out value="${customers.name}"/></td>
            <td><c:out value="${customers.birthday}"/></td>
            <td>
                <c:choose>
                    <c:when test="${customers.gender == 0}">Nữ</c:when>
                    <c:when test="${customers.gender == 1}">Nam</c:when>
                </c:choose>
            </td>
            <td><c:out value="${customers.idCard}"/></td>
            <td><c:out value="${customers.phone}"/></td>
            <td><c:out value="${customers.email}"/></td>
            <td><c:out value="${customers.address}"/></td>
            <td><c:out value="${customers.typeName}"/></td>
            <td>
                <button onclick="deleteCustomer('${customers.id}','${customers.name}')" type="button"
                        class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
                    Delete
                </button>
                <a class="btn btn-primary" href="/customers?action=update&id=${customers.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Modal Delete -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Are You Sure?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure delete <span class="text-danger" id="customer-name"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>
<form hidden id="form-delete" method="post" action="/customers?action=delete&id=${customers.id}">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="customer-id">
</form>
<!-- Modal -->

</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    $.extend(true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": false
    });
    $(document).ready(function () {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    });
</script>
<script>
    function deleteCustomer(id, name) {
        document.getElementById("customer-id").value = id;
        document.getElementById("customer-name").innerText = name;
    }

    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>
<script>
    function changeValueSearch(taget) {
        document.getElementById("action").value = taget.value;
    }
</script>
</html>