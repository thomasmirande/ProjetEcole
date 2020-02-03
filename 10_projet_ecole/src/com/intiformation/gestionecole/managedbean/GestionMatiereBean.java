package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.intiformation.gestionecole.dao.MatiereDao;
import com.intiformation.gestionecole.entity.Matiere;

public class GestionMatiereBean implements Serializable{
	
	// Prorpiétés 
		// Liste des matières de la bdd pour alimenter la datatable de la page xhtml
		private Collection<Matiere> listeMatiere;
			
		private MatiereDao matiereDao;
				
		private Matiere matiere;

		// Ctor vide
		/**
		 * 
		 */
		public GestionMatiereBean() {
			matiereDao = new MatiereDao();
		}
		
		public Collection<Matiere> findAllMatiereBdd(){
			listeMatiere = matiereDao.getAll();
			return listeMatiere;
				
			}// end method
		
		/**
		 * Méthode invoquée au cic sur le bouton supprimer de la dataTable de matiere.xhtml
		 * @param event
		 */
		public void supprimerMatiere(ActionEvent event) {
			
			UIParameter component = (UIParameter) event.getComponent().findComponent("deleteId");
			
			// recup de la valeur du param (id du cours)
			int matiereId = (int) component.getValue();
			
			FacesContext context = FacesContext.getCurrentInstance();
			
			try {
				matiereDao.delete(matiereId);
				FacesMessage messageDelete = new FacesMessage("La matière a été supprimée avec succès");
				
				context.addMessage(null, messageDelete);
				
			} catch (Exception e) {
				e.printStackTrace();
				context.addMessage(null, new FacesMessage("Echec de la suppression"));

			}
			
		}// end supprimerCours
		
		

}// end class
