package com.intiformation.gestionecole.dao;

import com.intiformation.gestionecole.entity.Administrateur;

public interface IAdministrateurDao extends IGestion<Administrateur> {
	
	public boolean isExist(String pLogin, String pMotDePasse);

}
