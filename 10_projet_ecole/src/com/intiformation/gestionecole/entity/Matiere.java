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
public class Matiere implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMatiere;
	
	private String libelle;
	
	/**
	 * Association : 
	 * 	-> un cours est porté par 1 matière
	 *  -> une matière peut porter sur 0 ou n cours
	 *  => Relation One Matiere To Many Cours
	 *  
	 *  -> Cours = coté * = coté porteur de la FK (ajout de JoinColumn)
	 * 
	 */
	@OneToMany(mappedBy="matiere", targetEntity=Cours.class, cascade=CascadeType.ALL)
	private List<Cours> listeCours;
	
	

	/**
	 * 
	 */
	public Matiere() {
		
	}

	/**
	 * @param libelle
	 */
	public Matiere(String libelle) {
		super();
		this.libelle = libelle;
	}

	/**
	 * @param idMatiere
	 * @param libelle
	 */
	public Matiere(int idMatiere, String libelle) {
		super();
		this.idMatiere = idMatiere;
		this.libelle = libelle;
	}

	/**
	 * @return the idMatiere
	 */
	public int getIdMatiere() {
		return idMatiere;
	}

	/**
	 * @param idMatiere the idMatiere to set
	 */
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
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
		return "Matiere [idMatiere=" + idMatiere + ", libelle=" + libelle + "]";
	}
	
	
	
	

}// end class
