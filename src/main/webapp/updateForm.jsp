<%--
  Created by IntelliJ IDEA.
  User: yash.raj
  Date: 08-08-2022
  Time: 03:26 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<%@page import="java.util.*" %>
<%@page import="com.yash.model.Employee" %>
<html>
<head>
    <title>Update Employee Form</title>
</head>
<body>
<%
  Employee employee = (Employee) request.getAttribute("empData");
  request.setAttribute("emp",employee);
%>
<form action="UpdateEmployeeServlet" method="post">
    <table>
        <tr>
            <td>Enter Id: </td>
            <td><input type="text" name="eId" value="${emp.eId}" readonly></td>
        </tr>
        <tr>
            <td>Enter Name: </td>
            <td><input type="text" name="eName" value="${emp.eName}"></td>
        </tr>
        <tr>
            <td>Enter Salary: </td>
            <td><input type="text" name="eSalary" value="${emp.eSalary}"></td>
        </tr>
        <tr>
            <td>Enter Age: </td>
            <td><input type="text" name="eAge" value="${emp.eAge}"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="submit" value="Update">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
