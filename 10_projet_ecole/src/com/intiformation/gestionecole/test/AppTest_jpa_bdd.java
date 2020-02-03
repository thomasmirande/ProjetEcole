package com.intiformation.gestionecole.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.intiformation.gestionecole.dao.AideDao;
import com.intiformation.gestionecole.dao.CoursDao;
import com.intiformation.gestionecole.dao.MatiereDao;
import com.intiformation.gestionecole.dao.PromotionDao;
import com.intiformation.gestionecole.entity.Aide;
import com.intiformation.gestionecole.entity.Cours;
import com.intiformation.gestionecole.entity.Matiere;
import com.intiformation.gestionecole.entity.Promotion;

public class AppTest_jpa_bdd {

	public static void main(String[] args) {
		
		Aide aide1 = new Aide(2, "contenu de l'aide 1");	
		Aide aide2 = new Aide(4, "conteneu de la page 2");
		Aide aide3 = new Aide(56, "contenu de l'aide 3");
		
		AideDao aideDao = new AideDao();
		
		aideDao.add(aide1);
		aideDao.add(aide2);
		aideDao.add(aide3);
		
		List<Aide> liste = aideDao.getAll();
		
		System.out.println("-----------------------");
		for (Aide a : liste) {
			System.out.println("\t > " + a);
		}
		
		Aide aide3Modif = new Aide(74, "modification du contenu de l'aide 3");
		
		
		
		System.out.println("Aide 3 avant modif : " + aide3);
		aideDao.update(aide3Modif, 3);
		System.out.println("Aide 3 après modif modif : " + aide3);
		
		aideDao.delete(3);
		
		List<Aide> liste2 = aideDao.getAll();
		
		System.out.println("-----------------------");
		for (Aide a : liste2) {
			System.out.println("\t > " + a);
		}
		
		CoursDao coursDao = new CoursDao();
		MatiereDao matiereDao = new MatiereDao();
		PromotionDao promoDao = new PromotionDao();
		
		Cours cours1 = new Cours("java les fondamentaux", "2020/12/12", "1h", "difficulté 0");
		Cours cours2 = new Cours("histoire de l'art", "2020/05/14", "2h", "");
		
		Promotion promo1 = new Promotion("Formation Java");
		Promotion promo2 = new Promotion("Master histoire de l'art");
		
		Matiere matiere1 = new Matiere("Développement");
		Matiere matiere2 = new Matiere("Histoire");
		
		coursDao.add(cours1);
		coursDao.add(cours2);
		matiereDao.add(matiere1);
		matiereDao.add(matiere2);
		promoDao.add(promo1);
		promoDao.add(promo2);
		
		coursDao.attribuerMatiere(cours1, matiere1);
		coursDao.attribuerMatiere(cours2, matiere2);
		
		coursDao.attribuerPromotion(cours1, promo1);
		coursDao.attribuerPromotion(cours2, promo2);
		
		
		
		

	}// end main

}// end class
