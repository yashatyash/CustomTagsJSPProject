<%--
  Created by IntelliJ IDEA.
  User: yash.raj
  Date: 05-08-2022
  Time: 03:08 pm
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
    <title>Home page</title>
</head>
<body>
    <c:set var="name" value="Yash"/>
    <c:set var="age" value="25"/>
    <c:out value="${name}"/>
    <c:if test="${age<30}">
        <p>You are a valid employee.</p>
    </c:if>

    <c:set var="string" value="Second: This is first String."/>

    <c:if test="${fn:startsWith(string, 'First' )}">
        <p>Starts with First</p>
    </c:if>

    <c:if test="${fn:startsWith(string, 'Second')}">
        <p>Starts with Second</p>
    </c:if>

    <%
        List<String> list = Arrays.asList("Yash","Nikhil","Shubham");
        request.setAttribute("list",list);
    %>

    <ul>
        <c:forEach var="a" items="${list}">
            <li><c:out value="${a}"/></li>
        </c:forEach>
    </ul>

    <%
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Yash",35000,30));
        employeeList.add(new Employee(2,"Nikhil",37000,25));
        employeeList.add(new Employee(3,"Shubham",34000,35));
        request.setAttribute("employeeList",employeeList);
    %>

<table border="2" width="50%" align="center">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="emp" items="${employeeList}">
        <tr>
            <td>${emp.eId}</td>
            <!--<td>$//{emp.eName.toUpperCase()}</td>-->
            <td>${fn:toUpperCase(emp.eName)}</td>
            <td>${emp.eSalary}</td>
            <td>
                <button>Edit</button>
                <button>Delete</button>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="Employee.html" style="text-decoration: none">Employee page</a>
<a href="AllEmployeesServlet" style="text-decoration: none">All Employees</a>
</body>
</html>
