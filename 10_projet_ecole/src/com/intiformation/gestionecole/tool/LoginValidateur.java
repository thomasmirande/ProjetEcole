package com.intiformation.gestionecole.tool;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 * Implémentation d'un validateur pour le champ login de Authentification.xhtml
 * @author IN-BR-019
 *
 */
public class LoginValidateur implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		try {
			
			// 1. recup de la saisie de l'utilisateur
			String saisie = (String) value;
			
			//2. implémentation de la logique de validation
			if(!saisie.isEmpty()) {
				// --> la saisie n'est pas vide
				if(!saisie.contains("@")) {
					//--> la saisie ne ocntient pas un @
					throw new Exception("Le login doit etre une adresse mail valide");
				}
				
			} else {
				// --> la saisie est vide 
				throw new Exception("Le login est obligatoire");
			}
			
		} catch (Exception e) {
			// en cas d'erreur : transmission des messages d'exception à la vue
			// via la classe FacesMessage de JSF
			
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			throw new ValidatorException(facesMessage);
		}
		
	}// end validate

}
