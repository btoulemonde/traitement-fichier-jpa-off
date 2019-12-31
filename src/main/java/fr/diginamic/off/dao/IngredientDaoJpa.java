package fr.diginamic.off.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import fr.diginamic.off.entities.Ingredient;

public class IngredientDaoJpa implements IngredientDao {

	@Override
	public List<Ingredient> getIngredient(String nomIngredient, EntityManager em) {
		List<Ingredient> ingredients = new ArrayList<>();
		TypedQuery<Ingredient> query = em.createQuery("select i from Ingredient i where i.nom = :ref",
				Ingredient.class);
		query.setParameter("ref", nomIngredient);
		ingredients = query.getResultList();
	return ingredients;
	}

	@Override
	public Ingredient insert(String nomIngredient, EntityManager em) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		Ingredient ingredient = new Ingredient();
		ingredient.setNom(nomIngredient);
		em.persist(ingredient);
		transaction.commit();
		return ingredient;
	}
	
}	
