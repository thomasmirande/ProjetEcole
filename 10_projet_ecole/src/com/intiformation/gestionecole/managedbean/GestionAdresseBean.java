package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.intiformation.gestionecole.dao.AdministrateurDaoImpl;
import com.intiformation.gestionecole.dao.AdresseDao;
import com.intiformation.gestionecole.entity.Administrateur;
import com.intiformation.gestionecole.entity.Adresse;
@ManagedBean(name="gestionAdresseBean")
@SessionScoped
public class GestionAdresseBean implements Serializable{
	
	// Propriétés 
	private Collection<Adresse> listeAdresse;
	
	private AdresseDao adresseDao;
	
	private Adresse adresse;
	
	private AdministrateurDaoImpl adminDao;
	
	private Administrateur admin;

	/**
	 * Ctor vide
	 */
	public GestionAdresseBean() {
		adresseDao = new AdresseDao();
	}

	
	
	// Méthodes
	
	/**
	 * Méthode invoquée au clic du bouton 'ajouter' dans ajoutAdmin.xhtml
	 * @param event
	 */
	public void attribuerAdresse(ActionEvent event) {
		
		
	}
	
	// Getter / Setter
	
	public Collection<Adresse> getListeAdresse() {
		return listeAdresse;
	}

	public void setListeAdresse(Collection<Adresse> listeAdresse) {
		this.listeAdresse = listeAdresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}// end class
