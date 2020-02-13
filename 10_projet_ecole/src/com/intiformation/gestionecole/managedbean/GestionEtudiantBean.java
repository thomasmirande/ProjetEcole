package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.intiformation.gestionecole.dao.AdresseDao;
import com.intiformation.gestionecole.dao.EtudiantDaoImpl;
import com.intiformation.gestionecole.entity.Administrateur;
import com.intiformation.gestionecole.entity.Adresse;
import com.intiformation.gestionecole.entity.Etudiant;
@ManagedBean(name="gestionEtudiantBean")
@SessionScoped
public class GestionEtudiantBean implements Serializable{
	
	/*-------------------Props en private-----------------------------------*/
	private Collection<Etudiant> listeEtudiant;
	
	private EtudiantDaoImpl etudiantDao;
	
	private Etudiant etudiant;
	
	private AdresseDao adresseDao;
	
	private Adresse adresse;
	
	
	/*-------------------Ctors au mini un vide------------------------------*/

	public GestionEtudiantBean() {
		etudiantDao = new EtudiantDaoImpl();
	}//Ctor vide


	
	/*-------------------Méthodes-------------------------------------------*/
	
	public Collection<Etudiant> findAllEtudiantBdd(){
		listeEtudiant = etudiantDao.getAll();
		return listeEtudiant;
	}
	
	public void supprimerEtudiant(ActionEvent event) {
		
		UIParameter component = (UIParameter) event.getComponent().findComponent("deleteId");
		
		// recup de la valeur du param (id du cours)
		int etuId = (int) component.getValue();
		
		// suppression du cours dans la bdd via la dao
		// envoi d'un message vers la vue avec la classe FacesMessage
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			etudiantDao.delete(etuId);
			FacesMessage messageDelete = new FacesMessage("L'étudiant a été supprimé avec succès");
			
			context.addMessage(null, messageDelete);
			
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage("Echec de la suppression"));

		}
	
	}
	
	public void initialiserEtudiant(ActionEvent event) {
		Etudiant etudiantAjout = new Etudiant();
		setEtudiant(etudiantAjout);
	}
	
	public void ajouterEtudiant(ActionEvent event) {
		etudiantDao.add(etudiant);
	}
	
	public void chargerInfoEtudiant(ActionEvent event) {
		UIParameter component = (UIParameter) event.getComponent().findComponent("modifId");
		int idModif = (int) component.getValue();
		Etudiant etudiantModif = etudiantDao.getById(idModif);
		setEtudiant(etudiantModif);
	}
	
	public void modifierEtudiant(ActionEvent event) {
		etudiantDao.update(etudiant);
		
	}
	
	/*-------------------Guetter/Setter-------------------------------------------*/
	public Collection<Etudiant> getListeEtudiant() {
		return listeEtudiant;
	}


	public void setListeEtudiant(Collection<Etudiant> listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}


	public EtudiantDaoImpl getEtudiantDao() {
		return etudiantDao;
	}


	public void setEtudiantDao(EtudiantDaoImpl etudiantDao) {
		this.etudiantDao = etudiantDao;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public AdresseDao getAdresseDao() {
		return adresseDao;
	}


	public void setAdresseDao(AdresseDao adresseDao) {
		this.adresseDao = adresseDao;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}
