package com.in28minutes.springboot.tutorial.basics.application.configuration.controller;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.in28minutes.springboot.tutorial.basics.application.configuration.exception.EmployeeNotFoundException;
import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Employee;
import com.in28minutes.springboot.tutorial.basics.application.configuration.repository.EmployeeRepository;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.JWTService;
import org.springframework.security.core.Authentication;

@RestController
class EmployeeController {

  private final EmployeeRepository repository;
  private JWTService jwtService;

  EmployeeController(EmployeeRepository repository, JWTService jwtService) {
    this.repository = repository;
    this.jwtService = jwtService;

  }

	@PostMapping("/login")
	public String getToken(Authentication authentication) {
        		String token = jwtService.generateToken(authentication);
        		return token;
	}

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/employees")
  List<Employee> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item
  
  @GetMapping("/employees/{id}")
  EntityModel<Employee> one(@PathVariable Long id) {
  
	Employee employee = repository.findById(id) //
		.orElseThrow(() -> new EmployeeNotFoundException(id));
  
	return EntityModel.of(employee, //
		linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
		linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(employee -> {
        employee.setLastName(newEmployee.getLastName());
        employee.setPhone(newEmployee.getPhone());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}