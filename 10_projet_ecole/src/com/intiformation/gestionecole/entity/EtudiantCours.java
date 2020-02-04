package com.intiformation.gestionecole.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
//public class EtudiantCours implements Serializable {
	/*-------------------Props en private-----------------------------------*/
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int idEtudiantCours;
//	private int absence;
//	private String motif;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "COURS_ID", referencedColumnName = "idCours")
//	private Cours cours2;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "ETUDIANT_ID", referencedColumnName = "identifiant")
//	private Etudiant etudiant2;
//	
	/*------------------------------------------------------*/
	/*-----------------------ASSOCIATION--------------------*/
	/*------------------------------------------------------*/
	
	
	
	/*-------------------Ctors au mini un vide------------------------------*/
	

//
//	public EtudiantCours() {
//		super();
//	}// Ctor vide
//
//
//	
	


//	public EtudiantCours(int idEtudiantCours, int absence, String motif, Cours cours2, Etudiant etudiant2) {
//		super();
//		this.idEtudiantCours = idEtudiantCours;
//		this.absence = absence;
//		this.motif = motif;
//		this.cours2 = cours2;
//		this.etudiant2 = etudiant2;
//	}//ctor full
//	
//
//
//
//
//
//
//	public EtudiantCours(int absence, String motif, Cours cours2, Etudiant etudiant2) {
//		super();
//		this.absence = absence;
//		this.motif = motif;
//		this.cours2 = cours2;
//		this.etudiant2 = etudiant2;
//	}//without id
//
//
//
//
//
//
//	public EtudiantCours(int absence, String motif) {
//		super();
//		this.absence = absence;
//		this.motif = motif;
//	}
//
//
//
//
//
//
//	/*-------------------Getters & Setter-----------------------------------*/
//	public int getAbsence() {
//		return absence;
//	}
//
//
//	public void setAbsence(int absence) {
//		this.absence = absence;
//	}
//
//
//	public String getMotif() {
//		return motif;
//	}
//
//
//	public void setMotif(String motif) {
//		this.motif = motif;
//	}
//
//
//	public int getIdEtudiantCours() {
//		return idEtudiantCours;
//	}
//
//
//	public void setIdEtudiantCours(int idEtudiantCours) {
//		this.idEtudiantCours = idEtudiantCours;
//	}
//
//
//	public Cours getCours2() {
//		return cours2;
//	}
//
//
//	public void setCours2(Cours cours2) {
//		this.cours2 = cours2;
//	}
//
//
//	public Etudiant getEtudiant2() {
//		return etudiant2;
//	}
//
//
//	public void setEtudiant2(Etudiant etudiant2) {
//		this.etudiant2 = etudiant2;
//	}
//
//
//	
//}
