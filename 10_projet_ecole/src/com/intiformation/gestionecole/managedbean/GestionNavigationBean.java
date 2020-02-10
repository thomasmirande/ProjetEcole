package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.intiformation.gestionecole.dao.AdministrateurDaoImpl;
import com.intiformation.gestionecole.dao.EnseignantDaoImpl;
import com.intiformation.gestionecole.dao.EtudiantDaoImpl;
import com.intiformation.gestionecole.entity.Enseignant;
import com.intiformation.gestionecole.tool.SessionUser;

@ManagedBean(name="navigationBean")
@SessionScoped
public class GestionNavigationBean implements Serializable {

	/*-------------------Props en private-----------------------------------*/
	private String login;
	private String password;
	
	private EnseignantDaoImpl enseignantDao = new EnseignantDaoImpl();
	private Enseignant enseignant;
	
	private EtudiantDaoImpl etudiantDaoImpl = new EtudiantDaoImpl();
	private AdministrateurDaoImpl adminDaoImpl = new AdministrateurDaoImpl();
	
	/*-------------------Ctors au mini un vide------------------------------*/
	
	
	
	
	public GestionNavigationBean() {

	}//end ctor vide
	
	/*---------------------------Méthode------------------------------------*/
	public  String NavigationAccueil() {
		return "navAide";
	}
	
	
	public String connecterEnseignant() {
				
		if(enseignantDao.isExist(login, password)) {
			//-> enseignantExiste
			// 1. création de la session
			HttpSession session = SessionUser.getUtilisateurSession();
			
			// 2. sauvegarde du login dans la session
			session.setAttribute("user_login", login);
			
			//3. renvoi de la page de redirection
			return "index.xhtml";
		} else {
			//-> enseignant Existe pas 
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec de connexion", "Identifiant ou mot de passe invalide"));
			return "authentification.xhtml";
		}// end else
	}// end connecterEnseignant
	
	public String connecterUtilisateur() {
		
//		UIParameter componentId = (UIParameter) event.getComponent().findComponent("userId");
//		String idUser = (String) componentId.getValue();
//		
//		UIParameter componentMdp = (UIParameter) event.getComponent().findComponent("userMdp");
//		String mdpUser = (String) componentMdp.getValue();
		
		String utilisateur = "";
		
		if(enseignantDao.isExist(login, password)) {
			utilisateur = "enseignant";
		}
		
		if(etudiantDaoImpl.isExist(login, password)) {
			utilisateur = "etudiant";
		}
		
		if(adminDaoImpl.isExist(login, password)) {
			utilisateur = "admin";
		}
		
		switch (utilisateur) {
		case "enseignant":
			// 1. création de la session
			HttpSession sessionEnseignant = SessionUser.getUtilisateurSession();
			
			// 2. sauvegarde du login dans la session
			sessionEnseignant.setAttribute("user_login", login);
			
			//3. renvoi de la page de redirection
			return "Enseignant.xhtml";
			
		case "etudiant":
			// 1. création de la session
			HttpSession sessionEtudiant = SessionUser.getUtilisateurSession();
			
			// 2. sauvegarde du login dans la session
			sessionEtudiant.setAttribute("user_login", login);
			
			//3. renvoi de la page de redirection
			return "Etudiant.xhtml";
			
		case "admin":
			// 1. création de la session
			HttpSession sessionAdmin = SessionUser.getUtilisateurSession();
			
			// 2. sauvegarde du login dans la session
			sessionAdmin.setAttribute("user_login", login);
			
			//3. renvoi de la page de redirection
			return "Administrateur.xhtml";

		default:
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec de connexion", "Identifiant ou mot de passe invalide"));
			return "authentification.xhtml";
		}
		
	
	}// end connecterUtilisateur
	
	
	public String deconnecterEnseignant() {
		// 1. Recup de la session
		HttpSession session = SessionUser.getUtilisateurSession();
		
		// 2. Deconnexion
		session.invalidate();
		
		// 3. Redirection
		return "authentification.xhtml";
	}

	
	
	
	/*------------------------Getters & Setter-----------------------------*/
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	
}
