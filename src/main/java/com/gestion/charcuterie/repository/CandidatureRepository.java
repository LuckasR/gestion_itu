package com.gestion.charcuterie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion.charcuterie.model.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {

    @Query(value = "select * from detail_candidature as dc join candidature as c on c.id = dc.candidature_id where c.annonce_id = : annonce_id", nativeQuery = true)
    List<Object[]> findbyAnnonce(@Param("annonce_id") int id);

    // @Query(value = "select * from detail_candidature as dc join candidature as c
    // on c.id = dc.candidature_id where c.annonce_id = : annonce_id", nativeQuery =
    // true)
    // List<Object[]> findByVenteId(@Param("venteId") Long venteId);

    @Query(value = """
            select
                c.id  , 
                an.title as titleOfAnnonce,
                usr.username as nomCandidat,
                extract(year from age(now(), dc.date_naissance)) as age,
                nv.name as diplome,
                qcm.score as scoreQcmSur5
            from planing_entretient pe
            left join candidature c on c.id = pe.candidature_id
            left join detail_candidature dc on dc.candidature_id = c.id
            left join annonce an on an.id = c.annonce_id
            left join utilisateur usr on usr.id = c.user_id
            left join niveau_etude nv on nv.id = dc.niveau_etude_id
            left join qcm_test qcm on qcm.candidature_id = c.id
            """, nativeQuery = true)
    List<Object[]> getEntretiensWithDetails();
}