package com.intiformation.gestionecole.entity;

import java.io.Serializable;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Cours implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCours; 
	
	private String libelle;	
	private String date; 	
	private String duree;	
	private String description;
	
	/**
	 * Association : 
	 * 	-> un cours est porté par 1 matière
	 *  -> une matière peut porter sur 0 ou n cours
	 *  => Relation Many Cours To One Matiere
	 *  
	 *  -> Cours = coté * = coté porteur de la FK (ajout de JoinColumn)
	 * 
	 */
	
	/*------------------------------------------------------*/
	/*-----------------------ASSOCIATION--------------------*/
	/*------------------------------------------------------*/
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Etudiant_cour")
	private List<Etudiant> listeEtudiant;
	
	@ManyToOne
	@JoinColumn(name="MATIERE_ID", referencedColumnName="idMatiere")
	private Matiere matiere;
	
	
	/**
	 * Association : 
	 * -> un cours est donné à une promotion
	 * -> une promotion peut avoir 0 ou n cours
	 * => relation Many Cours To One Promotion
	 * 
	 * -> Cours = coté * = coté porteur de la FK
	 */
	@ManyToOne
	@JoinColumn(name="PROMOTION_ID", referencedColumnName="idPromotion")
	private Promotion promotion;
	
	/**
	 * 
	 */
	public Cours() {
		
	}

	/**
	 * @param libelle
	 * @param date
	 * @param duree
	 * @param description
	 */
	public Cours(String libelle, String date, String duree, String description) {
		super();
		this.libelle = libelle;
		this.date = date;
		this.duree = duree;
		this.description = description;
	}

	/**
	 * @param idCours
	 * @param libelle
	 * @param date
	 * @param duree
	 * @param description
	 */
	public Cours(int idCours, String libelle, String date, String duree, String description) {
		super();
		this.idCours = idCours;
		this.libelle = libelle;
		this.date = date;
		this.duree = duree;
		this.description = description;
	}

	/**
	 * @return the idCours
	 */
	public int getIdCours() {
		return idCours;
	}

	/**
	 * @param idCours the idCours to set
	 */
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the duree
	 */
	public String getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(String duree) {
		this.duree = duree;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

	/**
	 * @return the matiere
	 */
	public Matiere getMatiere() {
		return matiere;
	}

	/**
	 * @param matiere the matiere to set
	 */
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	/**
	 * @return the promotion
	 */
	public Promotion getPromotion() {
		return promotion;
	}

	/**
	 * @param promotion the promotion to set
	 */
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cours [idCours=" + idCours + ", libelle=" + libelle + ", date=" + date + ", duree=" + duree
				+ ", description=" + description + "]";
	}
	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiant = listeEtudiants;
	}// Pour app Test Cours_Etudiants
	
	
	
	
	

}// end class
