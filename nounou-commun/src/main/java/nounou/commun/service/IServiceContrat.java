package nounou.commun.service;

import java.util.List;

import nounou.commun.dto.DtoContrat;
import nounou.commun.dto.DtoParent;
import nounou.commun.dto.DtoPersonne;
import nounou.commun.exception.ExceptionValidation;


public interface IServiceContrat {
	
	int			inserer( DtoContrat contrat ) throws ExceptionValidation;

	void 		modifier( DtoContrat contrat ) throws ExceptionValidation;

	void 		supprimer( int idContrat ) throws ExceptionValidation;

	DtoContrat 	retrouver( int idContrat );
	
	List<DtoContrat> listerParParents(DtoParent parent);

	List<DtoContrat> listerTout();

	void updateStatut(DtoContrat dtoContrat) throws ExceptionValidation;
	

}
