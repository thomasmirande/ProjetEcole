package com.intiformation.gestionecole.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="enseigne")
public class Enseigne {
	
	//Propriétés
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEnseigne;
	
	// Association
	/**
	 * Relation Many Enseigne To Many Promotion
	 * 
	 * Relation Many Enseigne To Many Matiere
	 * 
	 * Relation Many Enseigne To Many Enseignant
	 */
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="enseigne_promo_matiere", joinColumns=@JoinColumn(name="ENSEIGNE_ID"), inverseJoinColumns=@JoinColumn(name="PROMOTION_ID"))
	private List<Promotion> listePromotion;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="enseigne_promo_matiere", joinColumns=@JoinColumn(name="ENSEIGNE_ID"), inverseJoinColumns=@JoinColumn(name="MATIERE_ID"))
	private List<Matiere> listeMatiere;

	
	// Ctor
	public Enseigne() {
	}


	public int getIdEnseigne() {
		return idEnseigne;
	}


	public void setIdEnseigne(int idEnseigne) {
		this.idEnseigne = idEnseigne;
	}
	
	

}// end class
