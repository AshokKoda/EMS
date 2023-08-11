package com.example.employee.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.Entities.Employee;
import com.example.employee.Exceptions.CustomExceptions;
import com.example.employee.Services.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/save/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws ParseException, CustomExceptions{
		return new ResponseEntity<Employee>(employeeService.save(employee), HttpStatus.CREATED);
	}

	@PostMapping("/save/employeeWithTaxApi")
	public ResponseEntity<Employee> saveEmployeeWithTax(@RequestBody Employee employee) throws ParseException, CustomExceptions{
		return new ResponseEntity<Employee>(employeeService.employeeWithTaxApi(employee), HttpStatus.CREATED);
	}

	@PostMapping("/save/employeeTaxApiWithRules")
	public ResponseEntity<Employee> employeeTaxApiWithRules(@RequestBody Employee employee) throws ParseException, CustomExceptions{
		return new ResponseEntity<Employee>(employeeService.employeeTaxApiWithRules(employee), HttpStatus.CREATED);
	}

    @GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
    
}
