package com.in28minutes.springboot.tutorial.basics.application.configuration.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Employee;
import com.in28minutes.springboot.tutorial.basics.application.configuration.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void addEmployee(String lastName, String firstName, String title, 
	Integer reportsTo,	Date birthDate, Date hireDate, String address, String city, 
	String state, String country,String postalCode, String phone, String fax, String email) {
		
		employeeRepository.save(new Employee(lastName, firstName,title, reportsTo, birthDate,hireDate,address,city,state,country,postalCode,phone,fax,email));
	}

	@Override
	public void deleteEmployee(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.delete(employee.get());
		}
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
}