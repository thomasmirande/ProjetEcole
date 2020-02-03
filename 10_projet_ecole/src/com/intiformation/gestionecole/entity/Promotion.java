package com.intiformation.gestionecole.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Promotion implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPromotion;
	
	private String libelle;
	
	
	/**
	 * Association : 
	 * -> un cours est donn� � une promotion
	 * -> une promotion peut avoir 0 ou n cours
	 * => relation One Promotion To Many Cours
	 * 
	 * -> Cours = cot� * = cot� porteur de la FK
	 */
	@OneToMany(mappedBy="promotion", targetEntity=Cours.class, cascade=CascadeType.ALL)
	private List<Cours> listeCours;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Promotion [idPromotion=" + idPromotion + ", libelle=" + libelle + "]";
	}

}// end class
