package com.ems.service;

import java.util.List;
import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAO();

    public void addEmployee(Employee e) { dao.addEmployee(e); }
    public List<Employee> getAllEmployees() { return dao.getAllEmployees(); }
    public void deleteEmployee(int id) { dao.deleteEmployee(id); }
    public Employee getEmployeeById(int id) { return dao.getEmployeeById(id); }
    public void updateEmployee(Employee e) { dao.updateEmployee(e); }
}