package com.springboot.crudtutorial.controller;

import com.springboot.crudtutorial.dao.EmployeeRepository;
import com.springboot.crudtutorial.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import org.springframework.web.bind.annotation.RestController;
@RestController

public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/CreateEmployee")
    public Employee addEmployee(@RequestBody Employee emp){
        return employeeRepository.createEmployee(emp);
    }

    @PutMapping("/UpdateEmployee")
    public Employee updateEmployee(@RequestBody Employee emp){
        return employeeRepository.updateEmployee(emp);
    }

    @GetMapping ("/GetEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        return employeeRepository.getEmployeeById(id);
    }

    @GetMapping ("/GetAllEmployees")
    public List<Employee> getEmployees(){
        return employeeRepository.allEmployees();
    }

    @DeleteMapping("/DeleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeRepository.deleteEmployeeById(id);
    }
}
