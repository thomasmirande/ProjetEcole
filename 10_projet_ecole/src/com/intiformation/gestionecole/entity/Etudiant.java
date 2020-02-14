package com.intiformation.gestionecole.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="etudiant")
@PrimaryKeyJoinColumn(name = "PERSONNE_ID", referencedColumnName = "identifiant")
@DiscriminatorValue("Etudiant")
public class Etudiant extends Personne implements Serializable {
	/*-------------------Props en private-----------------------------------*/

	private boolean photo;
	private String dateDeNaissance;

	/*------------------------------------------------------*/
	/*-----------------------ASSOCIATION--------------------*/
	/*------------------------------------------------------*/
	
	/**
	 * Relation Many Etudiant to Many Cours
	 */
	@ManyToMany(mappedBy="listeEtudiants")
	private List<Cours> listeCours;
	
	
	/**
	 * Relation One Etudiant Many EtudiantCour
	 * thomas
	 */
	@OneToMany(mappedBy="etudiant", targetEntity=EtudiantCours.class, cascade=CascadeType.ALL)
	private List<EtudiantCours> listeEtudiantCours;

	/**
	 * Relation Many Etudiant To Many Promotion
	 */
	@ManyToMany(mappedBy = "listEtudiant")
	private List<Promotion> listePromos;

	/*-------------------Ctors au mini un vide------------------------------*/

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(int identifiant, String motDePasse, String nom, String prenom, String email, boolean photo,
			String dateDeNaissance) {
		super(identifiant, motDePasse, nom, prenom, email);
		this.setIdentifiant(identifiant);
		this.setMotDePasse(motDePasse);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
	}

	public Etudiant(String motDePasse, String nom, String prenom, String email, boolean photo, String dateDeNaissance) {
		super(motDePasse, nom, prenom, email);
		this.setMotDePasse(motDePasse);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
	}
	
	public Etudiant(String motDePasse, String nom, String prenom, String email, boolean photo, String dateDeNaissance, Adresse adresse) {
		super(motDePasse, nom, prenom, email, adresse);
		this.setMotDePasse(motDePasse);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
		this.setAdresse(adresse);
	}

	/*-------------------Getters & Setter-----------------------------------*/

	public boolean isPhoto() {
		return photo;
	}

	public void setPhoto(boolean photo) {
		this.photo = photo;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	//
	// public List<EtudiantCours> getListeEtudiantCours() {
	// return listeEtudiantCours;
	// }
	//
	//
	// public void setListeEtudiantCours(List<EtudiantCours> listeEtudiantCours) {
	// this.listeEtudiantCours = listeEtudiantCours;
	// }

	public List<Promotion> getListePromo() {
		return listePromos;
	}

	public void setListePromo(List<Promotion> listePromo) {
		this.listePromos = listePromos;
	}

	public List<Cours> getListeCours() {
		return listeCours;
	}

	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}

	

	public List<EtudiantCours> getListeEtudiantCours() {
		return listeEtudiantCours;
	}

	public void setListeEtudiantCours(List<EtudiantCours> listeEtudiantCours) {
		this.listeEtudiantCours = listeEtudiantCours;
	}

	public List<Promotion> getListePromos() {
		return listePromos;
	}

	public void setListePromos(List<Promotion> listePromos) {
		this.listePromos = listePromos;
	}

}
