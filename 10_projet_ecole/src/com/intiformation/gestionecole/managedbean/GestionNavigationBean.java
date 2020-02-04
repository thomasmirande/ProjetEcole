package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="navigationBean")
@SessionScoped
public class GestionNavigationBean implements Serializable {

	/*-------------------Props en private-----------------------------------*/
	private String log;
	private String pas;
	
	// Dao
	private 
	
	/*-------------------Ctors au mini un vide------------------------------*/
	public GestionNavigationBean() {
		super();
	}//end ctor vide
	/*---------------------------Méthode------------------------------------*/
	public  String NavigationAccueil() {
		return "navAide";
	}
	/*------------------------Getters & Setter-----------------------------*/
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public String getPas() {
		return pas;
	}
	public void setPas(String pas) {
		this.pas = pas;
	}
	
}
