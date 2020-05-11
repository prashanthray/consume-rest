package com.example.consumerest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.consumerest.model.Employee;

@Service
public class EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public List<Employee> getAllEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee[] employees = restTemplate.getForObject("http://localhost:8080/employees", Employee[].class);
		employeeList = Arrays.asList(employees);
		for (Employee emp : employees) {
			log.info(emp.toString());
		}
		return employeeList;

	}
	
	// Add a postForEntity() method to add a new employee
	public void insertEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity("http://localhost:8080/employee", employee, Employee.class);

	}
	
	// Add exchange() method to do the get or post for employee
	public void addEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> httpEntity = new HttpEntity<Employee> (employee);
		restTemplate.exchange("http://localhost:8080/employee", HttpMethod.POST, httpEntity, Employee[].class);
	}	
}
