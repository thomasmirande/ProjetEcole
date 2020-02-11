package com.intiformation.gestionecole.tool;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class MdpValidateur implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		try {
			
			// 1. recup de la saisie 
			String saisie = (String) value;
			
			// 2. Implémentation de la logique de validation
			if(saisie.isEmpty()) {
				// la saisie est vide
				throw new Exception("Le mot de passe est obligatoire");
			}
			
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			throw new ValidatorException(facesMessage);
		}
		
	}// end validate

}
