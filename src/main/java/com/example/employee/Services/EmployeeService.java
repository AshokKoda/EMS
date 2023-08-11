package com.example.employee.Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee.Entities.Employee;
import com.example.employee.Exceptions.CustomExceptions;
import com.example.employee.Repositories.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    // Create an employee API
    public Employee save(Employee employee) throws ParseException, CustomExceptions {
        String fName = employee.getFirstName();
        String lName = employee.getLastName();
        String email = employee.getEmail();
        String phoneNo = employee.getPhoneNo();
        Double salary = employee.getSalary();

        if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || phoneNo.isEmpty() || salary <= 0) {
            throw new CustomExceptions("Some mandatory fields are missing!.");
        } else {
            String strDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date doj = df.parse(strDate);
            employee.setDoj(doj);
            employeeRepository.save(employee);
            log.info("Employee successfully added!.");
        }
        return employee;
    }

    // GET EMPLOYEES
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Employee With Tax Deduction API
    public Employee employeeWithTaxApi(Employee employee) throws CustomExceptions, ParseException {
        String fName = employee.getFirstName();
        String lName = employee.getLastName();
        String email = employee.getEmail();
        String phoneNo = employee.getPhoneNo();
        Double salary = employee.getSalary();

        Double taxDeduction = salary * 0.1;
        Double netSalary = salary - taxDeduction;

        if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || phoneNo.isEmpty() || salary <= 0) {
            throw new CustomExceptions("Some mandatory fields are missing!.");
        } else {
            String strDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date doj = df.parse(strDate);
            employee.setDoj(doj);

            employee.setTax(taxDeduction);
            employee.setNetSalary(netSalary);

            employeeRepository.save(employee);
            log.info("Employee added with salary successfully!.");
        }
        return employee;
    }

    // Employee Tax Deduction API with some rules
    public Employee employeeTaxApiWithRules(Employee employee) throws CustomExceptions, ParseException {
        String fName = employee.getFirstName();
        String lName = employee.getLastName();
        String email = employee.getEmail();
        String phoneNo = employee.getPhoneNo();
        Double salary = employee.getSalary();

        Double taxDeduction = salary * 0.1;
        Double netSalary = salary - taxDeduction;

        if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || phoneNo.isEmpty() || salary <= 0) {
            throw new CustomExceptions("Some mandatory fields are missing!.");
        } else {
            String strDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date doj = df.parse(strDate);
            employee.setDoj(doj);

            if (salary <= 250000) {
                taxDeduction = 0.0;
                netSalary = salary;
            }

            employee.setTax(taxDeduction);
            employee.setNetSalary(netSalary);

            employeeRepository.save(employee);
            log.info("Employee added with salary successfully!.");
        }
        return employee;
    }
}
