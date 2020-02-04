package com.intiformation.gestionecole.test;

import com.intiformation.gestionecole.dao.AdministrateurDaoImpl;
import com.intiformation.gestionecole.dao.EnseignantDaoImpl;
import com.intiformation.gestionecole.dao.EtudiantDaoImpl;
import com.intiformation.gestionecole.entity.Administrateur;
import com.intiformation.gestionecole.entity.Enseignant;
import com.intiformation.gestionecole.entity.Etudiant;

public class AppTestHeritage {

	public static void main(String[] args) {
		
		Etudiant etudiant1 = new Etudiant("secret", "jean","david","a@mail.com", true, "ouais");
		EtudiantDaoImpl etudiantDao = new EtudiantDaoImpl();
		etudiantDao.add(etudiant1);
		
		Administrateur admin1= new Administrateur("secret", "ivette","cathie","b@mail.com");
		AdministrateurDaoImpl administrateurDao= new AdministrateurDaoImpl();
		administrateurDao.add(admin1);
		
		Enseignant enseignant1=new Enseignant("secret", "younes","mezine","c@mail.com");
		EnseignantDaoImpl enseignantDao = new EnseignantDaoImpl();
		enseignantDao.add(enseignant1);
	}//end main

}//end class
