package com.ems.dao;

import java.sql.*;
import java.util.*;
import com.ems.model.Employee;

public class EmployeeDAO {

    private String url = "jdbc:mysql://localhost:3306/ems";
    private String user = "root";
    private String pass = "root123";

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    public void addEmployee(Employee emp) {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "insert into employee(name, department, salary) values(?,?,?)"
            );
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try (Connection con = getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("select * from employee");
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));
                list.add(e);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void deleteEmployee(int id) {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("delete from employee where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public Employee getEmployeeById(int id) {
        Employee e = null;
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from employee where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));
            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return e;
    }

    public void updateEmployee(Employee e) {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "update employee set name=?, department=?, salary=? where id=?"
            );
            ps.setString(1, e.getName());
            ps.setString(2, e.getDepartment());
            ps.setDouble(3, e.getSalary());
            ps.setInt(4, e.getId());
            ps.executeUpdate();
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}