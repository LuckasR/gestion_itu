package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}