package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {}