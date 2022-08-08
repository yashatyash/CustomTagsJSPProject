package com.yash.dao;

import com.yash.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    //returning connection with the database
    public static Connection getConnection() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/struts_training","root","abi627.Y@sh");
    }

    //method to add employee to DB
    public static Integer addEmployee(Employee employee) throws Exception
    {
        Connection connection = EmployeeDao.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into employee (eName, eSalary, eAge) values (?,?,?)");
        preparedStatement.setString(1,employee.geteName());
        preparedStatement.setDouble(2,employee.geteSalary());
        preparedStatement.setInt(3,employee.geteAge());
        return preparedStatement.executeUpdate();
    }

    public static List<Employee> getAllEmployees() throws Exception
    {
        Connection connection = EmployeeDao.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select  * from employee");
        while (resultSet.next())
        {
            employeeList.add(new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4)));
        }
        connection.close();
        return employeeList;
    }

    public static Integer deleteEmployee(Integer eId) throws Exception
    {
        Connection connection = EmployeeDao.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete  from employee where eId=?");
        preparedStatement.setInt(1,eId);
        int a = preparedStatement.executeUpdate();
        connection.close();
        return a;
    }

    public static Employee getEmployeeById(Integer eId) throws Exception
    {
        Connection connection = EmployeeDao.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where eId=?");
        preparedStatement.setInt(1,eId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Employee employee=null;
        while (resultSet.next())
        {
            employee = new Employee(resultSet.getInt(1), resultSet.getString(2),resultSet.getDouble(3), resultSet.getInt(4) );
        }
        return employee;
    }

    public static Integer updateEmployee(Employee employee) throws Exception
    {
        Connection connection = EmployeeDao.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update employee set eName=?,eSalary=?,eAge=? where eId=?");
        preparedStatement.setString(1, employee.geteName());
        preparedStatement.setDouble(2, employee.geteSalary());
        preparedStatement.setInt(3, employee.geteAge());
        preparedStatement.setInt(4,employee.geteId());

        int a = preparedStatement.executeUpdate();
        connection.close();
        return a;
    }
}
