
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>--%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>--%>
<html>
<head>
    <title>Formularz Edytujacy pracownika</title>
</head>
<body>
<%--<form action="employeelist/edit/" method="GET">--%>
<form  method="GET" >
    Imie:<br>
    <input type="text" name="imieedit"  >
    <br><br>
    Nazwisko:<br>
    <input type="text" name="nazwiskoedit"  >
    <br><br>
    Pensja:<br>
    <input type="text" name="salaryedit"  >
    <br><br>

    <input type="submit" value="Edytuj pracownika">
</form>
</body>
</html>
