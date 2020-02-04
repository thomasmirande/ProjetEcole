package com.intiformation.gestionecole.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "PERSONNE_ID", referencedColumnName = "identifiant")
@DiscriminatorValue("Ens")
public class Enseignant extends Personne implements Serializable {

	/*-------------------Props en private-----------------------------------*/

	/*-------------------Ctors au mini un vide------------------------------*/
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enseignant(int identifiant, String motDePasse, String nom, String prenom, String email) {
		super(identifiant, motDePasse, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}

	public Enseignant(String motDePasse, String nom, String prenom, String email) {
		super(motDePasse, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}
	
	public Enseignant(String motDePasse, String email) {
		super(motDePasse, email);
	}

	/*-------------------Getters & Setter-----------------------------------*/

}
