package com.intiformation.gestionecole.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.intiformation.gestionecole.entity.Cours;
import com.intiformation.gestionecole.entity.Etudiant;

public class AppTestManyToMany {
	public static void main(String[] args) {
		//1. création de sessions
		
		Cours sessionArchitecte= new Cours("Architecte Logiciel", "03/02/2020", "1H", "cours3");
		Cours sessionIngWeb= new Cours("Ingénieur de devéloppement web", "03/02/2020", "1H", "cours5");
		
		//2. création d'étudiant
		
		Etudiant etudiant1 = new Etudiant("mdp","dupond","Jaque","J.d@mail.com",true, "28/12/1995");
		Etudiant etudiant2 = new Etudiant("mdp","Jean","Neymar","J.n@mail.com",true, "25/02/1994");

		//3 collection de liste d'étudiants
		
		List<Etudiant> listEtudiants1 = new ArrayList<>();
		listEtudiants1.add(etudiant1);
		listEtudiants1.add(etudiant2);
		
		List<Etudiant> listEtudiants2 = new ArrayList<>();
		listEtudiants2.add(etudiant1);
		
		
		//4.ajout de la liste d'étudiant1 à la session1
		
		sessionArchitecte.setListeEtudiants(listEtudiants1);
		
		//5.ajout de la liste d'étudiant1 à la session2
		
		sessionIngWeb.setListeEtudiants(listEtudiants2);
		
		//6.Gestion du manager
		//5. 
				EntityManager em = Persistence.createEntityManagerFactory("02_gestion_association_jpa").createEntityManager();
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.persist(sessionArchitecte);
				em.persist(sessionIngWeb);
				tx.commit();
				em.close();
	}//end main
}
