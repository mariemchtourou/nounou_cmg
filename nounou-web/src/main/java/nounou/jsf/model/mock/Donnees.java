package nounou.jsf.model.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import nounou.commun.dto.Roles;
import nounou.jsf.data.Categorie;
import nounou.jsf.data.Compte;
<<<<<<< HEAD
import nounou.jsf.data.Contrat;
=======
import nounou.jsf.data.Garde;
>>>>>>> branch 'master' of https://github.com/mariemchtourou/nounou_cmg.git
import nounou.jsf.data.Parent;
import nounou.jsf.data.Personne;
import nounou.jsf.data.Telephone;
import nounou.jsf.data.mapper.IMapper;

@SuppressWarnings("serial")
@ApplicationScoped
public class Donnees implements Serializable {

	// Champs

	private final Map<Integer, Compte> mapComptes = new HashMap<>();
	private final Map<Integer, Categorie> mapCategories = new HashMap<>();
	private final Map<Integer, Contrat> mapContrats = new HashMap<>();
	private final Map<Integer, Personne> mapPersonnes = new HashMap<>();
	private final Map<Integer, Garde> mapGardes = new HashMap<>();
	private final Map<Integer, Parent> mapParents = new HashMap<>();

	private int dernierIdTelephone;

	@Inject
	private IMapper mapper;

	// Getters

	public List<Categorie> getCategories() {
		List<Categorie> categories = new ArrayList<>();
		for (Categorie categorie : mapCategories.values()) {
			categories.add(mapper.duplicate(categorie));
		}
		return categories;
	}

	public List<Compte> getComptes() {
		List<Compte> comptes = new ArrayList<>();
		for (Compte compte : mapComptes.values()) {
			comptes.add(mapper.duplicate(compte));
		}
		return comptes;
	}

	public List<Personne> getPersonnes() {
		List<Personne> personnes = new ArrayList<>();
		for (Personne personne : mapPersonnes.values()) {
			personnes.add(mapper.duplicate(personne));
		}
		return personnes;
	}
	
	public List<Garde> getGardes() {
		List<Garde> gardes = new ArrayList<>();
		for (Garde garde : mapGardes.values()) {
			gardes.add(mapper.duplicate(garde));
		}
		return gardes;
	}

	public List<Parent> getParents() {
		List<Parent> parents = new ArrayList<>();
		for (Parent parent : mapParents.values()) {
			parents.add(mapper.duplicate(parent));
		}
		return parents;
	}
	
	public List<Contrat> getContrats() {
		List<Contrat> contrats = new ArrayList<>();
		for (Contrat contrat : mapContrats.values()) {
			contrats.add(mapper.duplicate(contrat));
		}
		return contrats;
	}

	// Constructeur

	public Donnees() {
		initialiserDonnees();
	}

	// Actions

	public int categorieAjouter(Categorie categorie) {
		Integer idMax = Collections.max(mapCategories.keySet());
		if (idMax == null) {
			idMax = 0;
		}
		categorie.setId(idMax + 1);
		mapCategories.put(categorie.getId(), mapper.duplicate(categorie));
		return categorie.getId();
	}

	public void categorieModifier(Categorie categorie) {
		mapCategories.replace(categorie.getId(), mapper.duplicate(categorie));
	}

	public void categorieSupprimer(int id) {
		mapCategories.remove(id);
	}

	public Categorie categorieRetrouver(int id) {
		return mapper.duplicate(mapCategories.get(id));
	}
	
	public int contratAjouter(Contrat categorie) {
		Integer idMax = Collections.max(mapContrats.keySet());
		if (idMax == null) {
			idMax = 0;
		}
		categorie.setIdContrat(idMax + 1);
		mapContrats.put(categorie.getIdContrat(), mapper.duplicate(categorie));
		return categorie.getIdContrat();
	}

	public void contratModifier(Contrat categorie) {
		mapContrats.replace(categorie.getIdContrat(), mapper.duplicate(categorie));
	}

	public void contratSupprimer(int id) {
		mapContrats.remove(id);
	}

	public Contrat contratRetrouver(int id) {
		return mapper.duplicate(mapContrats.get(id));
	}
	
	public int compteAjouter(Compte compte) {
		Integer idMax = Collections.max(mapComptes.keySet());
		if (idMax == null) {
			idMax = 0;
		}
		compte.setId(idMax + 1);
		mapComptes.put(compte.getId(), mapper.duplicate(compte));
		return compte.getId();
	}

	public void compteModifier(Compte compte) {
		mapComptes.replace(compte.getId(), mapper.duplicate(compte));
	}

	public void compteSupprimer(int id) {
		mapComptes.remove(id);
	}

	public Compte compteRetrouver(int id) {
		return mapper.duplicate(mapComptes.get(id));
	}

