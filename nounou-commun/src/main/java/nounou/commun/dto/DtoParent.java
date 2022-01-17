package nounou.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class DtoParent implements Serializable {

	// Champs
	private int IdParent;

	private DtoCompte IdCompte;

	private String NomParents;

	private String Adresse;

	private int Telephone;

	private List<DtoContrat> contrats = new ArrayList<>();

	public DtoParent() {

	}

	public DtoParent(String nomParents, String adresse, int telephone) {
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

	public DtoCompte getIdCompte() {
		return IdCompte;
	}

	public void setIdCompte(DtoCompte idCompte) {
		IdCompte = idCompte;
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

	public List<DtoContrat> getContrats() {
		return contrats;
	}

	public void setContrats(List<DtoContrat> contrats) {
		this.contrats = contrats;
	}

}
