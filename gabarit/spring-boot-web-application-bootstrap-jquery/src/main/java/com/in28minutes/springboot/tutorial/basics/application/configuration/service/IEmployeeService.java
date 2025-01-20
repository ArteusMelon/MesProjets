package com.in28minutes.springboot.tutorial.basics.application.configuration.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Employee;

public interface IEmployeeService {

	List<Employee> getEmployees();

	Optional<Employee> getEmployeeById(long id);

	void updateEmployee(Employee employee);

	void addEmployee(String lastName, String firstName, String title, Integer reportsTo,
	Date birthDate, Date hireDate, String address, String city, String state, String country,
	String postalCode, String phone, String fax, String email);

	void deleteEmployee(long id);
	
	void saveEmployee(Employee employee);

}