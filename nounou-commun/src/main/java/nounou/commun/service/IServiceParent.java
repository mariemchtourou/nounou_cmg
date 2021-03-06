package nounou.commun.service;

import java.util.List;

import nounou.commun.dto.DtoParent;
import nounou.commun.exception.ExceptionValidation;

public interface IServiceParent {

	int inserer(DtoParent Parent) throws ExceptionValidation;

	void modifier(DtoParent Parent) throws ExceptionValidation;

	void supprimer(int idParent) throws ExceptionValidation;

	DtoParent retrouver(int idParent);

	List<DtoParent> listerTout();

}
