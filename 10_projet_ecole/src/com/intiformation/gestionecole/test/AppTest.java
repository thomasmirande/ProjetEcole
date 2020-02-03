package com.intiformation.gestionecole.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.intiformation.gestionecole.dao.AideDao;
import com.intiformation.gestionecole.entity.Aide;

public class AppTest {

	
		public static void main(String[] args) {
			
			Aide aide1 = new Aide(2, "contenu de l'aide 1");
			
			Aide aide2 = new Aide(4, "conteneu de la page 2");
			
			AideDao aideDao = new AideDao();
			
			
			
			List<Aide> liste = aideDao.getAll();
			
			System.out.println("-----------------------");
			for (Aide a : liste) {
				System.out.println("\t > " + a);
			}

		}// end main

}//end class
