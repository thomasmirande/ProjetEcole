package com.intiformation.gestionecole.entity;

import java.io.Serializable;


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
import javax.persistence.OneToMany;

import com.intiformation.gestionecole.dao.EtudiantCoursDao;
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
	 * Association Many Cours to Many Etudiant
	 */
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ETUDIANT_COURS",joinColumns=@JoinColumn(name="COURS_ID"), inverseJoinColumns=@JoinColumn(name="ETUDIANT_ID")  )
	private List<Etudiant> listeEtudiants;
	/**
	 * Association : 
	 * 	-> un cours est porté par 1 matière
	 *  -> une matière peut porter sur 0 ou n cours
	 *  => Relation Many Cours To One Matiere
	 *  
	 *  -> Cours = coté * = coté porteur de la FK (ajout de JoinColumn)
	 * 
	 */
	@ManyToOne
	@JoinColumn(name="MATIERE_ID", referencedColumnName="idMatiere")
	private Matiere matiere;
	
	/*------------------------------------------------------*/
	/*-----------------------ASSOCIATION--------------------*/
	/*------------------------------------------------------*/
	/**
	 * Relation One Cours Many EtudiantCours
	 */
	
	@OneToMany(mappedBy="cours", targetEntity=EtudiantCoursDao.class, cascade=CascadeType.ALL)
	private List<EtudiantCoursDao> listeEtudiantCours;
	
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
	 * @return the promotion
	 */
	public Promotion getPromotion() {
		return promotion;
	}

//	public List<EtudiantCours> getListeEtudiantCours() {
//		return listeEtudiantCours;
//	}
//
//	public void setListeEtudiantCours(List<EtudiantCours> listeEtudiantCours) {
//		this.listeEtudiantCours = listeEtudiantCours;
//	}

	/**
	 * @param promotion the promotion to set
	 */
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return "Cours [idCours=" + idCours + ", libelle=" + libelle + ", date=" + date + ", duree=" + duree
				+ ", description=" + description + "]";
	}

	public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}

	public List<EtudiantCoursDao> getListeEtudiantCours() {
		return listeEtudiantCours;
	}

	public void setListeEtudiantCours(List<EtudiantCoursDao> listeEtudiantCours) {
		this.listeEtudiantCours = listeEtudiantCours;
	}
	
	
	

}// end class
