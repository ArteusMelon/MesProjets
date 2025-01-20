package com.in28minutes.springboot.tutorial.basics.application.configuration.repository;
 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Employee;
 
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByOrderByLastNameAsc
();
}