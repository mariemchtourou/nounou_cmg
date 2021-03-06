package nounou.ejb.service.standard;

import static nounou.commun.dto.Roles.ADMINISTRATEUR;
import static nounou.commun.dto.Roles.UTILISATEUR;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import nounou.commun.dto.DtoGarde;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceGarde;
import nounou.ejb.dao.IDaoGarde;
import nounou.ejb.data.Garde;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
public class ServiceGarde implements IServiceGarde {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoGarde daoGarde;

	// Actions

	@Override
	public int inserer(DtoGarde dtoGarde) throws ExceptionValidation {
		int id = daoGarde.inserer(mapper.map(dtoGarde));
		return id;
	}

	@Override
	public void modifier(DtoGarde dtoGarde) throws ExceptionValidation {
		daoGarde.modifier(mapper.map(dtoGarde));
	}

	@Override
	public void supprimer(int idGarde) throws ExceptionValidation {
		daoGarde.supprimer(idGarde);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoGarde retrouver(int idGarde) {
		Garde garde = daoGarde.retrouver(idGarde);
		return mapper.map(garde);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoGarde> listerTout() {
		List<DtoGarde> liste = new ArrayList<>();
		for (Garde garde : daoGarde.listerTout()) {
			liste.add( mapper.map(garde) );
		}
		return liste;
	}

}
