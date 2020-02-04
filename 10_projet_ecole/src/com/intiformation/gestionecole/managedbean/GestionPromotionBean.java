package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.intiformation.gestionecole.dao.PromotionDao;
import com.intiformation.gestionecole.entity.Matiere;
import com.intiformation.gestionecole.entity.Promotion;
@ManagedBean(name="gestionPromotionBean")
@SessionScoped
public class GestionPromotionBean implements Serializable{
	
	private Collection<Promotion> listePromo;
	private PromotionDao promoDao;
	private Promotion promotion;
	
	/**
	 * Ctor vide
	 */
	public GestionPromotionBean() {
		promoDao = new PromotionDao();
	}
	
	// Méthodes
	/**
	 * Recup de la liste des promo dans la bdd via la dao
	 * @return
	 */
	public Collection<Promotion> findAllPromo(){
		listePromo = promoDao.getAll();
		return listePromo;
	}// end findAll
	
	public void supprimerPromo(ActionEvent event) {
		
		UIParameter component = (UIParameter) event.getComponent().findComponent("deleteId");
		
		int promoId = (int) component.getValue();

		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			promoDao.delete(promoId);
			FacesMessage messageDelete = new FacesMessage("La promotion a été supprimée avec succès");
			
			context.addMessage(null, messageDelete);
			
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage("Echec de la suppression"));

		}
		
	}
	
	public void initialiserPromo(ActionEvent event) {
		Promotion promoInit = new Promotion();
		setPromotion(promoInit);
	}
	
	public void ajouterPromo(ActionEvent event) {
		promoDao.add(promotion);
	}
	
	// Getter / Setter

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
	
	
	

}// end class
