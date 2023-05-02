package com.springboot.crudtutorial.dao;

import com.springboot.crudtutorial.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee createEmployee(Employee emp);
    Employee updateEmployee(Employee emp);
    Employee getEmployeeById(int id);
    String deleteEmployeeById(int id);
    List<Employee> allEmployees();
}
