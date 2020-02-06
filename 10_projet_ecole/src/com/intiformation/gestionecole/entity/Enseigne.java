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
import javax.persistence.ManyToOne;

@Entity
public class Enseigne {
	
	//Propriétés
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEnseigne;
	
	// Association
	

	
	
	/**
	 * Association Many enseigne to One Enseignant
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ENSEIGNANT_ID", referencedColumnName="identifiant")
	private Enseignant enseignant;
	
	/**
	 * Association Many enseigne to One Promotion
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PROMOTION_ID", referencedColumnName="idPromotion")
	private Promotion promotion;
	
	/**
	 * Association Many enseigne to One Matière
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="MATIERE_ID", referencedColumnName="idMatiere")
	private Matiere matiere;
	
	
	
	
	
	/*_________________________________Ctor____________________________________________________________________________________________*/
	public Enseigne() {
	}


	public int getIdEnseigne() {
		return idEnseigne;
	}


	public void setIdEnseigne(int idEnseigne) {
		this.idEnseigne = idEnseigne;
	}
	
	

}// end class
