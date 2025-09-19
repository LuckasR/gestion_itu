package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Detail_candidatureServiceImpl implements Detail_candidatureService {

    @Autowired
    private Detail_candidatureRepository repo;

    public List<Detail_candidature> getAll() {
        return repo.findAll();
    }

    public Detail_candidature getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Detail_candidature obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public boolean checkConformite(Annonce annonce, Detail_candidature candidature) {
        // Diplome
        int idDiplomeAnnonce = annonce.getNiveau_etude().getId();
        int idDiplomeCandidat = candidature.getNiveau().getId();
        // Age
        LocalDate naissDate = candidature.getDate_naissance();
        LocalDate currentDate = LocalDate.now();
        int ageCandidat = Period.between(candidature.getDate_naissance(), currentDate).getYears();
        int ageRequis = annonce.getAge_requis();
        // Verification experience_professionnelle
        String val = candidature.getDuree_experience();
        if (val == null || val.isEmpty()) {
            val = "0";
        }
        int dureeExperience = Integer.parseInt(val);
        int experienceRequis = annonce.getExperience_requis();
        // Dossier existant
        String cv = candidature.getCv();
        String lm = candidature.getLm();
        String cin = candidature.getCin();
        if (dureeExperience < experienceRequis) {
            return false;
        }
        if (ageCandidat < ageRequis) {
            return false;
        }
        if ((idDiplomeAnnonce <= idDiplomeCandidat)) {
            return false;
        }
        if (cv == null || lm == null || cin == null) {
            return false;
        }
        return true;
    }

}