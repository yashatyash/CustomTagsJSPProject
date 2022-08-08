package com.yash.servlets;

import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeInsertServlet", value = "/EmployeeInsertServlet")
public class EmployeeInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Employee employee = new Employee();
        employee.seteName(request.getParameter("eName"));
        employee.seteSalary(Double.parseDouble(request.getParameter("eSalary")));
        employee.seteAge(Integer.parseInt(request.getParameter("eAge")));

        try
        {
            int status = EmployeeDao.addEmployee(employee);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        response.getWriter().write("<h3>Employee Inserted</h3>");
    }
}
