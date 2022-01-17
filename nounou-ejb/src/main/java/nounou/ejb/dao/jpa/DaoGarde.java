package nounou.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nounou.ejb.dao.IDaoGarde;
import nounou.ejb.data.Garde;
import nounou.ejb.data.Parent;

@Stateless
@Local
@TransactionAttribute(MANDATORY)
public class DaoGarde implements IDaoGarde {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int inserer(Garde garde) {
		em.persist(garde);
		em.flush();
		return garde.getIdGarde();
	}

	@Override
	public void modifier(Garde garde) {
		em.merge( garde );
	}

	@Override
	public void supprimer(int idGarde) {
		em.remove( retrouver(idGarde) );
	}
	
	@TransactionAttribute( NOT_SUPPORTED )
	@Override
	public Garde retrouver(int idGarde) {
		return em.find( Garde.class, idGarde );
	}

	@SuppressWarnings(value = { "unchecked" })
	@Override
	public List<Garde> listerParDuree(int jours) {
		LocalDate dateInitial = LocalDate.now().minusDays(jours);
		LocalDate dateMtn = LocalDate.now();
		em.clear();
		return em.createQuery("SELECT g from Garde g WHERE g.dateGarde BETWEEN ?1 AND ?2 ORDER BY g.dateGardes")
		.setParameter(1,dateInitial)
		.setParameter(2,dateMtn)
		.getResultList();
	}

	@Override
	public List<Garde> listerTout() {
		em.clear();
		var jpql = "SELECT g FROM Garde g ORDER BY g.idGarde";
		var query = em.createQuery( jpql, Garde.class );
		return query.getResultList();
	}

}
