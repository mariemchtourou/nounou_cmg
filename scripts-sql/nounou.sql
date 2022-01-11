-- PostgreSQL


-- Schema

DROP SCHEMA  IF EXISTS  nounou  CASCADE;
CREATE SCHEMA  nounou;

SET search_path TO nounou, public;


-- Tables

CREATE TABLE compte (
	IdCompte		INT			 	NOT NULL	GENERATED BY DEFAULT AS IDENTITY,
	Pseudo			VARCHAR(25)		NOT NULL,
	MotDePasse		VARCHAR(25) 	NOT NULL,
	Email			VARCHAR(100)	NOT NULL,
	PRIMARY KEY (IdCompte)
);

CREATE TABLE role (
	IdCompte		INT				NOT NULL,
	Role			VARCHAR(20)		NOT NULL,
	CHECK( Role IN ('ADMINISTRATEUR','UTILISATEUR') ),	
	PRIMARY KEY (IdCompte, Role)
);

CREATE TABLE parent (
	IdCompte		INT			 	NOT NULL,
	NomParents		VARCHAR(20)		NOT NULL,
	Adresse			VARCHAR(300)	NOT NULL,
	Telephone		INT				NOT NULL,
	PRIMARY KEY (IdCompte)
);

CREATE TABLE contrat (
	IdContrat		INT				NOT NULL	GENERATED BY DEFAULT AS IDENTITY,
	IdCompte		INT			 	NOT NULL,
	Nom				VARCHAR(25)		NOT NULL,
	Prenom			VARCHAR(25)		NOT NULL,
	DateDeNaissance DATE			NOT NULL,
	Tarif			FLOAT			NOT NULL,
	IndemEnt		FLOAT			NOT NULL,
	IndemRep		FLOAT			NOT NULL,
	Statut			BOOLEAN 		NOT NULL,
	PRIMARY KEY (IdContrat)
);


CREATE TABLE garde (
	IdGarde			INT				NOT NULL	GENERATED BY DEFAULT AS IDENTITY,
	IdContrat		INT			 	NOT NULL,
	DateGarde		DATE			NOT NULL,
	HeureArr		TIMESTAMP		NOT NULL,
	HeureDep		TIMESTAMP		NOT NULL,
	Repas			BOOLEAN 		NOT NULL,
	PRIMARY KEY (IdGarde)
);

CREATE VIEW vue_compte_role AS
	SELECT c.Pseudo, r.Role 
	FROM ( compte c
	INNER JOIN role r ON c.IdCompte = r.IdCompte );



-- Insertion des données

INSERT INTO compte (IdCompte, Pseudo, MotDePasse, Email ) VALUES 
  (1, 'geek', 'geek', 'geek@3il.fr' );
INSERT INTO compte (IdCompte, Pseudo, MotDePasse, Email ) VALUES 
  (2, 'chef', 'chef', 'chef@3il.fr' );
INSERT INTO compte (IdCompte, Pseudo, MotDePasse, Email ) VALUES 
  (3, 'job', 'job', 'job@3il.fr' );

ALTER TABLE compte ALTER COLUMN IdCompte RESTART WITH 4;

  
INSERT INTO role (IdCompte, Role) VALUES 
  ( 1, 'ADMINISTRATEUR' );
INSERT INTO role (IdCompte, Role) VALUES 
  ( 1, 'UTILISATEUR' );
INSERT INTO role (IdCompte, Role) VALUES 
  ( 2, 'UTILISATEUR' );
INSERT INTO role (IdCompte, Role) VALUES 
  ( 3, 'UTILISATEUR' );

-- Contraintes  

ALTER TABLE parent
ADD CONSTRAINT fk_parent_compte	FOREIGN KEY (IdCompte) REFERENCES compte (IdCompte);

ALTER TABLE contrat
ADD CONSTRAINT fk_contrat_parent	FOREIGN KEY (IdCompte) REFERENCES parent (IdCompte);

ALTER TABLE role
ADD CONSTRAINT fk_role_compte	FOREIGN KEY (IdCompte) REFERENCES compte (IdCompte);

ALTER TABLE garde
ADD CONSTRAINT fk_garde_contrat	FOREIGN KEY (IdContrat) REFERENCES contrat (IdContrat);

CREATE UNIQUE INDEX idx_compte_pseudo ON compte (Pseudo ASC);


-- Compte utilisateur

DROP USER  IF EXISTS  nounou;
CREATE USER  nounou  WITH PASSWORD 'nounou';
GRANT ALL PRIVILEGES ON SCHEMA nounou TO nounou;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA nounou TO nounou;

