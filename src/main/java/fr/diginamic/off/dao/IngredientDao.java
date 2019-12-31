package fr.diginamic.off.dao;

import java.util.List;
import javax.persistence.EntityManager;
import fr.diginamic.off.entities.Ingredient;



public interface IngredientDao {
	
	/**Méthode permettant d'extraire une liste des ingredients
	 * @return retourne une liste des ingredients
	 */
	List<Ingredient> getIngredient(String ingredient, EntityManager em);
	
	/**méthode pour insérer touts les ingredients vers la base de donnée.
	 * @param Ingredient
	 */
	Ingredient insert(String ingredient, EntityManager em);
	

}
