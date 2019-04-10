package com.springboot.rest.restdemo.repo;

import java.util.List;

import com.springboot.rest.restdemo.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee cus);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(String empId);
}