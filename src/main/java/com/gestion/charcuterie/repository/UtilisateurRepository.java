package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {}