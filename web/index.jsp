<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 02.04.2019
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>--%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>--%>
<html>
  <head>
    <title>Formularz dodajacy pracownika</title>
  </head>
  <body>
  <form action="Servlet" method="GET">
    Imie:<br>
    <input type="text" name="imie"  >
    <br><br>
    Nazwisko:<br>
    <input type="text" name="nazwisko"  >
    <br><br>
    Pensja:<br>
    <input type="text" name="salary"  >
    <br><br>

    <input type="submit" value="Dodaj pracownika">
  </form>
  </body>
</html>
