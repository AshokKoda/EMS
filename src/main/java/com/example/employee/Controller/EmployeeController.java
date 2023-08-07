package com.example.employee.Controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.Entities.Employee;
import com.example.employee.Services.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/save/employee")
    public void createEmployee(Employee employee) throws ParseException {
        employeeService.save(employee);
    }
    
}
