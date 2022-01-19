package nounou.jsf.data.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import nounou.commun.dto.DtoCategorie;
import nounou.commun.dto.DtoContrat;
import nounou.commun.dto.DtoParent;
import nounou.commun.dto.DtoPersonne;
import nounou.commun.dto.DtoTelephone;
import nounou.jsf.data.Categorie;
import nounou.jsf.data.Contrat;
import nounou.jsf.data.Parent;
import nounou.jsf.data.Personne;
import nounou.jsf.data.Telephone;


@Mapper( componentModel = "cdi" )
public interface IMapper {

	// Contrat 
	
	Contrat    map( DtoContrat source );
	
	DtoContrat map( Contrat source );
	
	Contrat duplicate( Contrat source );

	Contrat update( @MappingTarget Contrat target, Contrat source );


	// Categorie
	
	Categorie    map( DtoCategorie source );
	
	DtoCategorie map( Categorie source );
	
	Categorie duplicate( Categorie source );

	
	// Personne
	
	Personne    map( DtoPersonne source );
	
	DtoPersonne map( Personne source );
	
    Personne duplicate( Personne source );

	// Parent
	
    Parent    map( DtoParent source );
	
	DtoParent map( Parent source );
	
	Parent duplicate( Parent source );

	
	// Telephone
	
	Telephone    map( DtoTelephone source );
	
	DtoTelephone map( Telephone source );

    // Méthodes nécessaire pour update( Personne )

	Telephone duplicate( Telephone source );

	List<Telephone> duplicate( List<Telephone> source );

}
