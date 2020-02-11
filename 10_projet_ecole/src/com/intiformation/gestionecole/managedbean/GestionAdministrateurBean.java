package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.intiformation.gestionecole.dao.AdministrateurDaoImpl;
import com.intiformation.gestionecole.entity.Administrateur;

@ManagedBean(name="gestionAdminBean")
@SessionScoped
public class GestionAdministrateurBean implements Serializable{
	/*-------------------Props en private-----------------------------------*/
	// Liste des admin de la bdd pour alimenter la datatable de listeAdmin.xhtml
	private Collection<Administrateur> listeAdmin;
	
	// Dao de admin
	private AdministrateurDaoImpl adminDao;
	
	//Entité
	private Administrateur admin;
	
	
	/*-------------------Ctors au mini un vide------------------------------*/
	

	

	public GestionAdministrateurBean() {
		adminDao = new AdministrateurDaoImpl();
	}


	
	
	
	/*-------------------Méthodes-------------------------------------------*/
	
	/**
	 * Recup de la liste des admin dans la bdd
	 * @return
	 */
	public Collection<Administrateur> findAllAdminBdd(){
		listeAdmin = adminDao.getAll();
		return listeAdmin;
	}
	
	public void supprimerAdmin(ActionEvent event) {
		
		UIParameter component = (UIParameter) event.getComponent().findComponent("deleteId");
		
		// recup de la valeur du param (id du cours)
		int adminId = (int) component.getValue();
		
		// suppression du cours dans la bdd via la dao
		// envoi d'un message vers la vue avec la classe FacesMessage
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			adminDao.delete(adminId);
			FacesMessage messageDelete = new FacesMessage("L'administrateur a été supprimé avec succès");
			
			context.addMessage(null, messageDelete);
			
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage("Echec de la suppression"));

		}
		
	}// end supprimerAdmin
	
	/**
	 * Méthode invoquée au clic du bouton 'ajouter dans listeAdmin.xhtml
	 * @param event
	 */
	public void initialiserAdmin(ActionEvent event) {
		Administrateur adminAjout = new Administrateur();
		setAdmin(adminAjout);
	}
	
	public void ajouterAdmin(ActionEvent event) {
		adminDao.add(admin);
	}
	
	
	/*-------Getters & Setter-----------------------------------*/

	public Collection<Administrateur> getListeAdmin() {
		return listeAdmin;
	}


	public void setListeAdmin(Collection<Administrateur> listeAdmin) {
		this.listeAdmin = listeAdmin;
	}


	public Administrateur getAdmin() {
		return admin;
	}


	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}
	
}
