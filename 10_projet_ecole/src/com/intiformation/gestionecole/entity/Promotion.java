package com.intiformation.gestionecole.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("Promotion")
public class Promotion implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPromotion;
	
	private String libelle;
	
	
	/**
	 * Association : 
	 * -> un cours est donné à une promotion
	 * -> une promotion peut avoir 0 ou n cours
	 * => relation One Promotion To Many Cours
	 * 
	 * -> Cours = coté * = coté porteur de la FK
	 */
	@OneToMany(mappedBy="promotion", targetEntity=Cours.class, cascade=CascadeType.ALL)
	private List<Cours> listeCours;
	
	/**
	 * Relation Many Promotion To Many Etudiant
	 * 
	 * Promotion = coté maitre 
	 * 	-> nom de la table de jointure
	 *  -> nom des FK
	 */
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="promotion_assoc_etudiant", joinColumns=@JoinColumn(name="PROMOTION_ID"), inverseJoinColumns=@JoinColumn(name="ETUDIANT_ID"))
	private List<Etudiant> listEtudiant;
	
	/**
	 * One Promotion to Many Enseigne
	 */
	@OneToMany(mappedBy="promotion", targetEntity=Enseigne.class, cascade=CascadeType.ALL)
	private List<Enseigne> listeEnseigne;
	

	/**
	 * 
	 */
	public Promotion() {
		
	}

	/**
	 * @param libelle
	 */
	public Promotion(String libelle) {
		super();
		this.libelle = libelle;
	}

	/**
	 * @param idPromotion
	 * @param libelle
	 */
	public Promotion(int idPromotion, String libelle) {
		super();
		this.idPromotion = idPromotion;
		this.libelle = libelle;
	}

	/**
	 * @return the idPromotion
	 */
	public int getIdPromotion() {
		return idPromotion;
	}

	/**
	 * @param idPromotion the idPromotion to set
	 */
	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
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
	 * @return the listeCours
	 */
	public List<Cours> getListeCours() {
		return listeCours;
	}

	/**
	 * @param listeCours the listeCours to set
	 */
	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}
	
	

	public List<Etudiant> getListEtudiant() {
		return listEtudiant;
	}

	public void setListEtudiant(List<Etudiant> listEtudiant) {
		this.listEtudiant = listEtudiant;
	}
	
	
	

	
	public List<Enseigne> getListeEnseigne() {
		return listeEnseigne;
	}

	public void setListeEnseigne(List<Enseigne> listeEnseigne) {
		this.listeEnseigne = listeEnseigne;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Promotion [idPromotion=" + idPromotion + ", libelle=" + libelle + "]";
	}

}// end class
