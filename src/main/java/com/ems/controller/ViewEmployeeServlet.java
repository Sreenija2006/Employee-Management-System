package com.ems.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@WebServlet("/viewEmployees")
public class ViewEmployeeServlet extends HttpServlet {

    private EmployeeService service = new EmployeeService();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<Employee> list = service.getAllEmployees();

        req.setAttribute("list", list);

        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, res);
    }
}