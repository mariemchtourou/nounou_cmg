package nounou.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nounou.ejb.dao.IDaoContrat;
import nounou.ejb.data.Categorie;
import nounou.ejb.data.Contrat;
import nounou.ejb.data.Parent;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoContrat implements IDaoContrat {


	@PersistenceContext
	private EntityManager	em;
	
	@Override
	public int inserer(Contrat contrat) {
		em.persist(contrat);
		em.flush();
		return contrat.getIdContrat();
	}

	@Override
	public void modifier(Contrat contrat) {
		em.merge( contrat );
	}

	@Override
	public void supprimer(int idContrat) {
		em.remove( retrouver(idContrat) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Contrat retrouver(int idContrat) {
		return em.find( Contrat.class, idContrat );
	}

	@Override
	public List<Contrat> listerParParents(Parent parent) {
		em.clear();
		var jpql = "SELECT c FROM Contrat c WHERE c.idcompte =:id ORDER BY c.idContrat";
		var query = em.createQuery( jpql, Contrat.class );
		return query.setParameter("id", parent.getIdCompte()).getResultList();
	}

	@Override
	public List<Contrat> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Contrat c ORDER BY c.idContrat";
		var query = em.createQuery( jpql, Contrat.class );
		return query.getResultList();
	}

	@Override
	public void updateStatut(Contrat contrat) {
		if(contrat.getActif()) {contrat.setActif(false);}
		else {contrat.setActif(true);}
		em.merge(contrat);
	}

}
