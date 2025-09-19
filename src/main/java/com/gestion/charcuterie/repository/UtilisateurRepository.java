package com.gestion.charcuterie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Utilisateur;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByUsername(String username);
    Optional<Utilisateur> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}