package com.intiformation.gestionecole.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Adresse implements Serializable{
	
	// Propriétés 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdresse;
	
	private String rue;	
	private String codePostal;	
	private String ville;
	
	// Ctors 
	
	public Adresse() {
		
	}
	
	

	/**
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}



	/**
	 * @param idAdresse
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(int idAdresse, String rue, String codePostal, String ville) {
		super();
		this.idAdresse = idAdresse;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	// Getter/Setter

	/**
	 * @return the idAdresse
	 */
	public int getIdAdresse() {
		return idAdresse;
	}



	/**
	 * @param idAdresse the idAdresse to set
	 */
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}



	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}



	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}



	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}



	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}



	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}



	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}

}// end class
