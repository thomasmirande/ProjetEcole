package com.intiformation.gestionecole.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Aide implements Serializable{

	
	
	/*-------------------Props en private-----------------------------------*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAide;
	private int page;
	private String contenu;
	
	/*-------------------Ctors au mini un vide------------------------------*/
	public Aide(int idAide, int page, String contenu) {
		super();
		this.idAide = idAide;
		this.page = page;
		this.contenu = contenu;
	}

	public Aide(int page, String contenu) {
		super();
		this.page = page;
		this.contenu = contenu;
	}

	public Aide() {
		super();
	}

	
	/*-------------------Getters & Setter-----------------------------------*/

	public int getIdAide() {
		return idAide;
	}

	public void setIdAide(int idAide) {
		this.idAide = idAide;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return "Aide [idAide=" + idAide + ", page=" + page + ", contenu=" + contenu + "]";
	}//end to String
	
	
}//end class
