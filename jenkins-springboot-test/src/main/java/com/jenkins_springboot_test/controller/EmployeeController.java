package com.jenkins_springboot_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jenkins_springboot_test.entity.Employee;
import com.jenkins_springboot_test.repository.EmployeeRepository;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(value = "/empall", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Employee> getAllEmployee() {
		return employeeRepository.findAll();

	}

	@GetMapping(value = "/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getRide(@PathVariable Integer id) {
		return employeeRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid employee id %s", id)));
	}

	@PostMapping(value = "/emp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee createRide(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

}
