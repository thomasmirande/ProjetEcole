package com.intiformation.gestionecole.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.intiformation.gestionecole.dao.CoursDao;
import com.intiformation.gestionecole.dao.EtudiantDaoImpl;
import com.intiformation.gestionecole.entity.Cours;
import com.intiformation.gestionecole.entity.Etudiant;
import com.intiformation.gestionecole.entity.EtudiantCours;

public class AppTestManyToMany {
	public static void main(String[] args) {
		//1.création d'une session de formation
		
		
		Etudiant etudiant1 = new Etudiant("secret", "jean","david","a@mail.com", true, "ouais");
		Cours moduleUML = new Cours("Conception Objet", "13/02/20","1h30","trop bien");
		//2.création de modules de formation
		
		EtudiantCours etcJavaSe = new EtudiantCours(3, "malade","1","1");
		EtudiantCours etccour = new EtudiantCours(1, "malade","2","1");
		
		CoursDao coursdao=new CoursDao();
		EtudiantDaoImpl etudiantsDao = new EtudiantDaoImpl();
		
		coursdao.add(moduleUML);
		
			
			
		
		//3.création de collection de  modules
		List<EtudiantCours> listeModules1= new ArrayList<>();
		listeModules1.add(moduleUML);
		listeModules1.add(moduleJavaSe);
		listeModules1.add(moduleFront);
		
		//4. ajout de la liste des modules session
		sessionJava.setListeModules(listeModules1);
		
		//5. 
		EntityManager em = Persistence.createEntityManagerFactory("10_projet_ecole").createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(sessionJava);
		tx.commit();
		em.close();
	}//end main

}
