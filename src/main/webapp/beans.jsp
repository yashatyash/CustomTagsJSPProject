<%--
  Created by IntelliJ IDEA.
  User: yash.raj
  Date: 08-08-2022
  Time: 11:11 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beans jsp</title>
</head>
<body>
    <jsp:useBean id="emp" class="com.yash.model.Employee"/>
    <jsp:setProperty name="emp" property="*"/>

    <jsp:getProperty name="emp" property="eId"/><br>
    <jsp:getProperty name="emp" property="eName"/><br>
    <jsp:getProperty name="emp" property="eSalary"/><br>
    <jsp:getProperty name="emp" property="eAge"/><br>
</body>
</html>
