package nounou.jsf.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import nounou.commun.dto.DtoCategorie;
import nounou.commun.dto.DtoCompte;
import nounou.commun.dto.DtoContrat;
import nounou.commun.dto.DtoParent;
import nounou.commun.dto.DtoPersonne;
import nounou.commun.dto.DtoTelephone;
import nounou.jsf.data.Categorie;
import nounou.jsf.data.Compte;
import nounou.jsf.data.Contrat;
import nounou.jsf.data.Parent;
import nounou.jsf.data.Personne;
import nounou.jsf.data.Telephone;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-19T12:10:09+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class IMapperImpl implements IMapper {

    @Override
    public Compte map(DtoCompte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setEmail( source.getEmail() );
        compte.setId( source.getId() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            compte.setRoles( new ArrayList<String>( list ) );
        }

        return compte;
    }

    @Override
    public DtoCompte map(Compte source) {
        if ( source == null ) {
            return null;
        }

        DtoCompte dtoCompte = new DtoCompte();

        dtoCompte.setEmail( source.getEmail() );
        if ( source.getId() != null ) {
            dtoCompte.setId( source.getId() );
        }
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoCompte.setRoles( new ArrayList<String>( list ) );
        }

        return dtoCompte;
    }

    @Override
    public Compte duplicate(Compte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setEmail( source.getEmail() );
        compte.setId( source.getId() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            compte.setRoles( new ArrayList<String>( list ) );
        }

        return compte;
    }

    @Override
    public Compte update(Compte target, Compte source) {
        if ( source == null ) {
            return null;
        }

        target.setEmail( source.getEmail() );
        target.setId( source.getId() );
        target.setMotDePasse( source.getMotDePasse() );
        target.setPseudo( source.getPseudo() );
        if ( target.getRoles() != null ) {
            List<String> list = source.getRoles();
            if ( list != null ) {
                target.getRoles().clear();
                target.getRoles().addAll( list );
            }
            else {
                target.setRoles( null );
            }
        }
        else {
            List<String> list = source.getRoles();
            if ( list != null ) {
                target.setRoles( new ArrayList<String>( list ) );
            }
        }

        return target;
    }

    @Override
    public Categorie map(DtoCategorie source) {
        if ( source == null ) {
            return null;
        }

        Categorie categorie = new Categorie();

        categorie.setId( source.getId() );
        categorie.setLibelle( source.getLibelle() );

        return categorie;
    }

    @Override
    public DtoCategorie map(Categorie source) {
        if ( source == null ) {
            return null;
        }

        DtoCategorie dtoCategorie = new DtoCategorie();

        if ( source.getId() != null ) {
            dtoCategorie.setId( source.getId() );
        }
        dtoCategorie.setLibelle( source.getLibelle() );

        return dtoCategorie;
    }

    @Override
    public Categorie duplicate(Categorie source) {
        if ( source == null ) {
            return null;
        }

        Categorie categorie = new Categorie();

        categorie.setId( source.getId() );
        categorie.setLibelle( source.getLibelle() );

        return categorie;
    }

    @Override
    public Personne map(DtoPersonne source) {
        if ( source == null ) {
            return null;
        }

        Personne personne = new Personne();

        personne.setCategorie( map( source.getCategorie() ) );
        personne.setId( source.getId() );
        personne.setNom( source.getNom() );
        personne.setPrenom( source.getPrenom() );
        personne.setTelephones( dtoTelephoneListToTelephoneList( source.getTelephones() ) );

        return personne;
    }

    @Override
    public DtoPersonne map(Personne source) {
        if ( source == null ) {
            return null;
        }

        DtoPersonne dtoPersonne = new DtoPersonne();

        dtoPersonne.setCategorie( map( source.getCategorie() ) );
        if ( source.getId() != null ) {
            dtoPersonne.setId( source.getId() );
        }
        dtoPersonne.setNom( source.getNom() );
        dtoPersonne.setPrenom( source.getPrenom() );
        dtoPersonne.setTelephones( telephoneListToDtoTelephoneList( source.getTelephones() ) );

        return dtoPersonne;
    }

    @Override
    public Personne duplicate(Personne source) {
        if ( source == null ) {
            return null;
        }

        Personne personne = new Personne();

        personne.setCategorie( duplicate( source.getCategorie() ) );
        personne.setId( source.getId() );
        personne.setNom( source.getNom() );
        personne.setPrenom( source.getPrenom() );
        personne.setTelephones( duplicate( source.getTelephones() ) );

        return personne;
    }

    @Override
    public Parent map(DtoParent source) {
        if ( source == null ) {
            return null;
        }

        Parent parent = new Parent();

        parent.setAdresse( source.getAdresse() );
        parent.setContrats( dtoContratListToContratList( source.getContrats() ) );
        parent.setTelephone( source.getTelephone() );

        return parent;
    }

    @Override
    public DtoParent map(Parent source) {
        if ( source == null ) {
            return null;
        }

        DtoParent dtoParent = new DtoParent();

        dtoParent.setAdresse( source.getAdresse() );
        dtoParent.setContrats( contratListToDtoContratList( source.getContrats() ) );
        dtoParent.setTelephone( source.getTelephone() );

        return dtoParent;
    }

    @Override
    public Parent duplicate(Parent source) {
        if ( source == null ) {
            return null;
        }

        Parent parent = new Parent();

        parent.setAdresse( source.getAdresse() );
        List<Contrat> list = source.getContrats();
        if ( list != null ) {
            parent.setContrats( new ArrayList<Contrat>( list ) );
        }
        parent.setId( source.getId() );
        parent.setNom( source.getNom() );
        parent.setTelephone( source.getTelephone() );

        return parent;
    }

    @Override
    public Telephone map(DtoTelephone source) {
        if ( source == null ) {
            return null;
        }

        Telephone telephone = new Telephone();

        telephone.setId( source.getId() );
        telephone.setLibelle( source.getLibelle() );
        telephone.setNumero( source.getNumero() );

        return telephone;
    }

    @Override
    public DtoTelephone map(Telephone source) {
        if ( source == null ) {
            return null;
        }

        DtoTelephone dtoTelephone = new DtoTelephone();

        if ( source.getId() != null ) {
            dtoTelephone.setId( source.getId() );
        }
        dtoTelephone.setLibelle( source.getLibelle() );
        dtoTelephone.setNumero( source.getNumero() );

        return dtoTelephone;
    }

    @Override
    public Telephone duplicate(Telephone source) {
        if ( source == null ) {
            return null;
        }

        Telephone telephone = new Telephone();

        telephone.setId( source.getId() );
        telephone.setLibelle( source.getLibelle() );
        telephone.setNumero( source.getNumero() );

        return telephone;
    }

    @Override
    public List<Telephone> duplicate(List<Telephone> source) {
        if ( source == null ) {
            return null;
        }

        List<Telephone> list = new ArrayList<Telephone>( source.size() );
        for ( Telephone telephone : source ) {
            list.add( duplicate( telephone ) );
        }

        return list;
    }

    protected List<Telephone> dtoTelephoneListToTelephoneList(List<DtoTelephone> list) {
        if ( list == null ) {
            return null;
        }

        List<Telephone> list1 = new ArrayList<Telephone>( list.size() );
        for ( DtoTelephone dtoTelephone : list ) {
            list1.add( map( dtoTelephone ) );
        }

        return list1;
    }

    protected List<DtoTelephone> telephoneListToDtoTelephoneList(List<Telephone> list) {
        if ( list == null ) {
            return null;
        }

        List<DtoTelephone> list1 = new ArrayList<DtoTelephone>( list.size() );
        for ( Telephone telephone : list ) {
            list1.add( map( telephone ) );
        }

        return list1;
    }

    protected Contrat dtoContratToContrat(DtoContrat dtoContrat) {
        if ( dtoContrat == null ) {
            return null;
        }

        Contrat contrat = new Contrat();

        contrat.setIdParent( map( dtoContrat.getIdParent() ) );
        contrat.setNom( dtoContrat.getNom() );
        contrat.setPrenom( dtoContrat.getPrenom() );
        contrat.setDateDeNaissance( dtoContrat.getDateDeNaissance() );
        contrat.setTarif( dtoContrat.getTarif() );
        contrat.setIndemEnt( dtoContrat.getIndemEnt() );
        contrat.setIndemRep( dtoContrat.getIndemRep() );
        contrat.setActif( dtoContrat.getActif() );

        return contrat;
    }

    protected List<Contrat> dtoContratListToContratList(List<DtoContrat> list) {
        if ( list == null ) {
            return null;
        }

        List<Contrat> list1 = new ArrayList<Contrat>( list.size() );
        for ( DtoContrat dtoContrat : list ) {
            list1.add( dtoContratToContrat( dtoContrat ) );
        }

        return list1;
    }

    protected DtoContrat contratToDtoContrat(Contrat contrat) {
        if ( contrat == null ) {
            return null;
        }

        DtoContrat dtoContrat = new DtoContrat();

        dtoContrat.setActif( contrat.getActif() );
        dtoContrat.setDateDeNaissance( contrat.getDateDeNaissance() );
        dtoContrat.setIdParent( map( contrat.getIdParent() ) );
        dtoContrat.setIndemEnt( contrat.getIndemEnt() );
        dtoContrat.setIndemRep( contrat.getIndemRep() );
        dtoContrat.setNom( contrat.getNom() );
        dtoContrat.setPrenom( contrat.getPrenom() );
        dtoContrat.setTarif( contrat.getTarif() );

        return dtoContrat;
    }

    protected List<DtoContrat> contratListToDtoContratList(List<Contrat> list) {
        if ( list == null ) {
            return null;
        }

        List<DtoContrat> list1 = new ArrayList<DtoContrat>( list.size() );
        for ( Contrat contrat : list ) {
            list1.add( contratToDtoContrat( contrat ) );
        }

        return list1;
    }
}
