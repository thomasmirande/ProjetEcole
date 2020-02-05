package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.intiformation.gestionecole.dao.EnseignantDaoImpl;
import com.intiformation.gestionecole.entity.Enseignant;
import com.intiformation.gestionecole.tool.SessionUser;

@ManagedBean(name="navigationBean")
@SessionScoped
public class GestionNavigationBean implements Serializable {

	/*-------------------Props en private-----------------------------------*/
	private String log;
	private String pas;
	
	private EnseignantDaoImpl enseignantDao;
	private Enseignant enseignant;
	
	/*-------------------Ctors au mini un vide------------------------------*/
	
	
	public GestionNavigationBean() {
		enseignantDao = new EnseignantDaoImpl();
	}//end ctor vide
	
	/*---------------------------Méthode------------------------------------*/
	public  String NavigationAccueil() {
		return "navAide";
	}
	
	
	public String connecterEnseignant(ActionEvent event) {
		
		UIParameter componentId = (UIParameter) event.getComponent().findComponent("userId");
		String idUser = (String) componentId.getValue();
		
		UIParameter componentMdp = (UIParameter) event.getComponent().findComponent("userMdp");
		String mdpUser = (String) componentMdp.getValue();
		
		if(enseignantDao.isExist(idUser, mdpUser)) {
			//-> enseignantExiste
			// 1. création de la session
			HttpSession session = SessionUser.getUtilisateurSession();
			
			// 2. sauvegarde du login dans la session
			session.setAttribute(idUser, log);
			
			//3. renvoi de la page de redirection
			return "index.xhtml";
		} else {
			//-> enseignant Existe pas 
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec de connexion", "Identifiant ou mot de passe invalide"));
			return "authentification.xhtml";
		}// end else
	}// end connecterEnseignant
	
	
	public String deconnecterEnseignant() {
		// 1. Recup de la session
		HttpSession session = SessionUser.getUtilisateurSession();
		
		// 2. Deconnexion
		session.invalidate();
		
		// 3. Redirection
		return "authentification.xhtml";
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
