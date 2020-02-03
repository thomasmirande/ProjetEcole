package com.intiformation.gestionecole.managedbean;

public class GestionAdministrateurBean {
	/*-------------------Props en private-----------------------------------*/
	private int identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String email;
	
	
	/*-------------------Ctors au mini un vide------------------------------*/
	public GestionAdministrateurBean(int identifiant, String motDePasse, String nom, String prenom, String email) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}//Ctor Full


	public GestionAdministrateurBean(String motDePasse, String nom, String prenom, String email) {
		super();
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}//endCtor id


	public GestionAdministrateurBean() {
		super();
	}//end ctor vide
	/*-------------------Méthodes-------------------------------------------*/
	/*-------Getters & Setter-----------------------------------*/


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
	
}
