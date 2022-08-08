package com.yash.servlets;

import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllEmployeesServlet", value = "/AllEmployeesServlet")
public class AllEmployeesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<Employee> employeeList = null;
        try
        {
             employeeList = EmployeeDao.getAllEmployees();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        request.setAttribute("employeeList",employeeList);
        request.getRequestDispatcher("EmployeeList.jsp").include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
