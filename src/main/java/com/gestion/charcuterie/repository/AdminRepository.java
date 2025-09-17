package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {}