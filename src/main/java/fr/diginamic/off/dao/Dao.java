package fr.diginamic.off.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	   public void begin() {
	      emf = Persistence.createEntityManagerFactory("open-food-facts");
	      em = emf.createEntityManager();
	   }

	   public void close() {
	      if (em != null) {
	         em.close();
	      }
	   }
}
