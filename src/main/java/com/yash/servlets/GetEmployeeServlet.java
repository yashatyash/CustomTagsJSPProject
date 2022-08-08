package com.yash.servlets;

import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetEmployeeServlet", value = "/GetEmployeeServlet")
public class GetEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("eId"));
        Employee employee=null;
        try {
            employee = EmployeeDao.getEmployeeById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("empData",employee);
        request.getRequestDispatcher("updateForm.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
