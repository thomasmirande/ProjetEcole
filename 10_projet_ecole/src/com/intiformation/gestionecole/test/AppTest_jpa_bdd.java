package com.intiformation.gestionecole.test;

import com.intiformation.gestionecole.dao.AdministrateurDaoImpl;
import com.intiformation.gestionecole.dao.CoursDao;
import com.intiformation.gestionecole.dao.EnseignantDaoImpl;
import com.intiformation.gestionecole.dao.EtudiantDaoImpl;
import com.intiformation.gestionecole.dao.MatiereDao;
import com.intiformation.gestionecole.dao.PromotionDao;
import com.intiformation.gestionecole.entity.Administrateur;
import com.intiformation.gestionecole.entity.Cours;
import com.intiformation.gestionecole.entity.Enseignant;
import com.intiformation.gestionecole.entity.Etudiant;
import com.intiformation.gestionecole.entity.Matiere;
import com.intiformation.gestionecole.entity.Promotion;

public class AppTest_jpa_bdd {

	public static void main(String[] args) {
		
	
		
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
		
		
		coursDao.attribuerMatiere(cours1, matiere1);
		coursDao.attribuerMatiere(cours2, matiere2);
		
		
		
		
		Etudiant etudiant1 = new Etudiant("secret", "jean","david","a@mail.com", true, "ouais");
		Etudiant etudiant2 = new Etudiant("mdpE", "michel", "cymes", "mic", true, "");
		EtudiantDaoImpl etudiantDao = new EtudiantDaoImpl();
		etudiantDao.add(etudiant1);
		etudiantDao.add(etudiant2);
		
		Administrateur admin1= new Administrateur("admin1", "sonnom", "sonprenom", "sonmail");
		
		AdministrateurDaoImpl administrateurDao= new AdministrateurDaoImpl();
		administrateurDao.add(admin1);
		
		Enseignant enseignant1=new Enseignant("secret", "younes","mezine","c@mail.com");
		
		Enseignant enseignant2 = new Enseignant("456", "mélanie", "labiche", "mel");
		
		Administrateur admin2 = new Administrateur("mdpA", "jeanne", "jeanne", "jea");
		
		administrateurDao.add(admin2);
		
		
		
		EnseignantDaoImpl enseignantDao = new EnseignantDaoImpl();
		enseignantDao.add(enseignant1);
		enseignantDao.add(enseignant2);
		
		promoDao.add(promo1);
		promoDao.add(promo2);
		coursDao.attribuerPromotion(cours1, promo1);
		coursDao.attribuerPromotion(cours2, promo2);
		

	}// end main

}// end class
