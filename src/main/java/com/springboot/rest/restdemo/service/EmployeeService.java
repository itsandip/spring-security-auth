package com.springboot.rest.restdemo.service;

import java.util.List;

import com.springboot.rest.restdemo.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	void getEmployeeById(String empid);
}