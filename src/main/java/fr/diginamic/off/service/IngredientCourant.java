package fr.diginamic.off.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.diginamic.off.entities.Ingredient;
import fr.diginamic.off.entities.Produit;

public class IngredientCourant {

	public void traiter(EntityManager em) {
		
		Query query = em.createQuery("select i.nom, sum(i.nom) from Ingredient i order by sum(i.nom)");
		List<Ingredient> ingredients = query.getResultList();
		for (int i=0; i<10; i++){
			System.out.println(ingredients.get(i).getNom());
		}
	}
}