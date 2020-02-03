package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.intiformation.gestionecole.dao.MatiereDao;
import com.intiformation.gestionecole.entity.Matiere;
@ManagedBean(name="gestionMatiereBean")
@SessionScoped
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
		
		
		public void initialiserMatiere(ActionEvent event) {
			Matiere matiereInit = new Matiere();
			setMatiere(matiereInit);
		}
		
		public void ajouterMatiere(ActionEvent event) {
			matiereDao.add(matiere);
		}
		
		
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
			
		}// end supprimerMatiere

	
		// Getter / Setter

		public Matiere getMatiere() {
			return matiere;
		}

		public void setMatiere(Matiere matiere) {
			this.matiere = matiere;
		}

		public Collection<Matiere> getListeMatiere() {
			return listeMatiere;
		}

		public void setListeMatiere(Collection<Matiere> listeMatiere) {
			this.listeMatiere = listeMatiere;
		}
		

}// end class
