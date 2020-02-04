package com.intiformation.gestionecole.dao;

import com.intiformation.gestionecole.entity.Personne;

public interface IPersonneDao extends IGestion<Personne>{
	
	public boolean isExist(String login, String pMotDePasse);

}
