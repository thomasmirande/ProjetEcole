package com.intiformation.gestionecole.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EtudiantCours implements Serializable {
	/*-------------------Props en private-----------------------------------*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEtudiantCours;
	private int absence;
	private String motif;
	
	/*------------------------------------------------------*/
	/*-----------------------ASSOCIATION--------------------*/
	/*------------------------------------------------------*/
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "COURS_ID", referencedColumnName = "idCours")
	private Cours cours;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ETUDIANT_ID", referencedColumnName = "identifiant")
	private Etudiant etudiant;
	
	
	
	
	
	/*-------------------Ctors au mini un vide------------------------------*/
	


	public EtudiantCours() {
		super();
	}// Ctor vide


	
	


	public EtudiantCours(int idEtudiantCours, int absence, String motif, Cours cours2, Etudiant etudiant2) {
		super();
		this.idEtudiantCours = idEtudiantCours;
		this.absence = absence;
		this.motif = motif;
		this.cours = cours;
		this.etudiant = etudiant;
	}//ctor full
	






	public EtudiantCours(int absence, String motif, Cours cours2, Etudiant etudiant2) {
		super();
		this.absence = absence;
		this.motif = motif;
		this.cours = cours;
		this.etudiant = etudiant;
	}//without id






	public EtudiantCours(int absence, String motif) {
		super();
		this.absence = absence;
		this.motif = motif;
	}






	/*-------------------Getters & Setter-----------------------------------*/
	public int getAbsence() {
		return absence;
	}


	public void setAbsence(int absence) {
		this.absence = absence;
	}


	public String getMotif() {
		return motif;
	}


	public void setMotif(String motif) {
		this.motif = motif;
	}


	public int getIdEtudiantCours() {
		return idEtudiantCours;
	}


	public void setIdEtudiantCours(int idEtudiantCours) {
		this.idEtudiantCours = idEtudiantCours;
	}






	public Cours getCours() {
		return cours;
	}






	public void setCours(Cours cours) {
		this.cours = cours;
	}






	public Etudiant getEtudiant() {
		return etudiant;
	}






	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	


	
}
