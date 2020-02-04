package com.intiformation.gestionecole.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "PERSONNE_ID", referencedColumnName = "idPersonne")
@DiscriminatorValue("Etudiant")
public class Etudiant extends Personne implements Serializable {
	/*-------------------Props en private-----------------------------------*/

	private boolean photo;
	private String dateDeNaissance;

	/*------------------------------------------------------*/
	/*-----------------------ASSOCIATION--------------------*/
	/*------------------------------------------------------*/

	// @OneToMany(mappedBy="etudiant2", targetEntity=EtudiantCours.class,
	// cascade=CascadeType.ALL)
	// private List<EtudiantCours> listeEtudiantCours;

	/**
	 * Relation Many Etudiant To Many Promotion
	 */
	@ManyToMany(mappedBy = "listEtudiant")
	private List<Promotion> listePromo;

	/*-------------------Ctors au mini un vide------------------------------*/

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(int identifiant, String motDePasse, String nom, String prenom, String email, boolean photo,
			String dateDeNaissance) {
		super(identifiant, motDePasse, nom, prenom, email);
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
	}

	public Etudiant(String motDePasse, String nom, String prenom, String email, boolean photo, String dateDeNaissance) {
		super(motDePasse, nom, prenom, email);
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
	}

	/*-------------------Getters & Setter-----------------------------------*/

	public boolean isPhoto() {
		return photo;
	}

	public void setPhoto(boolean photo) {
		this.photo = photo;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	//
	// public List<EtudiantCours> getListeEtudiantCours() {
	// return listeEtudiantCours;
	// }
	//
	//
	// public void setListeEtudiantCours(List<EtudiantCours> listeEtudiantCours) {
	// this.listeEtudiantCours = listeEtudiantCours;
	// }

	public List<Promotion> getListePromo() {
		return listePromo;
	}

	public void setListePromo(List<Promotion> listePromo) {
		this.listePromo = listePromo;
	}

}
