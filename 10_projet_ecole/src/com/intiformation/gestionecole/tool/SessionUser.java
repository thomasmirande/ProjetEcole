package com.intiformation.gestionecole.tool;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUser {
	
	public static HttpSession getUtilisateurSession() {
		
		// 1. recup du contenu de JSF 
		FacesContext context = FacesContext.getCurrentInstance();
		
		// 2. recup de la session
		HttpSession session = (HttpSession) context.getCurrentInstance();
		
		// 3. renvoi de la session
		return session;
		
	}

}// end class
