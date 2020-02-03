package com.intiformation.gestionecole.validateurs;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PasswordValidator implements Validator {
	
	@Override
	public void validate(FacesContext facesContext, UIComponent component, Object valeurSaisie2) throws ValidatorException {
		try {
			//1.récup de la saisie de l'utilisateur
			String saisie2 = (String) valeurSaisie2;
			
			//2.implémentation de la logique de validation
			if (!saisie2.isEmpty()) {
				//-->Saisie n'est pas vide
				
			}else {
				//-->Saisie n'est pas vide
				throw new Exception("La valeur du MDP est obligatoire");
			}//end else
			
		} catch (Exception ex) {
			
			FacesMessage facesMessage = new FacesMessage(ex.getMessage());
			
				throw new ValidatorException(facesMessage);
		}//end catch
		
	}


}
