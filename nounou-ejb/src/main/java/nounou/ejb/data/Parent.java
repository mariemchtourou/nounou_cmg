package nounou.ejb.data;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import nounou.commun.dto.DtoContrat;

@Entity
@Table(name = "parent")
public class Parent {

	// Champs

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idparent")
	private int IdParent;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private int IdCompte;

	@Column(name = "nomparents")
	private String NomParents;

	@Column(name = "adresse")
	private String Adresse;

	@Column(name = "telephone")
	private int Telephone;

	@OneToMany(mappedBy = "IdParent", cascade = ALL, orphanRemoval = true)
	private List<Contrat> contrats = new ArrayList<>();

	public Parent() {

	}

	public Parent(String nomParents, String adresse, int telephone) {
		super();
		NomParents = nomParents;
		Adresse = adresse;
		Telephone = telephone;
	}

	public int getIdParent() {
		return IdParent;
	}

	public void setIdParent(int idParent) {
		IdParent = idParent;
	}

	public int getIdCompte() {
		return IdCompte;
	}

	public String getNomParents() {
		return NomParents;
	}

	public void setNomParents(String nomParents) {
		NomParents = nomParents;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public int getTelephone() {
		return Telephone;
	}

	public void setTelephone(int telephone) {
		Telephone = telephone;
	}

	public List<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Adresse, IdCompte, NomParents, Telephone, contrats);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		return Objects.equals(Adresse, other.Adresse) && IdCompte == other.IdCompte
				&& Objects.equals(NomParents, other.NomParents) && Telephone == other.Telephone
				&& Objects.equals(contrats, other.contrats);
	}

}
