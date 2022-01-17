package nounou.ejb.data.mapper;

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
import nounou.ejb.data.Categorie;
import nounou.ejb.data.Compte;
import nounou.ejb.data.Contrat;
import nounou.ejb.data.Parent;
import nounou.ejb.data.Personne;
import nounou.ejb.data.Telephone;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-17T15:15:55+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class IMapperEjbImpl implements IMapperEjb {

    @Override
    public Parent map(DtoParent Parent) {
        if ( Parent == null ) {
            return null;
        }

        Parent parent = new Parent();

        parent.setAdresse( Parent.getAdresse() );
        parent.setContrats( dtoContratListToContratList( Parent.getContrats() ) );
        parent.setIdCompte( map( Parent.getIdCompte() ) );
        parent.setIdParent( Parent.getIdParent() );
        parent.setNomParents( Parent.getNomParents() );
        parent.setTelephone( Parent.getTelephone() );

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
        dtoParent.setIdCompte( map( source.getIdCompte() ) );
        dtoParent.setIdParent( source.getIdParent() );
        dtoParent.setNomParents( source.getNomParents() );
        dtoParent.setTelephone( source.getTelephone() );

        return dtoParent;
    }

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
        dtoCompte.setId( source.getId() );
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoCompte.setRoles( new ArrayList<String>( list ) );
        }

        return dtoCompte;
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

        dtoCategorie.setId( source.getId() );
        dtoCategorie.setLibelle( source.getLibelle() );

        return dtoCategorie;
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

        addBackReference( personne );

        return personne;
    }

    @Override
    public DtoPersonne map(Personne source) {
        if ( source == null ) {
            return null;
        }

        DtoPersonne dtoPersonne = new DtoPersonne();

        dtoPersonne.setCategorie( map( source.getCategorie() ) );
        dtoPersonne.setId( source.getId() );
        dtoPersonne.setNom( source.getNom() );
        dtoPersonne.setPrenom( source.getPrenom() );
        dtoPersonne.setTelephones( telephoneListToDtoTelephoneList( source.getTelephones() ) );

        return dtoPersonne;
    }

    @Override
    public DtoPersonne mapMinimal(Personne source) {
        if ( source == null ) {
            return null;
        }

        DtoPersonne dtoPersonne = new DtoPersonne();

        dtoPersonne.setId( source.getId() );
        dtoPersonne.setNom( source.getNom() );
        dtoPersonne.setPrenom( source.getPrenom() );

        return dtoPersonne;
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

        dtoTelephone.setId( source.getId() );
        dtoTelephone.setLibelle( source.getLibelle() );
        dtoTelephone.setNumero( source.getNumero() );

        return dtoTelephone;
    }

    protected Contrat dtoContratToContrat(DtoContrat dtoContrat) {
        if ( dtoContrat == null ) {
            return null;
        }

        Contrat contrat = new Contrat();

        contrat.setActif( dtoContrat.getActif() );
        contrat.setDateDeNaissance( dtoContrat.getDateDeNaissance() );
        contrat.setIdParent( map( dtoContrat.getIdParent() ) );
        contrat.setIndemEnt( dtoContrat.getIndemEnt() );
        contrat.setIndemRep( dtoContrat.getIndemRep() );
        contrat.setNom( dtoContrat.getNom() );
        contrat.setPrenom( dtoContrat.getPrenom() );
        contrat.setTarif( dtoContrat.getTarif() );

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
}
