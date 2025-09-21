package com.gestion.charcuterie.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.charcuterie.model.Scoring_candidature;
import com.gestion.charcuterie.repository.Scoring_candidatureRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class Scoring_candidatureServiceImpl implements Scoring_candidatureService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private Scoring_candidatureRepository repo;

    public List<Scoring_candidature> getAll() {
        return repo.findAll();
    }

    public Scoring_candidature getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Scoring_candidature obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<Scoring_candidature> filter(
        LocalDateTime dateDebut,
        LocalDateTime dateFin,
        BigDecimal pourcentageEmbaucheMin,
        BigDecimal pourcentageEmbaucheMax) {

    String jpql = "SELECT s FROM Scoring_candidature s WHERE 1=1";

    if (dateDebut != null) jpql += " AND s.date_resultat >= :dateDebut";
    if (dateFin != null) jpql += " AND s.date_resultat <= :dateFin";
    if (pourcentageEmbaucheMin != null) jpql += " AND s.pourcentage_embauche >= :pourcentageEmbaucheMin";
    if (pourcentageEmbaucheMax != null) jpql += " AND s.pourcentage_embauche <= :pourcentageEmbaucheMax";

    Query query = entityManager.createQuery(jpql, Scoring_candidature.class);

    if (dateDebut != null) query.setParameter("dateDebut",dateDebut);
    if (dateFin != null) query.setParameter("dateFin",dateFin);
    if (pourcentageEmbaucheMin != null) query.setParameter("pourcentageEmbaucheMin", pourcentageEmbaucheMin);
    if (pourcentageEmbaucheMax != null) query.setParameter("pourcentageEmbaucheMax", pourcentageEmbaucheMax);

    return query.getResultList();
}


}
