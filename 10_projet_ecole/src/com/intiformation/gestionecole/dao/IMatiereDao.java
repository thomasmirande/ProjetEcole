package com.intiformation.gestionecole.dao;

import com.intiformation.gestionecole.entity.Cours;
import com.intiformation.gestionecole.entity.Matiere;

public interface IMatiereDao extends IGestion<Matiere>{
	
	public void attribuerCours(Matiere pMatiere, Cours pCours);

}// end class
