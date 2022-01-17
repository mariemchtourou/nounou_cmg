package nounou.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import static nounou.commun.dto.Roles.ADMINISTRATEUR;
import static nounou.commun.dto.Roles.UTILISATEUR;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import nounou.commun.dto.DtoContrat;
import nounou.commun.dto.DtoTelephone;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceContrat;
import nounou.ejb.dao.IDaoContrat;
import nounou.ejb.data.Contrat;
import nounou.ejb.data.Personne;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
public class ServiceContrat implements IServiceContrat {

	// Champs
		@Inject
		private IMapperEjb mapper;
		@Inject
		private IDaoContrat daoContrat;
		
	@Override
	public int inserer(DtoContrat dtoContrat) throws ExceptionValidation{
		verifierValiditeDonnees(dtoContrat);
		int id = daoContrat.inserer(mapper.map(dtoContrat));
		return id;
	}

	@Override
	public void modifier(DtoContrat dtoContrat) throws ExceptionValidation{
		verifierValiditeDonnees(dtoContrat);
		daoContrat.modifier(mapper.map(dtoContrat));
	}

	@Override
	public void supprimer(int idContrat) {
		daoContrat.supprimer(idContrat);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoContrat retrouver(int idContrat) {
		Contrat contrat = daoContrat.retrouver(idContrat);
		return mapper.map(contrat);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoContrat> listerParParents(DtoContrat parent) {
		List<DtoContrat> liste = new ArrayList<>();
		for (Contrat contrat : daoContrat.listerParParents()) {
			liste.add( mapper.mapMinimal(contrat) );
		}
		return liste;
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoContrat> listerTout() {
		List<DtoContrat> liste = new ArrayList<>();
		for (Contrat contrat : daoContrat.listerTout()) {
			liste.add( mapper.mapMinimal(contrat) );
		}
		return liste;
	}
	
	// Méthodes auxiliaires

		private void verifierValiditeDonnees(DtoContrat dtoContrat) throws ExceptionValidation {

			StringBuilder message = new StringBuilder();

			if (dtoContrat.getNom() == null || dtoContrat.getNom().isEmpty()) {
				message.append("\nLe nom est absent.");
			} else if (dtoContrat.getNom().length() > 25) {
				message.append("\nLe nom est trop long.");
			}

			if (dtoContrat.getPrenom() == null || dtoContrat.getPrenom().isEmpty()) {
				message.append("\nLe prénom est absent.");
			} else if (dtoContrat.getPrenom().length() > 25) {
				message.append("\nLe prénom est trop long.");
			}
			
			if (dtoContrat.getDateDeNaissance() == null ) {
				message.append("\nLa date de naissance est absent.");
			}
			if (dtoContrat.getTarif() == null ) {
				message.append("\nLe tarif est absent.");
			}else if (dtoContrat.getTarif() < 0) {
				message.append("\nLe Tarif est invalide.");
			}
			if (dtoContrat.getIndemEnt() == null ) {
				message.append("\nLe Indemnités d’entretien est absent.");
			}else if (dtoContrat.getTarif() < 0) {
				message.append("\nLe Indemnités d’entretien est invalide.");
			}
			if (dtoContrat.getIndemEnt() == null ) {
				message.append("\nLe Indemnités de repas est absent.");
			}else if (dtoContrat.getTarif() < 0) {
				message.append("\nLe Indemnités de repas est invalide.");
			}
			if (message.length() > 0) {
				throw new ExceptionValidation(message.toString().substring(1));
			}
		}


}
