package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {}