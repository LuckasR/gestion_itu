package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Information_employee;

public interface Information_employeeRepository extends JpaRepository<Information_employee, Integer> {}