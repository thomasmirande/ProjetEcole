package com.intiformation.gestionecole.dao;

import com.intiformation.gestionecole.entity.Cours;
import com.intiformation.gestionecole.entity.Matiere;
import com.intiformation.gestionecole.entity.Promotion;

public interface ICoursDao extends IGestion<Cours>{
	
	public void attribuerMatiere(Cours pCours, Matiere pMatiere);
	
	public void attribuerPromotion(Cours pCours, Promotion pPromotion);

}
