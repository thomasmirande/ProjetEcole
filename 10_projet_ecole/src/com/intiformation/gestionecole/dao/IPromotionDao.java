package com.intiformation.gestionecole.dao;

import com.intiformation.gestionecole.entity.Cours;
import com.intiformation.gestionecole.entity.Promotion;

public interface IPromotionDao extends IGestion<Promotion>{
	
	public void attribuerCours(Promotion pPromotion, Cours pCours);

}
