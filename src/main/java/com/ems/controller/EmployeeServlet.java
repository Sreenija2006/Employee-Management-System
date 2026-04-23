package com.ems.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@WebServlet("/addEmployees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService service = new EmployeeService();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Employee e = new Employee();
        e.setName(req.getParameter("name"));
        e.setDepartment(req.getParameter("department"));
        e.setSalary(Double.parseDouble(req.getParameter("salary")));

        service.addEmployee(e);

        res.sendRedirect("viewEmployees?msg=added");
    }
}