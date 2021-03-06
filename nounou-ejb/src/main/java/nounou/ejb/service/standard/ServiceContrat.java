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
import nounou.commun.dto.DtoParent;
import nounou.commun.dto.DtoTelephone;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceContrat;
import nounou.ejb.dao.IDaoContrat;
import nounou.ejb.data.Contrat;
import nounou.ejb.data.Parent;
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
	public List<DtoContrat> listerParParents(DtoParent parent) {
		List<DtoContrat> liste = new ArrayList<>();
		for (Contrat contrat : daoContrat.listerParParents(mapper.map(parent))) {
			liste.add( mapper.map(contrat) );
		}
		return liste;
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoContrat> listerTout() {
		List<DtoContrat> liste = new ArrayList<>();
		for (Contrat contrat : daoContrat.listerTout()) {
			liste.add( mapper.map(contrat) );
		}
		return liste;
	}
	
	@Override
	public void updateStatut(DtoContrat dtoContrat) throws ExceptionValidation{
		verifierValiditeDonnees(dtoContrat);
		daoContrat.updateStatut(mapper.map(dtoContrat));
		
	}

	
	// M??thodes auxiliaires

		private void verifierValiditeDonnees(DtoContrat dtoContrat) throws ExceptionValidation {

			StringBuilder message = new StringBuilder();

			if (dtoContrat.getNom() == null || dtoContrat.getNom().isEmpty()) {
				message.append("\nLe nom est absent.");
			} else if (dtoContrat.getNom().length() > 25) {
				message.append("\nLe nom est trop long.");
			}

			if (dtoContrat.getPrenom() == null || dtoContrat.getPrenom().isEmpty()) {
				message.append("\nLe pr??nom est absent.");
			} else if (dtoContrat.getPrenom().length() > 25) {
				message.append("\nLe pr??nom est trop long.");
			}
			
			if (dtoContrat.getDateDeNaissance() == null ) {
				message.append("\nLa date de naissance est absente.");
			}
			if (dtoContrat.getTarif() == null ) {
				message.append("\nLe tarif est absent.");
			}else if (dtoContrat.getTarif() < 0) {
				message.append("\nLe Tarif est invalide.");
			}
			if (dtoContrat.getIndemEnt() == null ) {
				message.append("\nLes Indemnit??s d???entretien sont absents.");
			}else if (dtoContrat.getTarif() < 0) {
				message.append("\nLes Indemnit??s d???entretien sont invalides.");
			}
			if (dtoContrat.getIndemEnt() == null ) {
				message.append("\nLes Indemnit??s de repas sont absents.");
			}else if (dtoContrat.getTarif() < 0) {
				message.append("\nLes Indemnit??s de repas sont invalides.");
			}
			if (message.length() > 0) {
				throw new ExceptionValidation(message.toString().substring(1));
			}
		}



}
