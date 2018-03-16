package com.demo.pojosModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClaseDAO {
		private static final String PERSISTENCE_UNIT_NAME = "test1";
		private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		private EntityManager em;

		public EntityManager getEntityManager() {
			if (em == null){
				em = emf.createEntityManager();
			}
			return em; 
		}	
}
