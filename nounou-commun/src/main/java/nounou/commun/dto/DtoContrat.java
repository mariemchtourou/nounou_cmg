package nounou.commun.dto;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class DtoContrat implements Serializable {

	// Champs
			
			private int				IdContrat;
			
			private int				IdCompte;
			
			private String			Nom;
			
			private String			Prenom;
			
			private Date			DateDeNaissance;
			
			private	Float 			Tarif;
			
			private	Float 			IndemEnt;
			
			private	Float 			IndemRep;
			
			private	Boolean 		Actif;
			
	// Constructors
			
			public DtoContrat() {
				
			}

			public DtoContrat(int idCompte, String nom, String prenom, Date dateDeNaissance, Float tarif, Float indemEnt,
					Float indemRep, Boolean actif) {
				super();
				IdCompte = idCompte;
				Nom = nom;
				Prenom = prenom;
				DateDeNaissance = dateDeNaissance;
				Tarif = tarif;
				IndemEnt = indemEnt;
				IndemRep = indemRep;
				Actif = actif;
			}
			
	// Getters and Setters
			
			public int getIdContrat() {
				return IdContrat;
			}

			public int getIdCompte() {
				return IdCompte;
			}

			public void setIdCompte(int idCompte) {
				IdCompte = idCompte;
			}

			public String getNom() {
				return Nom;
			}

			public void setNom(String nom) {
				Nom = nom;
			}

			public String getPrenom() {
				return Prenom;
			}

			public void setPrenom(String prenom) {
				Prenom = prenom;
			}

			public Date getDateDeNaissance() {
				return DateDeNaissance;
			}

			public void setDateDeNaissance(Date dateDeNaissance) {
				DateDeNaissance = dateDeNaissance;
			}

			public Float getTarif() {
				return Tarif;
			}

			public void setTarif(Float tarif) {
				Tarif = tarif;
			}

			public Float getIndemEnt() {
				return IndemEnt;
			}

			public void setIndemEnt(Float indemEnt) {
				IndemEnt = indemEnt;
			}

			public Float getIndemRep() {
				return IndemRep;
			}

			public void setIndemRep(Float indemRep) {
				IndemRep = indemRep;
			}

			public Boolean getActif() {
				return Actif;
			}

			public void setActif(Boolean actif) {
				Actif = actif;
			}
			
			
}
