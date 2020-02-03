package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;

public class GestionAideBean implements Serializable {
	/*-------------------Props en private-----------------------------------*/
	private int idAide;
	private int page;
	private String contenu;
	/*-------------------Ctors au mini un vide------------------------------*/
	public GestionAideBean() {
		super();
	}//end Ctorvide
	public GestionAideBean(int page, String contenu) {
		super();
		this.page = page;
		this.contenu = contenu;
	}//end CtorSans Id
	public GestionAideBean(int idAide, int page, String contenu) {
		super();
		this.idAide = idAide;
		this.page = page;
		this.contenu = contenu;
	}//end CtorAll
	@Override
	public String toString() {
		return "GestionAideBean [idAide=" + idAide + ", page=" + page + ", contenu=" + contenu + "]";
	}//To String
	/*-------------------Méthodes-------------------------------------------*/
	public void aide() {
		
	}//end methodeaide
	
	/*-------Getters & Setter-----------------------------------*/
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
	
}//end GestionAideBean
