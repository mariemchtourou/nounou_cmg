package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Contrat;
import nounou.ejb.data.Parent;

public interface IDaoContrat {

	int			inserer( Contrat contrat );

	void 		modifier( Contrat contrat );

	void 		supprimer( int idContrat );

	Contrat 	retrouver( int idContrat );
	
	List<Contrat> listerParParents(Parent parent);

	List<Contrat> listerTout();
}
