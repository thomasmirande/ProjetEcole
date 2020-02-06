package com.intiformation.gestionecole.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "PERSONNE_ID", referencedColumnName = "identifiant")
@DiscriminatorValue("Administrateur")
public class Administrateur extends Personne implements Serializable {

	/*-------------------Props en private-----------------------------------*/
	/*-------------------Ctors au mini un vide------------------------------*/
	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(int identifiant, String motDePasse, String nom, String prenom, String email) {
		super(identifiant, motDePasse, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String motDePasse, String nom, String prenom, String email) {
		super(motDePasse, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}
	/*-------------------Getters & Setter-----------------------------------*/

}
