package com.example.consumerest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumerest.model.Employee;
import com.example.consumerest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "getEmployees", method = RequestMethod.GET)   // or use @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	
	@RequestMapping(value = "insertEmployee", method = RequestMethod.POST)   // or use @PostMapping
    public void insertEmployee(@RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
    }
	
	@RequestMapping(value = "addEmployee", method = RequestMethod.POST) 
		public void addEmployee(@RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
    }
}
