package fr.diginamic.off.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;

	public static EntityManager init() {
		emf = Persistence.createEntityManagerFactory("open-food-facts");
		return em = emf.createEntityManager();
	}

	public static void close() {
		if (em != null) {
			em.close();
		}
		if (emf != null) {
			emf.close();
		}
	}

}
