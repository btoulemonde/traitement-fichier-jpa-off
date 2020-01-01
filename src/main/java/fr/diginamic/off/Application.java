package fr.diginamic.off;

import java.util.Scanner;
import javax.persistence.EntityManager;
import fr.diginamic.off.dao.Dao;
import fr.diginamic.off.service.IngredientCourant;
import fr.diginamic.off.service.MeilleurProduitCategorie;
import fr.diginamic.off.service.MeilleurProduitMarque;
import fr.diginamic.off.service.MeilleurProduitMarqueCategorie;

public class Application {

	public static void main(String[] args) {
		EntityManager em = Dao.init();
		Scanner scanner = new Scanner(System.in);
		int choix = 0;
		do {
			System.out.println("----MENU----\n");
			System.out.println("1: Rechercher les meilleurs produits pour une Marque donnée ");
			System.out.println("2: Rechercher les meilleurs produits pour une Catégorie donnée");
			System.out.println("3: Rechercher les meilleurs produits par Marque et par Catégorie ");
			System.out.println(
					"4: Afficher les ingredients les plus courants avec le nb de produits dans lesquels ils apparaissent ");
			System.out.println("6: Sortir");

			String choixUser = scanner.next();
			choix = Integer.parseInt(choixUser);

			switch (choix) {
			case 1:
				MeilleurProduitMarque meilleurProduitMarque = new MeilleurProduitMarque();
				meilleurProduitMarque.traiter(em);
				break;
			case 2:
				MeilleurProduitCategorie meilleurProduitCategorie = new MeilleurProduitCategorie();
				meilleurProduitCategorie.traiter(em);
				break;
			 case 3:
			 MeilleurProduitMarqueCategorie meilleurProduitMarqueCategorie = new MeilleurProduitMarqueCategorie();
			 meilleurProduitMarqueCategorie.traiter(em);
			 break;
			 case 4:
			 IngredientCourant ingredientCourant = new IngredientCourant();
			 ingredientCourant.traiter(em);
			 break;
			}
		} while (choix != 6);
		Dao.close();
	}
}
