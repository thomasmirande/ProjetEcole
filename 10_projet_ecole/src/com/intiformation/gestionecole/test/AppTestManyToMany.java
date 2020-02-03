package com.intiformation.gestionecole.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.intiformation.gestionecole.dao.CoursDao;
import com.intiformation.gestionecole.dao.EtudiantCoursDao;
import com.intiformation.gestionecole.dao.EtudiantDaoImpl;
import com.intiformation.gestionecole.entity.Cours;
import com.intiformation.gestionecole.entity.Etudiant;
import com.intiformation.gestionecole.entity.EtudiantCours;

public class AppTestManyToMany {
	public static void main(String[] args) {
		//1.création d'une session de formation
		
//		
//		Etudiant etudiant1 = new Etudiant("secret", "jean","david","a@mail.com", true, "ouais");
//		Cours moduleUML = new Cours("Conception Objet", "13/02/20","1h30","trop bien");
//		//2.création de modules de formation
//		
//		EtudiantCours etcJavaSe = new EtudiantCours(3, "malade","1","1");
//		EtudiantCours etccour = new EtudiantCours(1, "malade","2","1");
//		
//		etcJavaSe.setEtudiant_id(etudiant1);
//		etccour.setCours_id(moduleUML);
//		
//		List<EtudiantCours> listeEtudiantcours1=new ArrayList<>();
//		listeEtudiantcours1.add(etccour);
//		listeEtudiantcours1.add(etcJavaSe);
//		
//		etudiant1.setListeEtudiantCours(listeEtudiantcours1);
//		
//	
//		
//		//5. 
//		EntityManager em = Persistence.createEntityManagerFactory("10_projet_ecole").createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		em.persist("etccour");
//		em.persist("etcJavaSe");
//		tx.commit();
//		em.close();
		
		Etudiant etudiant1 = new Etudiant("secret", "jean","david","a@mail.com", true, "ouais");
		Cours moduleUML = new Cours("Conception Objet", "13/02/20","1h30","trop bien");
		//2.création de modules de formation
		
//		EtudiantCours etcJavaSe = new EtudiantCours(3, "malade");
//		EtudiantCours etccour = new EtudiantCours(1, "malade");
		
		EtudiantDaoImpl etudiantDao = new EtudiantDaoImpl();
		CoursDao coursDao = new CoursDao();
//		EtudiantCoursDao etudiantCoursDao =new EtudiantCoursDao();
		
		etudiantDao.add(etudiant1);
		coursDao.add(moduleUML);
//		etudiantCoursDao.add(etccour);
//		etudiantCoursDao.add(etcJavaSe);
		
	}//end main

}
