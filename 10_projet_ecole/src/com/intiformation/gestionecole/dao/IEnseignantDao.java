package com.intiformation.gestionecole.dao;

import com.intiformation.gestionecole.entity.Enseignant;

public interface IEnseignantDao  extends IGestion<Enseignant>  {
	
	public boolean isExist(String pLogin, String pMotDePasse);

}
