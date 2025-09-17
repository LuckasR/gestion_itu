package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {}