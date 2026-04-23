package com.ems.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@WebServlet("/editEmployee")
public class EditEmployeeServlet extends HttpServlet {

    private EmployeeService service = new EmployeeService();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Employee emp = service.getEmployeeById(id);

        req.setAttribute("emp", emp);

        RequestDispatcher rd = req.getRequestDispatcher("editEmployee.jsp");
        rd.forward(req, res);
    }
}