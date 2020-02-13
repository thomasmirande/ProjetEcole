package com.intiformation.gestionecole.managedbean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.intiformation.gestionecole.dao.AdresseDao;
import com.intiformation.gestionecole.dao.EnseignantDaoImpl;
import com.intiformation.gestionecole.dao.EtudiantDaoImpl;
import com.intiformation.gestionecole.entity.Adresse;
import com.intiformation.gestionecole.entity.Enseignant;
import com.intiformation.gestionecole.entity.Etudiant;

@ManagedBean(name="gestionEnseignantBean")
@SessionScoped
public class GestionEnseignantBean implements Serializable {
	/*-------------------Props en private-----------------------------------*/
	
	private Collection<Enseignant> listeEnseignant;
	
	private EnseignantDaoImpl enseignantDao;
	
	private Enseignant enseignant;
	
	private AdresseDao adresseDao;
	
	private Adresse adresse;
	
	/*-------------------Ctors au mini un vide------------------------------*/

	public GestionEnseignantBean() {
		enseignantDao = new EnseignantDaoImpl();
	
	}//end ctor vide

	
	
	/*-------------------Méthodes-------------------------------------------*/
	
	public Collection<Enseignant> findAllEnseignantBdd(){
		listeEnseignant = enseignantDao.getAll();
		return listeEnseignant;
	}
	
	public void supprimerEnseignant(ActionEvent event) {
		
		UIParameter component = (UIParameter) event.getComponent().findComponent("deleteId");

		int ensId = (int) component.getValue();
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			enseignantDao.delete(ensId);
			FacesMessage messageDelete = new FacesMessage("L'enseignant a été supprimé avec succès");
			
			context.addMessage(null, messageDelete);
			
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage("Echec de la suppression"));

		}
	
	}
	
	public void initialiserEnseignant(ActionEvent event) {
		Enseignant enseignantAjout = new Enseignant();
		setEnseignant(enseignantAjout);
	}
	
	public void ajouterEnseignant(ActionEvent event) {
		enseignantDao.add(enseignant);
	}
	
	
	/*-------------------Guetter/Setter-------------------------------------------*/
	
	public Collection<Enseignant> getListeEnseignant() {
		return listeEnseignant;
	}

	public void setListeEnseignant(Collection<Enseignant> listeEnseignant) {
		this.listeEnseignant = listeEnseignant;
	}

	public EnseignantDaoImpl getEnseignantDao() {
		return enseignantDao;
	}

	public void setEnseignantDao(EnseignantDaoImpl enseignantDao) {
		this.enseignantDao = enseignantDao;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public AdresseDao getAdresseDao() {
		return adresseDao;
	}

	public void setAdresseDao(AdresseDao adresseDao) {
		this.adresseDao = adresseDao;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
