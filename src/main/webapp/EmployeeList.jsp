<%--
  Created by IntelliJ IDEA.
  User: yash.raj
  Date: 08-08-2022
  Time: 01:05 pm
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
    <title>Employee List</title>
</head>
<body>
<%
  try
  {
    List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
    request.setAttribute("empList",employeeList);
  }
  catch (Exception e)
  {
    throw new RuntimeException(e);
  }
%>
  <table border="10" align="center" width="50%">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Age</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    <c:forEach var="emp" items="${empList}">
      <tr align="center">
        <td>${emp.eId}</td>
        <td>${emp.eName}</td>
        <td>${emp.eSalary}</td>
        <td>${emp.eAge}</td>
        <td>
          <form action="GetEmployeeServlet">
            <input type="submit" name="edit" value="Edit"/>
            <input type="hidden" name="eId" value="${emp.eId}">
          </form>
        </td>
        <td>
          <form action="DeleteEmployeeServlet">
            <input type="submit" name="delete" value="Delete"/>
            <input type="hidden" name="eId" value="${emp.eId}">
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
