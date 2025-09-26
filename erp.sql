create table departement (
    id serial primary key , 
    name varchar(100) 
) ;

create table genre (
    id serial primary key , 
    name varchar(100) 
) ;

create table niveau_etude (
    id serial primary key , 
    name varchar(100) 
) ;


create table filiere (
    id serial primary key , 
    name varchar(100) 
) ;

create table siege_entreprise (
    id serial primary key , 
    name varchar(100) 
) ;
 
create table type_contrat (
    id serial primary key , 
    name varchar(100) , 
    durre_contrat decimal(10,2)  , 
    recurrence_renouvelement int 
) ;

create table status( 
    id serial primary key , 
    name varchar(100) 
) ; 

create table status_traitement( 
    id serial primary key , 
    name varchar(100) 
) ; 

create table role (
    id serial primary key , 
    name varchar(100)  
) ; 

--Cnaps, Ostie
create table organisme_social (
    id serial primary key , 
    name varchar(100)   , 
    pourcentage decimal(5,2)
) ; 

create table societe (
  id serial primary key , 
  name varchar(100) ,
  nombre_qcm_test int default 1 ,
  durre_entretient decimal(5,2) default 30.0 , -- en minute
  pourcentage_passed int , 
  date_creation timestamp  default current_timestamp
) ; 
 
 -- Begin Gestion personnel
create table admin  (
    id serial primary key , 
    username varchar(100) , 
    password varchar(100)
) ;

create table employee  (
    id serial primary key , 
    role_id int references role(id) ,
    departement_id int references departement(id) , 
    username varchar(100) , 
    password varchar(100)
) ; 
-- alter table employee add column departement_id int references departement(id) ; 

create table utilisateur  (
    id serial primary key , 
    username varchar(100) , 
    password varchar(100) , 
    email varchar(100)
) ; 
alter table utilisateur add column email varchar(100) ;

create table contrat_employee  (
    id serial primary key , 
    admin_id int references admin(id) ,     
    employee_id int references employee(id) ,
    contrat_id int references type_contrat(id) , 
    date_debut_contrat timestamp not null default current_timestamp  , 
    date_fin_contrat timestamp not null default current_timestamp  
) ; 

create table information_employee (
    id serial primary key , 
    employee_id int references employee(id) ,
    contrat_id int references type_contrat(id) , 
    filiere_id int references filiere(id) ,
    niveau_etude_id int references niveau_etude(id) ,
    first_name varchar(100) , 
    last_name varchar(100) , 
    email varchar(100) , 
    phone varchar(20) , 
    address VARCHAR(200) , 
    cv varchar(255) , 
    lm varchar(255) , 
    cin varchar(255) , 
    residence varchar(255) , 
    date_creation timestamp not null default current_timestamp
) ;


create table assurance_social_employee(
    id serial primary key ,
    employee_id int references employee(id) ,
    organisme_id int references organisme_social(id) ,
    date_attribution timestamp not null default current_timestamp
) ;

create table historique_role (
    id serial primary key , 
    employee_id int references employee(id) ,
    role_id int references role(id) ,
    date_modification timestamp not null default current_timestamp
) ;

-- End  Gestion personnel


create table annonce(
    id serial primary key ,
    title varchar(100),
    departement_id int references departement(id) ,
    niveau_etude_id int references niveau_etude(id) ,
    genre_id int references genre(id) ,
    type_contrat_id int references type_contrat(id) ,
    age_requis int  , 
    experience_requis int  , 
    salaire decimal(10,2) ,
    description text,
    date_publication date not null default current_date,
    date_expiration date , 
    status_id int references status(id)
);
 
create table candidature ( 
    id serial primary key ,
    user_id int references Utilisateur(id) ,
    annonce_id int references annonce(id) ,
    date_candidature date not null default current_date,
    passed_test boolean default false ,
    entretien_planifie boolean default false ,
    (id)_id int references (id)(id) 
) ; 


update candidature set passed_test = false   ;


