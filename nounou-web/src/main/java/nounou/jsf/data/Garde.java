package nounou.jsf.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Garde implements Serializable {

	// Champs

	private Integer id;

	private Integer idGarde;

	private Boolean repas;

	private Date dateGarde;

	private Time heureArr;

	private Time heureDep;

	// Constructeurs

	public Garde() {
	}

	public Garde(Integer id, Boolean repas, Date dateGarde, Time heureArr, Time heureDep) {
		super();
		this.id = id;
		this.repas = repas;
		this.dateGarde = dateGarde;
		this.heureArr = heureArr;
		this.heureDep = heureDep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdGarde() {
		return idGarde;
	}

	public void setIdGarde(Integer idGarde) {
		this.idGarde = idGarde;
	}

	public Boolean getRepas() {
		return repas;
	}

	public void setRepas(Boolean repas) {
		this.repas = repas;
	}

	public Date getDateGarde() {
		return dateGarde;
	}

	public void setDateGarde(Date dateGarde) {
		this.dateGarde = dateGarde;
	}

	public Time getHeureArr() {
		return heureArr;
	}

	public void setHeureArr(Time heureArr) {
		this.heureArr = heureArr;
	}

	public Time getHeureDep() {
		return heureDep;
	}

	public void setHeureDep(Time heureDep) {
		this.heureDep = heureDep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garde other = (Garde) obj;
		return Objects.equals(id, other.id);
	}

}
