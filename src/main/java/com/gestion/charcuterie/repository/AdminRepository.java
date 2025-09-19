package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Admin;
import com.gestion.charcuterie.model.Utilisateur;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

        Admin findByUsernameAndPassword(String username, String password);

}