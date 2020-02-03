package com.intiformation.gestionecole.tool;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class JpaUtil {
	private static EntityManager entityManager;
	private static String puName = "10_2_tp_gestion_ecole";
	
	/**
	 * Recup une EntityManager
	 * @return
	 */
	public static EntityManager getInstance() {
		if(entityManager == null ) {
			try {
				entityManager = Persistence.createEntityManagerFactory(puName).createEntityManager();
				
			} catch (PersistenceException e) {
				System.out.println("La création de l'EntityManager a échoué");
				e.printStackTrace();
			}
		}// end if
		return entityManager;
	}// end getInstance
}
