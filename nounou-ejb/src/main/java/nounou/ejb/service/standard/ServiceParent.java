package nounou.ejb.service.standard;

import static nounou.commun.dto.Roles.ADMINISTRATEUR;
import static nounou.commun.dto.Roles.UTILISATEUR;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import nounou.commun.dto.DtoParent;
import nounou.commun.dto.DtoTelephone;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceParent;
import nounou.ejb.dao.IDaoParent;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
public class ServiceParent implements IServiceParent {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoParent daoParent;

	@Override
	public int inserer(DtoParent Parent) throws ExceptionValidation {
		return 0;
	}

	@Override
	public void modifier(DtoParent Parent) throws ExceptionValidation {

	}

	@Override
	public void supprimer(int idParent) throws ExceptionValidation {

	}

	@Override
	public DtoParent retrouver(int idParent) {
		return null;
	}

	@Override
	public List<DtoParent> listerTout() {
		return null;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoParent dtoParent) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoParent.getNomParents() == null || dtoParent.getNomParents().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoParent.getNomParents().length() > 20) {
			message.append("\nLe nom est trop long.");
		}
		if (String.valueOf(dtoParent.getTelephone()) == null || String.valueOf(dtoParent.getTelephone()).isEmpty()) {
			message.append("\nLe numéro de téléphone est absent.");
		} else if (String.valueOf(dtoParent.getTelephone()).length() > 25) {
			message.append("\nLe numéro du téléphone est trop long : " + dtoParent.getTelephone());
		}
		if (dtoParent.getAdresse() == null || dtoParent.getAdresse().isEmpty()) {
			message.append("\nL'adresse est absente.");
		} else if (dtoParent.getAdresse().length() > 300) {
			message.append("\nL'adresse est trop long.");
		}
		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
