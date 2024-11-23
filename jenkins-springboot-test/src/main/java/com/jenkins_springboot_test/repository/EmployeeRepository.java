package com.jenkins_springboot_test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jenkins_springboot_test.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	List<Employee> findAll();
}
