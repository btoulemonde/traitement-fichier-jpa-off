package fr.diginamic.off.dao;

import java.util.List;
import javax.persistence.EntityManager;
import fr.diginamic.off.entities.Categorie;

public interface CategorieDao {
	
	
	/**Méthode permettant d'extraire une liste des categories
	 * @return retourne une liste des caegories
	 */
	List<Categorie> getCategorie(String nomCategorie, EntityManager em);
	
	/**méthode pour insérer toutes les categories vers la base de donnée.
	 * @param Categorie
	 */
	Categorie insert(String nomCategorie, EntityManager em);
	

}
