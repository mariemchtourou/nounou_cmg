package nounou.jsf.model.mock;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.jsf.data.Garde;
import nounou.jsf.data.Telephone;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelGarde implements Serializable {

	
	// Champs
	
	private List<Garde>		liste;
	
	private Garde			courant;
	
	@Inject
	private Donnees				données;

	
	// Getters
	
	public List<Garde> getListe() {
		if ( liste == null ) {
			liste = données.getGardes();
		}
		return liste;
	}

	public Garde getCourant() {
		if ( courant == null ) {
			courant = new Garde();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			courant = données.gardeRetrouver( courant.getId() );
			if ( courant == null ) {
				UtilJsf.messageError( "La garde demandée n'existe pas" );
				return "liste";
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		if ( courant.getId() == null) {
			données.gardeAjouter(courant);
		} else {
			données.gardeModifier(courant);
		}
		UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
		return "liste";
	}
	
	public String supprimer( Garde item ) {
		données.gardeSupprimer( item.getId() );
		liste.remove(item);
		UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		return null;
	}
	
	
}
