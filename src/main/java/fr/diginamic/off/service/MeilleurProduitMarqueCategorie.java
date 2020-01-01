package fr.diginamic.off.service;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.off.entities.Produit;

public class MeilleurProduitMarqueCategorie {
	
	Scanner scanner = new Scanner(System.in);
	public void traiter(EntityManager em){
		
		
		
		System.out.println("Veuillez choisir une marque: ");
		String choixMarque = scanner.nextLine();
		
		System.out.println("Veuillez choisir une catégorie de produit: ");
		String choixCategorie = scanner.nextLine();
		Query query = em.createQuery("select p from Produit p join p.categorie c join p.marque m where c.nom = '" + choixCategorie
				+ "' and m.nom='" + choixMarque + "' order by p.scoreNutritionnel");
		List<Produit> produits = query.getResultList();
		for (Produit prod : produits) {
			System.out.println(prod.getNom() + " / " + prod.getScoreNutritionnel());
		}
		
	}
}
