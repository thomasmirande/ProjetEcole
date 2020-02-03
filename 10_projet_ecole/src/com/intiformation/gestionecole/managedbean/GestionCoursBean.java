package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.intiformation.gestionecole.dao.CoursDao;
import com.intiformation.gestionecole.entity.Cours;

@ManagedBean(name="gestionCoursBean")
@SessionScoped
public class GestionCoursBean implements Serializable{
	
	// Prorpiétés 
	// Liste des cours de la bdd pour alimenter la datatable de la page xhtml
	private Collection<Cours> listeCours;
		
	// la dao de cours 
	private CoursDao coursDao;
			
	private Cours cours;

	/**
	 * Ctor vide
	 */
	public GestionCoursBean() {
		coursDao = new CoursDao();
	}
	
	// Méthodes 
	/**
	 * Recup de la liste des cours dans la bdd via la dao
	 * @return
	 */
	public Collection<Cours> findAllCoursBdd(){
		listeCours = coursDao.getAll();
		return listeCours;
			
		}// end method
	
	/**
	 * Méthode invoquée au cic sur le bouton supprimer de la dataTable de cours.xhtml
	 * @param event
	 */
	public void supprimerCours(ActionEvent event) {
		
		UIParameter component = (UIParameter) event.getComponent().findComponent("deleteId");
		
		// recup de la valeur du param (id du cours)
		int coursId = (int) component.getValue();
		
		// suppression du cours dans la bdd via la dao
		// envoi d'un message vers la vue avec la classe FacesMessage
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			coursDao.delete(coursId);
			FacesMessage messageDelete = new FacesMessage("Le cours a été supprimé avec succès");
			
			context.addMessage(null, messageDelete);
			
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage("Echec de la suppression"));

		}
		
	}// end supprimerCours
	
	public void modifierCours() {
		
	}// end modifierCours
	
	public void ajouterCours() {
		
	}// end ajouterCours

	
	// Getter / Setter

	/**
	 * @return the cours
	 */
	public Cours getCours() {
		return cours;
	}

	/**
	 * @param cours the cours to set
	 */
	public void setCours(Cours cours) {
		this.cours = cours;
	}

	
}// end class
