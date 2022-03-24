<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/22/2022
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Update Customer
                </h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
            </c:if>
            <tr>
            <tr>
                <th>Mã khách hàng:</th>
                <td>
                    <input required type="text" name="code" id="code" size="45" value="<c:out value='${customer.code}' />"/>
                </td>
            </tr>
            <tr>
                <th>Họ và tên:</th>
                <td>
                    <input required type="text" name="name" id="name" size="45" value="<c:out value='${customer.name}' />"/>
                </td>
            </tr>
            <tr>
                <th>Ngày sinh :</th>
                <td>
                    <input required type="date" name="birthday" id="birthday" size="45" value="<c:out value='${customer.birthday}' />"/>
                </td>
            </tr>
            <tr>
            <tr>
                <th>Giới tính:</th>
                <td>
                    <input type="radio" id="gender1" name="gender" value="1">
                    <label for="gender1">Nam</label><br>
                    <input type="radio" id="gender2" name="gender" value="0">
                    <label for="gender2">Nữ</label><br>
                </td>
            </tr>
            <tr>
                <th>Số căn cước/CMND:</th>
                <td>
                    <input required type="text" name="idCard" id="idCard" size="45" value="<c:out value='${customer.idCard}' />"/>
                </td>
            </tr>
            <tr>
                <th>Điện thoại:</th>
                <td>
                    <input required type="text" name="phone" id="phone" size="45" value="<c:out value='${customer.phone}' />"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input required type="text" name="email" id="email" size="45" value="<c:out value='${customer.email}' />"/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input required type="text" name="address" id="address" size="45" value="<c:out value='${customer.address}' />"/>
                </td>
            </tr>
            <tr>
                <th>Loại khách hàng:</th>
                <td>
                    <%--                    <input type="text" name="customerType" id="customerType" size="45"/>--%>
                    <select name="typeId" >
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <option value="${customerType.id}">${customerType.name}</option>
                        </c:forEach>
<%--                        <c:forEach var="customerType" items="${customerTypeList}">--%>
<%--                            <c:choose>--%>
<%--                                <c:when test="${customerType.id==customer.typeId}">--%>
<%--                                    <option value="${customerType.id}" selected>${customerType.name}</option>--%>
<%--                                </c:when>--%>
<%--                                <c:otherwise>--%>
<%--                                    <option value="${customerType.id}">${customerType.name}</option>--%>
<%--                                </c:otherwise>--%>
<%--                            </c:choose>--%>
<%--                        </c:forEach>--%>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
        <p>
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </p>
    </form>
</div>
</body>
</html>