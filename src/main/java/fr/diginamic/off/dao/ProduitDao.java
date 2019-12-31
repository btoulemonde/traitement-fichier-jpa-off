package fr.diginamic.off.dao;

import java.util.List;

import javax.persistence.EntityManager;

import fr.diginamic.off.entities.Categorie;
import fr.diginamic.off.entities.Ingredient;
import fr.diginamic.off.entities.Marque;
import fr.diginamic.off.entities.Produit;


public interface ProduitDao {
	
	/**Méthode permettant d'extraire une liste des produits
	 * @return retourne une liste des produits
	 */
	List<Produit> getProduit(String nomProduit, EntityManager em);
	
	/**méthode pour insérer tous les produits vers la base de donnée.
	 * @param Produit
	 */
	Produit insert(String nomProduit, String scoreNutritionnel, EntityManager em, Categorie categorie,Marque marque,List<Ingredient> ingredients);
	

}
