package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Candidature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; // Import manquant

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
    @Query(value="SELECT * FROM candidature WHERE user_id = :user_id AND annonce_id= :annonce_id",nativeQuery=true)
    public Detail_candidature checkCandidature(@Param("user_id") Integer user_id,@Param("annonce_id") Integer annonce_id);
}