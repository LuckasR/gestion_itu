-- Departements
INSERT INTO departement (name) VALUES 
('Informatique'),
('Comptabilite'),
('Ressources Humaines'),
('Marketing');

-- Genre
INSERT INTO genre (name) VALUES 
('Homme'),
('Femme');

-- Niveau etude
INSERT INTO niveau_etude (name) VALUES 
('Licence'),
('Master'),
('Doctorat');

-- Siege entreprise
INSERT INTO siege_entreprise (name) VALUES 
('Antananarivo'),
('Toamasina'),
('Fianarantsoa');

-- Type contrat
INSERT INTO type_contrat (name, durre_contrat, recurrence_renouvelement) VALUES 
('CDD', 12.00, 1),
('CDI', 0.00, 0),
('Stage', 6.00, 0);

-- Status
INSERT INTO status (name) VALUES 
('En Attente'),
('Traite'),
('Ouvert'),
('Ferme');

-- Status traitement
INSERT INTO status_traitement (name) VALUES 
('En attente'),
('Accepte'),
('Refuse');

-- Role
INSERT INTO role (name) VALUES 
('Administrateur'),
('Manager'),
('Recruteur'),
('Employe');

-- Organisme social
INSERT INTO organisme_social (name, pourcentage) VALUES 
('Cnaps', 13.00),
('Ostie', 5.00);

-- Societe
INSERT INTO societe (name, nombre_qcm_test) VALUES 
('TechnoDev', 2),
('AgroFood', 1);

-- Admin
INSERT INTO admin (username, password) VALUES 
('admin1', 'pass123'),
('admin2', 'pass456');

-- Employes
INSERT INTO employee (role_id,departement_id, username, password) VALUES 
(2, 1 , 'manager1', 'pwd1'),
(3, 2 ,'recruteur1', 'pwd2'),
(4, 3 , 'employe1', 'pwd3');

update employee set departement_id = 2 where id = 2;
update employee set departement_id = 3 where id = 3;

-- Utilisateur (candidats)
INSERT INTO utilisateur (username, password) VALUES 
('luckas', 'user1'),
('ivan', 'user2');


-- Contrat employes
INSERT INTO contrat_employee (admin_id, employee_id, contrat_id, date_debut_contrat, date_fin_contrat) VALUES
(1, 1, 2, '2025-01-01', '2030-01-01'),
(1, 2, 1, '2025-02-01', '2026-02-01');

-- Informations employes
INSERT INTO information_employee (employee_id, contrat_id, first_name, last_name, email, phone, address, cv, lm, cin, residence) VALUES
(1, 2, 'Jean', 'Rakoto', 'jean.rakoto@email.com', '0341234567', 'Antananarivo', 'cv_jean.pdf', 'lm_jean.pdf', '123456789', 'Andoharanofotsy'),
(2, 1, 'Marie', 'Randria', 'marie.randria@email.com', '0349876543', 'Toamasina', 'cv_marie.pdf', 'lm_marie.pdf', '987654321', 'Itaosy');


-- Annonce
INSERT INTO annonce (title, departement_id, niveau_etude_id, genre_id, type_contrat_id, description, date_expiration, status_id) VALUES
('Developpeur Java', 1, 1, 1, 2, 'Recherche developpeur Java junior', '2025-12-31', 1),
('Comptable Senior', 2, 2, 2, 1, 'Recherche comptable senior', '2025-10-31', 1);

-- Candidature
INSERT INTO candidature (user_id, annonce_id, status_traitement_id) VALUES
(1, 1, 1),
(2, 2, 1);

-- Detail candidature
INSERT INTO detail_candidature (candidature_id, genre_id, duree_experience, skills, motivation, experience_professionnelle, address, cv, lm, cin, residence) VALUES
(1, 1, '2 ans', 'Java, Spring Boot, SQL', 'Passionne de dev', 'Stage chez TechCorp', 'Antananarivo', 'cv_luckas.pdf', 'lm_luckas.pdf', '654321789', 'Ambanidia'),
(2, 2, '5 ans', 'Comptabilite, Excel, Sage', 'Rigueur et precision', 'Cabinet Comptable XYZ', 'Toamasina', 'cv_ivan.pdf', 'lm_ivan.pdf', '852963741', 'Ankirihiry');


-- Questions
INSERT INTO qcm_question (departement_id, question) VALUES
(1, 'Qu est ce que la vie  ?'),
(2, 'Qu est ce qu un bilan comptable ?');

-- Reponses
INSERT INTO qcm_reponse (question_id, reponse, status) VALUES
(1, 'Un langage de programmation', true),
(1, 'Un systeme d exploitation', false),
(2, 'Un document financier resumant actifs et passifs', true),
(2, 'Un logiciel de comptabilite', false);



INSERT INTO qcm_reponse (question_id, reponse, status) VALUES
(3, 'Un toutoutn', true),
(3, 'Un syscd', false),
(3, 'Un rien', false),
(3, 'Un tout', true) ; 



-- Test QCM
INSERT INTO qcm_test (candidature_id, score) VALUES
(1, 85.50),
(2, 72.00);


-- Planification entretien
INSERT INTO planing_entretient (employee_id, candidature_id, siege_entreprise_id, date_entretient) VALUES
(2, 1, 1, '2025-09-20 10:00:00'),
(2, 2, 2, '2025-09-22 14:00:00');

-- Resultat entretien
INSERT INTO resultat_entretient (employee_id, candidature_id, pourcentage_satisfaction) VALUES
(2, 1, 90.00),
(2, 2, 75.00);

-- Scoring candidature
INSERT INTO scoring_candidature (candidature_id, pourcentage_embauche) VALUES
(1, 88.00),
(2, 70.00);


INSERT INTO filiere (name) VALUES
('Informatique'),
('Genie Civil'),
('Electronique'),
('Telecommunications'),
('Gestion'),
('Comptabilite'),
('Marketing'),
('Droit'),
('Medecine'),
('Agronomie');
