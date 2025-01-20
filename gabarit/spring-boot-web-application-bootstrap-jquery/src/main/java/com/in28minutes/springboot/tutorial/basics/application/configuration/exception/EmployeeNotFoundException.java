package com.in28minutes.springboot.tutorial.basics.application.configuration.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Could not find employee with id " + id);
    }
}
