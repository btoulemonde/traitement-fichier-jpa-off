package fr.diginamic.off.utils;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import fr.diginamic.off.dao.CategorieDaoJpa;
import fr.diginamic.off.dao.Dao;
import fr.diginamic.off.dao.IngredientDaoJpa;
import fr.diginamic.off.dao.MarqueDaoJpa;
import fr.diginamic.off.dao.ProduitDaoJpa;
import fr.diginamic.off.entities.Categorie;
import fr.diginamic.off.entities.Ingredient;
import fr.diginamic.off.entities.Marque;

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) {
		Categorie categorie = new Categorie();
		Marque marque = new Marque();
		List<String> lignes = LectureDonnees.lire("C:/work/open-food-facts.csv");

		EntityManager em = Dao.init();

		ProduitDaoJpa produitDao = new ProduitDaoJpa();
		CategorieDaoJpa categorieDao = new CategorieDaoJpa();
		MarqueDaoJpa marqueDao = new MarqueDaoJpa();
		IngredientDaoJpa ingredientDao = new IngredientDaoJpa();

		for (String ligne : lignes) {
			String[] split = ligne.split("\\|");
			if (categorieDao.getCategorie(split[0], em).size() == 0) {
				categorie = categorieDao.insert(split[0], em);
			}
			if (marqueDao.getMarque(split[1], em).size() == 0) {
				marque = marqueDao.insert(split[1], em);
			}

			String[] split2 = split[4].replace("_", " ").replace(";", ",").split(",");
			List<Ingredient> ingredients = new ArrayList<>();

			for (String ing : split2) {
				if (ingredientDao.getIngredient(ing, em).size() == 0 && ing.length() < 255) {
					ingredientDao.insert(ing, em);
				}
				if (ing.length() < 255) {
					Ingredient ingredient = ingredientDao.getIngredient(ing, em).get(0);
					ingredients.add(ingredient);
				}
			}
			produitDao.insert(split[2], split[3], em, categorie, marque, ingredients);
		}
		Dao.close();
	}
}
