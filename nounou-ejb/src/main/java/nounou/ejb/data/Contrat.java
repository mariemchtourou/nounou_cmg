package nounou.ejb.data;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contrat")
public class Contrat {

	// Champs

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcontrat")
	private int IdContrat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contrats")
	private Parent IdParent;

	@Column(name = "nom")
	private String Nom;

	@Column(name = "prenom")
	private String Prenom;

	@Column(name = "datedenaissance")
	private Date DateDeNaissance;

	@Column(name = "tarif")
	private Float Tarif;

	@Column(name = "indement")
	private Float IndemEnt;

	@Column(name = "indemrep")
	private Float IndemRep;

	@Column(name = "actif")
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
		return Objects.hash(Actif, DateDeNaissance, IdParent, IdContrat, IndemEnt, IndemRep, Nom, Prenom, Tarif);
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
		return Objects.equals(Actif, other.Actif) && Objects.equals(DateDeNaissance, other.DateDeNaissance)
				&& IdParent == other.IdParent && IdContrat == other.IdContrat
				&& Objects.equals(IndemEnt, other.IndemEnt) && Objects.equals(IndemRep, other.IndemRep)
				&& Objects.equals(Nom, other.Nom) && Objects.equals(Prenom, other.Prenom)
				&& Objects.equals(Tarif, other.Tarif);
	}

}
