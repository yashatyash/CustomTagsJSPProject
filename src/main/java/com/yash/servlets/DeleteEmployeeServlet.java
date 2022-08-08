package com.yash.servlets;

import com.yash.dao.EmployeeDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteEmployeeServlet", value = "/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("eId"));
        try
        {
            EmployeeDao.deleteEmployee(id);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        response.getWriter().write("<h3>Employee Delete successfully !</h3>");
        request.getRequestDispatcher("EmployeeList.jsp").include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
