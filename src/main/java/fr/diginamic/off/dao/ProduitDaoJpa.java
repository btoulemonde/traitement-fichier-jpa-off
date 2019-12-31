package fr.diginamic.off.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import fr.diginamic.off.entities.Categorie;
import fr.diginamic.off.entities.Ingredient;
import fr.diginamic.off.entities.Marque;
import fr.diginamic.off.entities.Produit;

public class ProduitDaoJpa implements ProduitDao {

	@Override
	public List<Produit> getProduit(String nomProduit, EntityManager em) {
		List<Produit> produits = new ArrayList<>();
		TypedQuery<Produit> query = em.createQuery("select p from Produit p where p.nom = :ref", Produit.class);
		query.setParameter("ref", nomProduit);
		produits = query.getResultList();
		return produits;
	}

	@Override
	public Produit insert(String nomProduit, String scoreNutritionnel, EntityManager em, Categorie categorie,
			Marque marque,List<Ingredient> ingredients) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		Produit produit = new Produit();
		produit.setNom(nomProduit);
		produit.setScoreNutritionnel(scoreNutritionnel);
		produit.setCategorie(categorie);
		produit.setMarque(marque);
		produit.setIngredients(ingredients);
		
		em.persist(produit);
		transaction.commit();
		return produit;

	}

}
