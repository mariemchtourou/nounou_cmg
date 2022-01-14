package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Parent;

public interface IDaoParent {

	int inserer(Parent Parent);

	void modifier(Parent Parent);

	void supprimer(int idParent);

	Parent retrouver(int idParent);

	List<Parent> listerTout();

}
