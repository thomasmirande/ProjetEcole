package com.intiformation.gestionecole.managedbean;

public class GestionEtudiantBean {
	
	/*-------------------Props en private-----------------------------------*/
	private int identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String email;
	private boolean photo;
	private String dateDeNaissance;
	/*-------------------Ctors au mini un vide------------------------------*/
	public GestionEtudiantBean(int identifiant, String motDePasse, String nom, String prenom, String email,
			boolean photo, String dateDeNaissance) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
	}//Ctor full
	public GestionEtudiantBean(String motDePasse, String nom, String prenom, String email, boolean photo,
			String dateDeNaissance) {
		super();
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
	}//Ctor Full without id
	public GestionEtudiantBean() {
		super();
	}//Ctor vide
	/*-------------------Méthodes-------------------------------------------*/
	
	
	
	
	
	/*-------------------Guetter/Setter-------------------------------------------*/
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
	
	
}
