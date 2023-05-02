package com.springboot.crudtutorial.dao;

import com.springboot.crudtutorial.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO EMPLOYEE(id, fname, lname, email) VALUES(?,?,?,?)";
    private static final String UPDATE_EMPLOYEE_BY_ID_QUERY="UPDATE EMPLOYEE SET fname=? WHERE ID=?";
    private static final String GET_EMPLOYEE_BY_ID_QUERY="SELECT * FROM EMPLOYEE WHERE ID=?";
    private static final String DELETE_EMPLOYEE_BY_ID="DELETE FROM EMPLOYEE WHERE ID=?";
    private static final String GET_EMPLOYEES_QUERY="SELECT * FROM EMPLOYEE";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Employee createEmployee(Employee emp) {
        jdbcTemplate.update(INSERT_EMPLOYEE_QUERY, emp.getId(), emp.getFname(),emp.getLname(),emp.getEmail());
        return emp;
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        jdbcTemplate.update(UPDATE_EMPLOYEE_BY_ID_QUERY,  emp.getFname(),emp.getId());
        return emp;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID_QUERY, (rs, rowNum) -> {
            return new Employee(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        }, id);
    }

    @Override
    public String deleteEmployeeById(int id) {
        jdbcTemplate.update(DELETE_EMPLOYEE_BY_ID, id);
        return "User with ID: " + id + " got deleted";
    }

    @Override
    public List<Employee> allEmployees() {
        return jdbcTemplate.query(GET_EMPLOYEES_QUERY, (rs, rowNum) -> {
            return new Employee(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        });
    }
}
