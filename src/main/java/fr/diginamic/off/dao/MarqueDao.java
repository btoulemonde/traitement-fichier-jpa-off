package fr.diginamic.off.dao;

import java.util.List;
import javax.persistence.EntityManager;
import fr.diginamic.off.entities.Marque;

public interface MarqueDao {
	/**Méthode permettant d'extraire une liste des marques
	 * @return retourne une liste des marques
	 */
	List<Marque> getMarque(String nomMarque, EntityManager em);
	
	/**méthode pour insérer toutes les Marques vers la base de donnée.
	 * @param Marque
	 */
	Marque insert(String nomMarque, EntityManager em);
	

}
