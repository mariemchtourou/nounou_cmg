package nounou.jsf.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Parent {

	// Champs
	
	private Integer			id;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String			nom;
	
	@NotBlank( message = "Le téléphone doit être renseigné")
	private int			telephone;

	@NotNull( message = "L'adresse est obligatoire")
	@Size(max=300, message = "Valeur trop longue pour l'adresse : 300 car. maxi" )
	private String		adresse;

	private List<Contrat>	contrats = new ArrayList<>();

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

	
}
