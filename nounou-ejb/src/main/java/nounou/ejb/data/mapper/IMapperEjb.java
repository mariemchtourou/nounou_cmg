package nounou.ejb.data.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import nounou.commun.dto.DtoCategorie;
import nounou.commun.dto.DtoCompte;
<<<<<<< HEAD
import nounou.commun.dto.DtoContrat;
=======
import nounou.commun.dto.DtoParent;
>>>>>>> branch 'master' of https://github.com/mariemchtourou/nounou_cmg.git
import nounou.commun.dto.DtoPersonne;
import nounou.commun.dto.DtoTelephone;
import nounou.ejb.data.Categorie;
import nounou.ejb.data.Compte;
<<<<<<< HEAD
import nounou.ejb.data.Contrat;
=======
import nounou.ejb.data.Parent;
>>>>>>> branch 'master' of https://github.com/mariemchtourou/nounou_cmg.git
import nounou.ejb.data.Personne;
import nounou.ejb.data.Telephone;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	//Parent
	
	Parent map( DtoParent Parent );
	
	DtoParent map( Parent source ); 
	
	
	// Compte
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );

	
	// Categorie
	
	Categorie map( DtoCategorie source );
	
	DtoCategorie map( Categorie source );

	
	// Personne
	
	Personne map( DtoPersonne source );
	
	DtoPersonne map( Personne source );

	@Mapping( target="categorie", ignore = true )
	@Mapping( target="telephones", ignore = true )
	DtoPersonne mapMinimal( Personne source );
	
<<<<<<< HEAD
	//Contrat
	
	Contrat map( DtoContrat source );
	
	DtoContrat map( Contrat source);
	
	@Mapping( target="IdParent", ignore = true )
	DtoContrat mapMinimal( Contrat source );
	
=======
>>>>>>> branch 'master' of https://github.com/mariemchtourou/nounou_cmg.git
	// Telephone
	
	@Mapping( target="personne", ignore=true )
	Telephone map( DtoTelephone source );
	
	DtoTelephone map( Telephone source );
	

	// Méthodes auxiliaires
	
    @AfterMapping
    public default void addBackReference(@MappingTarget Personne target) {
        for (Telephone telephone : target.getTelephones() ) {
        	telephone.setPersonne( target );
        }
    }	
	
}
