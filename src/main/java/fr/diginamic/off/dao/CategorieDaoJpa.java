package fr.diginamic.off.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import fr.diginamic.off.entities.Categorie;

public class CategorieDaoJpa implements CategorieDao {

	@Override
	public List<Categorie> getCategorie(String nomCategorie, EntityManager em) {
		List<Categorie> categories = new ArrayList<>();
			TypedQuery<Categorie> query = em.createQuery("select c from Categorie c where c.nom = :ref",
					Categorie.class);
			query.setParameter("ref", nomCategorie);
			categories = query.getResultList();
		return categories;

	}

	@Override
	public Categorie insert(String nomCategorie, EntityManager em) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		Categorie categorie = new Categorie();
		categorie.setNom(nomCategorie);
		em.persist(categorie);
		
		transaction.commit();
		return categorie;
	}

}
