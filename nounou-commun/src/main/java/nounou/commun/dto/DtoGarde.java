package nounou.commun.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@SuppressWarnings("serial")
public class DtoGarde implements Serializable  {
	
	// Champs

			private int				IdGarde;	
			
			private DtoContrat			 	IdContrat;
			
			private Date			DateGarde;
			
			private Time			HeureArr;
			
			private Time			HeureDep;
			
			private Boolean 		Repas;

	// Constructors
			
			public DtoGarde() {
				
			}
			
			public DtoGarde(DtoContrat idContrat, Date dateGarde, Time heureArr, Time heureDep, Boolean repas) {
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


			public DtoContrat getIdContrat() {
				return IdContrat;
			}

			public void setIdContrat(DtoContrat idContrat) {
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


