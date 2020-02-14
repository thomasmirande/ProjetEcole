package com.intiformation.gestionecole.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="enseignant")
@PrimaryKeyJoinColumn(name = "PERSONNE_ID", referencedColumnName = "identifiant")
@DiscriminatorValue("Enseignant")
public class Enseignant extends Personne implements Serializable {

	/*-------------------Props en private-----------------------------------*/
	
	
	
	/*---------------------------------------ASSOCIATION--------------------*/
	@OneToMany(mappedBy="enseignant", targetEntity=Enseigne.class, cascade=CascadeType.ALL)
	private List<Enseigne> listeEnseigne;
	
	/*-------------------Ctors au mini un vide------------------------------*/
	public Enseignant() {
		super();
		
	}

	public Enseignant(int identifiant, String motDePasse, String nom, String prenom, String email) {
		super(identifiant, motDePasse, nom, prenom, email);
		this.setIdentifiant(identifiant);
		this.setMotDePasse(motDePasse);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
	
	}

	public Enseignant(String motDePasse, String nom, String prenom, String email) {
		super(motDePasse, nom, prenom, email);
		this.setMotDePasse(motDePasse);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
	
	}
	
	public Enseignant(String motDePasse, String email) {
		super(motDePasse, email);
		this.setMotDePasse(motDePasse);
		this.setEmail(email);
	}
	
	public Enseignant(String motDePasse, String nom, String prenom, String email, Adresse adresse) {
		super(motDePasse, nom, prenom, email, adresse);
		this.setMotDePasse(motDePasse);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.setAdresse(adresse);
	
	}

	/*-------------------Getters & Setter-----------------------------------*/

}
