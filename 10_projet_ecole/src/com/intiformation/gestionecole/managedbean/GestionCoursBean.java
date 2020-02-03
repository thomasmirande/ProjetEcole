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
	
	public void modifierCours(ActionEvent event) {
		
	}// end modifierCours
	
	/**
	 * Méthode invoquée au clic sur le bouton 'ajouter Cours' de cours.xhtml pour préparer (instancier)
	 * un nouvel objet cours qui va contenir les infos du nouveau cours récupérés de ajoutCours.xhtml
	 */
	public void initialiserCours() {
		// 1. instanciation d'un nouvel objet cours 
		Cours coursAdd = new Cours();
		
		//2. affectation de l'objet à l'a propriété cours du ManagedBean
		setCours(coursAdd);
	}// end initialiserCours
	
	/**
	 * Méthode invoquée au clic du boutn 'ajouter' dans ajoutCours.xhtml
	 */
	public void ajouterCours(ActionEvent event) {
		coursDao.add(cours);	
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

	public Collection<Cours> getListeCours() {
		return listeCours;
	}

	public void setListeCours(Collection<Cours> listeCours) {
		this.listeCours = listeCours;
	}
	
	

	
}// end class
