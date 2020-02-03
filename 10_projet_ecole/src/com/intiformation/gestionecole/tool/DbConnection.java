package com.intiformation.gestionecole.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	//infos pour
		//info pour la co a la BDD
			private static final String DB_URL= "jdbc:mysql://localhost:3306/db_cours_jsf";
			private static final String DB_USER= "root";
			private static final String DB_PASSWORD = "root";
			
			private static final String JDBC_DRIVER_CLASS = "com.mysql.jdbc.Driver";
			
			//objet Connection à retourner
			private static Connection connexion ;
			
			/**
			 * retourne une objet  co vers la bdd
			 * @return
			 */
			public static Connection getInstance(){
				if (connexion == null) {
					//1.la connexion n'est pas encore crée => on la crée
					//1.1 chargement du driver jdbc, instansiation du pilote plus enregistrement du pilote vers le driver manager
					try {
						Class.forName(JDBC_DRIVER_CLASS);
						
					//1.2 recup de la co a partir du driver manager	
					connexion = 
							DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
					 
					} catch (ClassNotFoundException | SQLException e) {
						
						e.printStackTrace();
					}// end catch
				
				}// end if
					//la connexion est déjà crée => on la retourne
				return connexion;
			}// end méthode getInstance
}
