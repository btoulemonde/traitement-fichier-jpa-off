package fr.diginamic.off.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import fr.diginamic.off.entities.Marque;

public class MarqueDaoJpa implements MarqueDao {

	@Override
	public List<Marque> getMarque(String nomMarque, EntityManager em) {
		List<Marque> marques = new ArrayList<>();
		TypedQuery<Marque> query = em.createQuery("select m from Marque m  where m.nom = :ref",
				Marque.class);
		query.setParameter("ref", nomMarque);
		marques = query.getResultList();
	return marques;
	}

	@Override
	public Marque insert(String nomMarque, EntityManager em) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		Marque marque = new Marque();
		marque.setNom(nomMarque);
		em.persist(marque);
		transaction.commit();
		return marque;

	}

}
