package com.intiformation.gestionecole.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Etudiant implements Serializable{
	/*-------------------Props en private-----------------------------------*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String email;
	private boolean photo;
	private String dateDeNaissance;
	
	/*------------------------------------------------------*/
	/*-----------------------ASSOCIATION--------------------*/
	/*------------------------------------------------------*/
	
	@OneToMany(mappedBy="etudiant2", targetEntity=EtudiantCours.class, cascade=CascadeType.ALL)
	private List<EtudiantCours> listeEtudiantCours;
	
	
	/**
	 * Relation Many Etudiant To Many Promotion
	 */
	@ManyToMany(mappedBy="listEtudiant")
	private List<Promotion> listePromo;
	
	
	
	/*-------------------Ctors au mini un vide------------------------------*/
	public Etudiant(int identifiant, String motDePasse, String nom, String prenom, String email, boolean photo,
			String dateDeNaissance) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
	}//Ctor Full


	public Etudiant(String motDePasse, String nom, String prenom, String email, boolean photo, String dateDeNaissance) {
		super();
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
	}//Ctor Full Without


	public Etudiant() {
		super();
	}//Ctor Vide



	/*-------------------Getters & Setter-----------------------------------*/
	

	public int getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


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
	
	


	


	public List<EtudiantCours> getListeEtudiantCours() {
		return listeEtudiantCours;
	}


	public void setListeEtudiantCours(List<EtudiantCours> listeEtudiantCours) {
		this.listeEtudiantCours = listeEtudiantCours;
	}


	public List<Promotion> getListePromo() {
		return listePromo;
	}


	public void setListePromo(List<Promotion> listePromo) {
		this.listePromo = listePromo;
	}


	@Override
	public String toString() {
		return "Etudiant [identifiant=" + identifiant + ", motDePasse=" + motDePasse + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", photo=" + photo + ", dateDeNaissance=" + dateDeNaissance + "]";
	}//end TooString

	
	
}
