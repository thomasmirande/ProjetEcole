package com.intiformation.gestionecole.validateurs;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class LoginValidator implements Validator {
	
	private String saisie;

	
		@Override
		public void validate(FacesContext facesContext, UIComponent component, Object valeurSaisie) throws ValidatorException {
			try {
				//1.récup de la saisie de l'utilisateur
				 String saisie = (String) valeurSaisie;
				
				//2.implémentation de la logique de validation
				if (!saisie.isEmpty()) {
					//-->Saisie n'est pas vide
					
				}else {
					//-->Saisie n'est pas vide
					throw new Exception("La valeur du Login est obligatoire");
				}//end else
				
			} catch (Exception ex) {
				
				FacesMessage facesMessage = new FacesMessage(ex.getMessage());
				
					throw new ValidatorException(facesMessage);
			}
		
		}

		public LoginValidator() {
			super();
		}

		public String getSaisie() {
			return saisie;
		}

		public void setSaisie(String saisie) {
			this.saisie = saisie;
		}
		
	}// End Login

