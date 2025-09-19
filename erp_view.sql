    -- create or replace view  candidature_annonce
    -- as
    -- select * 
    --     from detail_candidature as dc 
    --     join candidature as c on c.id = dc.candidature_id
    --     where c.annonce_id = 1
        

create or replace view  v_candidature_annonce
    as
    SELECT 
        c.id AS id_candidature,
        c.date_candidature,
        u.username AS candidat,
        a.title AS annonce,
        st.name AS status_traitement,
        f.name AS filiere,
        ne.name AS niveau_etude,
        d.duree_experience,
        d.skills,
        d.motivation,
        d.experience_professionnelle,
        d.cv,
        d.lm,
        d.cin,
        d.residence , 
        pe.date_entretient
    FROM candidature c
    LEFT JOIN utilisateur u ON c.user_id = u.id
    LEFT JOIN annonce a ON c.annonce_id = a.id
    LEFT JOIN status_traitement st ON c.status_traitement_id = st.id
    LEFT JOIN detail_candidature d ON c.id = d.candidature_id
    LEFT JOIN filiere f ON d.filiere_id = f.id
    LEFT JOIN niveau_etude ne ON d.niveau_etude_id = ne.id
    left join planing_entretient pe ON pe.candidature_id = c.id
    ;
