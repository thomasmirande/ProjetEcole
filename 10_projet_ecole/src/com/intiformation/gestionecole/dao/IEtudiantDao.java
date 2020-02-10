package com.intiformation.gestionecole.dao;

import com.intiformation.gestionecole.entity.Etudiant;

public interface IEtudiantDao extends IGestion<Etudiant>{
	
	public boolean isExist(String pLogin, String pMotDePasse);

}
