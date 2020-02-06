package com.intiformation.gestionecole.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="typePersonne", discriminatorType=DiscriminatorType.STRING)
public class Personne implements Serializable {

	/*-------------------Props en private-----------------------------------*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String email;
	
	
	/**
	 * Association
	 * 
	 * Relation bidirectionnelle
	 * Une adresse est possédée par une personne 
	 * Une personne possède 0 ou 1 adresse 
	 * 
	 * -> relation One Personne To One Adresse
	 */
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ADRESSE_ID", referencedColumnName="idAdresse")
	private Adresse adresse;
	
	
	/*-------------------Ctors au mini un vide------------------------------*/
	public Personne(String motDePasse, String nom, String prenom, String email) {
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}// Ctor Full without ID
	public Personne(int identifiant, String motDePasse, String nom, String prenom, String email) {
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}// Ctor Full
	public Personne() {
		super();
	}//Ctor vide	
	
	
	public Personne(String motDePasse, String email) {
		this.motDePasse = motDePasse;
		this.email = email;
	}
	
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
	


	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "Personne [identifiant=" + identifiant + ", motDePasse=" + motDePasse + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + "]";
	}//end Too string
	
	
	
	
	
	
}
