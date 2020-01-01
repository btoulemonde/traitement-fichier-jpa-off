package fr.diginamic.off.service;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.off.entities.Produit;

public class MeilleurProduitCategorie {
	Scanner scanner = new Scanner(System.in);

	public void traiter(EntityManager em) {
		System.out.println("veuillez saisir une catégorie: ");
		String choix = scanner.next();

		Query query = em.createQuery("select p from Produit p join p.categorie c where c.nom = '" + choix
				+ "' order by p.scoreNutritionnel");
		List<Produit> produits = query.getResultList();
		for (Produit prod : produits) {
			System.out.println(prod.getNom() + " / " + prod.getScoreNutritionnel());
		}
	}
}
