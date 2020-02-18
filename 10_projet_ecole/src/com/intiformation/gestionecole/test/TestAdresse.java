package com.intiformation.gestionecole.test;

import com.intiformation.gestionecole.dao.AdministrateurDaoImpl;
import com.intiformation.gestionecole.dao.AdresseDao;
import com.intiformation.gestionecole.dao.EnseignantDaoImpl;
import com.intiformation.gestionecole.dao.EtudiantDaoImpl;
import com.intiformation.gestionecole.entity.Administrateur;
import com.intiformation.gestionecole.entity.Adresse;
import com.intiformation.gestionecole.entity.Enseignant;

public class TestAdresse {

	public static void main(String[] args) {
		
		AdresseDao adresseDao = new AdresseDao();
		EtudiantDaoImpl etudiantDao = new EtudiantDaoImpl();
		AdministrateurDaoImpl administrateurDao= new AdministrateurDaoImpl();
		EnseignantDaoImpl enseignantDao = new EnseignantDaoImpl();
		
		Adresse adresse1 = new Adresse("40 rue de la paix", "33000", "Bordeaux");
		
		Administrateur admin = new Administrateur("mdpEmilie", "fleur", "Emilie", "emilie@mail");
		
		administrateurDao.add(admin);
		adresseDao.add(adresse1);
		
		adresseDao.attribuerAdresse(admin, adresse1);
		
		

	}

}