create table detail_candidature (
    id serial primary key ,
    candidature_id int references candidature(id) ,
    filiere_id int references filiere(id) ,
    niveau_etude_id int references niveau_etude(id) ,
    genre_id int references genre(id) , 
    duree_experience varchar(250) , 
    skills text  ,
    motivation text , 
    experience_professionnelle text , 
    address VARCHAR(250) , 
    cv varchar(255) , 
    lm varchar(255) , 
    cin varchar(255) , 
    residence varchar(255)  , 
    date_naissance date  
) ;
 
SELECT 
    c.id AS id_candidature,
    c.date_candidature,
    u.username AS candidat, 
    d.duree_experience,
    d.skills, 
    d.experience_professionnelle,
    d.residence,
    st.name AS (id)
FROM candidature c
LEFT JOIN utilisateur u ON c.user_id = u.id
LEFT JOIN annonce a ON c.annonce_id = a.id
LEFT JOIN (id) st ON c.(id)_id = st.id
LEFT JOIN detail_candidature d ON c.id = d.candidature_id;
 


create table qcm_question (
    id serial primary key , 
    departement_id int references departement(id) ,
    question text  
) ;

create table qcm_reponse (
    id serial primary key , 
    question_id int references qcm_question(id) ,
    reponse text  , 
    status boolean -- 0 false  , 1 true
) ;

create table qcm_test (
    id serial primary key , 
    candidature_id int references candidature(id) ,
    score decimal(10,2) ,
    date_test timestamp default current_timestamp
) ;


create table planing_entretient (
    id serial primary key , 
    employee_id int references employee(id) , -- Employee charger de l'entretient 
    candidature_id int references candidature(id) , 
    siege_entreprise_id int references siege_entreprise(id) 
) ;

select an.title as "Title of Annonce" ,  usr.username as "Nom candidat" ,   extract(year from age(now(), dc.date_naissance)) as Age   , nv.name as diplome , qcm.score as "score_qcm sur 5"
from planing_entretient as pe
left join candidature as c on c.id = pe.candidature_id
left join detail_candidature as dc on dc.candidature_id = c.id 
left join annonce as an on an.id  = c.annonce_id  
left join utilisateur as usr on  usr.id = c.user_id
left join niveau_etude as nv on nv.id = dc.niveau_etude_id
left join qcm_test as qcm on qcm.candidature_id = c.id 
 ;
 

create table resultat_entretient (
    id serial primary key ,
    employee_id int references employee(id) ,
    candidature_id int references candidature(id) ,
    pourcentage_satisfaction decimal(10,2) , 
    date_resultat timestamp default current_timestamp
) ;
 
create table scoring_candidature (
    id serial primary key , 
    candidature_id int references candidature(id) ,
    pourcentage_embauche decimal(10,2) , 
    date_resultat  timestamp default current_timestamp , 
    status_id int references status_traitement(id)
 ) ;
 
create table signature_contrat (
    id serial primary key , 
    candidature_id int references candidature(id), 
    status_id int references status_traitement(id)
);  

create table parametre (
    id serial primary key , 
    name varchar(100)  , -- Recrutement auto
    is_active boolean default false 
) ;

create table detail_parametre (
    id serial primary key , 
    params_id int references parametre(id) ,
    name varchar(100)  , 
    value int default 0 ,
    is_active boolean default false 
) ;
 
CREATE TABLE jour_ferie (
    id SERIAL PRIMARY KEY,
    name varchar(250)  ,
    date_ferie DATE  
);

CREATE TABLE horaire_travail (
    id SERIAL PRIMARY KEY,
    jour_semaine VARCHAR(20) NOT NULL -- Lundi, Mardi... 
); 

 
create table detail_horaire(
    id SERIAL PRIMARY KEY,
    id_horaire int references horaire_travail(id) ,
    heure_debut TIME ,
    heure_fin TIME 
) ; 

CREATE TABLE emploi_dt_entretient (
    id SERIAL PRIMARY KEY,
    planing_entretient_id INT REFERENCES planing_entretient(id) ,
    tache_title VARCHAR(255) ,
    date_entretient DATE NOT NULL,
    heure_debut TIME NOT NULL,
    heure_fin TIME NOT NULL 
);
 