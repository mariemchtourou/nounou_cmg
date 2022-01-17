package nounou.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "garde")
public class Garde {
	// Champs

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idgarde")
	private int IdGarde;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcontrat")
	private Contrat IdContrat;

	@Column(name = "dategarde")
	private Date DateGarde;

	@Column(name = "heurearr")
	private Time HeureArr;

	@Column(name = "heuredep")
	private Time HeureDep;

	@Column(name = "repas")
	private Boolean Repas;

// Constructors

	public Garde() {

	}

	public Garde(Contrat idContrat, Date dateGarde, Time heureArr, Time heureDep, Boolean repas) {
		super();
		IdContrat = idContrat;
		DateGarde = dateGarde;
		HeureArr = heureArr;
		HeureDep = heureDep;
		Repas = repas;
	}

// Getters and Setters

	public int getIdGarde() {
		return IdGarde;
	}

	public Contrat getIdContrat() {
		return IdContrat;
	}

	public void setIdContrat(Contrat idContrat) {
		IdContrat = idContrat;
	}

	public Date getDateGarde() {
		return DateGarde;
	}

	public void setDateGarde(Date dateGarde) {
		DateGarde = dateGarde;
	}

	public Time getHeureArr() {
		return HeureArr;
	}

	public void setHeureArr(Time heureArr) {
		HeureArr = heureArr;
	}

	public Time getHeureDep() {
		return HeureDep;
	}

	public void setHeureDep(Time heureDep) {
		HeureDep = heureDep;
	}

	public Boolean getRepas() {
		return Repas;
	}

	public void setRepas(Boolean repas) {
		Repas = repas;
	}
}
