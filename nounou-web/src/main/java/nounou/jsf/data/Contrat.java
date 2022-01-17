package nounou.jsf.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@SuppressWarnings("serial")
public class Contrat implements Serializable {
	// Champs

		private int IdContrat;

		private Parent IdParent;

		@NotBlank( message = "Le nom doit être renseigné")
		@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
		private String Nom;

		@NotBlank( message = "Le prenom doit être renseigné")
		@Size(max=25, message = "Valeur trop longue pour le prenom : 25 car. maxi" )
		private String Prenom;

		@NotBlank( message = "La Date De Naissance doit être renseignée")
		private Date DateDeNaissance;

		@NotBlank( message = "Le Tarif doit être renseigné")
		private Float Tarif;

		@NotBlank( message = "Les Indemnités d’entretien doivent être renseignés")
		private Float IndemEnt;

		@NotBlank( message = "Les Indemnités de repas  doivent être renseignés")
		private Float IndemRep;

		private Boolean Actif;

		// Constructors

		public Contrat() {

		}

		public Contrat(Parent idParent, String nom, String prenom, Date dateDeNaissance, Float tarif, Float indemEnt,
				Float indemRep, Boolean actif) {
			super();
			IdParent = idParent;
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

		public Parent getIdParent() {
			return IdParent;
		}

		public void setIdParent(Parent idParent) {
			IdParent = idParent;
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

		@Override
		public int hashCode() {
			return Objects.hash(IdContrat);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Contrat other = (Contrat) obj;
			return IdContrat == other.IdContrat;
		}





}
