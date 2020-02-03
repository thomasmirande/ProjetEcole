package com.intiformation.gestionecole.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EtudiantCours implements Serializable {
	/*-------------------Props en private-----------------------------------*/
	private int absence;
	private String motif;
	private String cours_id;
	private String etudiant_id;
	
	/*------------------------------------------------------*/
	/*-----------------------ASSOCIATION--------------------*/
	/*------------------------------------------------------*/
	@ManyToOne
	@JoinColumn(name="ETUDIANT_ID", referencedColumnName="idEtudiant")
	private Etudiant etudiant;
	
	@ManyToOne
	@JoinColumn(name="COURS_ID", referencedColumnName="idCours")
	private Cours cours;
	
	
	/*-------------------Ctors au mini un vide------------------------------*/
	public EtudiantCours(int absence, String motif, String cours_id, String etudiant_id) {
		super();
		this.absence = absence;
		this.motif = motif;
		this.cours_id = cours_id;
		this.etudiant_id = etudiant_id;
	}//end ctor full


	public EtudiantCours() {
		super();
	}// Ctor vide


	
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


	public String getCours_id() {
		return cours_id;
	}


	public void setCours_id(String cours_id) {
		this.cours_id = cours_id;
	}


	public String getEtudiant_id() {
		return etudiant_id;
	}


	public void setEtudiant_id(String etudiant_id) {
		this.etudiant_id = etudiant_id;
	}
	
}
