package com.yash.servlets;

import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateEmployeeServlet", value = "/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Employee employee = new Employee();
        employee.seteId(Integer.parseInt(request.getParameter("eId")));
        employee.seteName(request.getParameter("eName"));
        employee.seteSalary(Double.parseDouble(request.getParameter("eSalary")));
        employee.seteAge(Integer.parseInt(request.getParameter("eAge")));

        try
        {
            int status = EmployeeDao.updateEmployee(employee);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        response.getWriter().write("<h3>Employee updated</h3>");
        request.getRequestDispatcher("AllEmployeesServlet").include(request,response);
    }
}
