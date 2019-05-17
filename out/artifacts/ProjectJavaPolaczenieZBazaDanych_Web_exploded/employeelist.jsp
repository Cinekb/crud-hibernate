<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>



<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 14.04.2019
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListaEmployee</title>
</head>
<body>
<table>

    <tr>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Pensja</th>
        <th>Action</th>
    </tr>
    <c:forEach items='${employeeList}' var='employee'>
        <tr>

            <td>${employee.firstname}</td>
            <td>${employee.lastname}</td>
            <td>${employee.salary}</td>
            <td>
                <a href="<c:url value='/employee/remove'/>/${employee.idEmployee}">Remove</a>
                <a href="<c:url value='/employee/edit'/>/${employee.idEmployee}">Edit</a>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
