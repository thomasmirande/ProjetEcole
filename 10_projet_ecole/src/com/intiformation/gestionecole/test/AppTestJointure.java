package com.intiformation.gestionecole.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.intiformation.gestionecole.dao.EnseignantDaoImpl;
import com.intiformation.gestionecole.dao.MatiereDao;
import com.intiformation.gestionecole.dao.PromotionDao;
import com.intiformation.gestionecole.entity.Enseignant;
import com.intiformation.gestionecole.entity.Promotion;

public class AppTestJointure {
	public static void main(String[] args) {
		MatiereDao matiereDao = new MatiereDao();
		EnseignantDaoImpl enseignantDao = new EnseignantDaoImpl();
		PromotionDao promotionDao = new PromotionDao();
		
		//1.création d'un eetudiant
				Promotion promotion1= new Promotion("JaveE");
						
				//2.création d'un formateur
				Enseignant enseignantJava = new Enseignant("secret","jean","maurice", "jojo@mail.com");
				
				
		
						

	}//end main
}