	public int personneAjouter(Personne personne) {
		Integer idMax = Collections.max(mapPersonnes.keySet());
		if (idMax == null) {
			idMax = 0;
		}
		personne.setId(idMax + 1);
		mapPersonnes.put(personne.getId(), mapper.duplicate(personne));
		return personne.getId();
	}

	public void personneModifier(Personne personne) {
		affecterIdTelephones(personne);
		mapPersonnes.replace(personne.getId(), mapper.duplicate(personne));
	}

	public void personneSupprimer(int id) {
		mapPersonnes.remove(id);
	}

	public Personne personneRetrouver(int id) {
		return mapper.duplicate(mapPersonnes.get(id));
	}
	
	public int gardeAjouter(Garde garde) {
		Integer idMax = Collections.max(mapGardes.keySet());
		if (idMax == null) {
			idMax = 0;
		}
		garde.setId(idMax + 1);
		mapGardes.put(garde.getId(), mapper.duplicate(garde));
		return garde.getId();
	}

	public void gardeModifier(Garde garde) {
		mapGardes.replace(garde.getId(), mapper.duplicate(garde));
	}

	public void gardeSupprimer(int id) {
		mapGardes.remove(id);
	}

	public Garde gardeRetrouver(int id) {
		return mapper.duplicate(mapGardes.get(id));
	}
	
	public int parentAjouter(Parent parent) {
		Integer idMax = Collections.max(mapParents.keySet());
		if (idMax == null) {
			idMax = 0;
		}
		parent.setId(idMax + 1);
		mapParents.put(parent.getId(), mapper.duplicate(parent));
		return parent.getId();
	}

	public void parentModifier(Parent parent) {
		mapParents.replace(parent.getId(), mapper.duplicate(parent));
	}

	public void parentSupprimer(int id) {
		mapParents.remove(id);
	}

	public Parent parentRetrouver(int id) {
		return mapper.duplicate(mapParents.get(id));
	}

	// M??thodes auxiliaires

	private void initialiserDonnees() {

		// Comptes

		Compte compte;
		compte = new Compte(1, "geek", "geek", "geek@3il.fr");
		compte.getRoles().add(Roles.ADMINISTRATEUR);
		compte.getRoles().add(Roles.UTILISATEUR);
		mapComptes.put(compte.getId(), compte);

		compte = new Compte(2, "chef", "chef", "chef@3il.fr");
		compte.getRoles().add(Roles.UTILISATEUR);
		mapComptes.put(compte.getId(), compte);

		compte = new Compte(3, "job", "job", "job@3il.fr");
		compte.getRoles().add(Roles.UTILISATEUR);
		mapComptes.put(compte.getId(), compte);

		compte = new Compte(4, "_" + this.getClass().getPackage().getName(), "xxx", "xxx@3il.fr");
		compte.getRoles().add(Roles.UTILISATEUR);
		mapComptes.put(compte.getId(), compte);

		// Cat??gories

		Categorie categorie;
		categorie = new Categorie(1, "Ecrivains");
		mapCategories.put(categorie.getId(), categorie);
		categorie = new Categorie(2, "Peintres");
		mapCategories.put(categorie.getId(), categorie);

		// Personnes

		Categorie categorie1 = mapCategories.get(1);

		Personne personne;

		personne = new Personne(1, "VERLAINE", "Paul", categorie1);
		personne.getTelephones().add(new Telephone(31, "Portable", "06 33 33 33 33"));
		personne.getTelephones().add(new Telephone(32, "Domicile", "05 55 33 33 33"));
		personne.getTelephones().add(new Telephone(33, "Travail", "05 55 99 33 33"));
		mapPersonnes.put(personne.getId(), personne);

		personne = new Personne(2, "HUGO", "Victor", categorie1);
		personne.getTelephones().add(new Telephone(11, "Portable", "06 11 11 11 11"));
		personne.getTelephones().add(new Telephone(12, "Domicile", "05 55 11 11 11"));
		personne.getTelephones().add(new Telephone(13, "Travail", "05 55 99 11 11"));
		mapPersonnes.put(personne.getId(), personne);

		personne = new Personne(3, "TRIOLET", "Elsa", categorie1);
		personne.getTelephones().add(new Telephone(21, "Portable", "06 22 22 22 22"));
		personne.getTelephones().add(new Telephone(22, "Domicile", "05 55 22 22 22"));
		personne.getTelephones().add(new Telephone(23, "Travail", "05 55 99 22 22"));
		mapPersonnes.put(personne.getId(), personne);

		dernierIdTelephone = 100;

	}

	private void affecterIdTelephones(Personne personne) {
		for (Telephone t : personne.getTelephones()) {
			if (t.getId() == 0) {
				t.setId(++dernierIdTelephone);
			}
		}
	}

}
