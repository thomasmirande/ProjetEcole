package com.intiformation.gestionecole.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.intiformation.gestionecole.entity.Administrateur;
import com.intiformation.gestionecole.entity.Adresse;
import com.intiformation.gestionecole.entity.Cours;
import com.intiformation.gestionecole.entity.Enseignant;
import com.intiformation.gestionecole.entity.Matiere;
import com.intiformation.gestionecole.tool.JpaUtil;

public class AdresseDao implements IGestion<Adresse>{
	
	// 1. recup de l'EntityManager à partir de l'utilitaire JpaUtil
	private EntityManager entityManager = JpaUtil.getInstance();

	@Override
	public List<Adresse> getAll() {
		try {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
			CriteriaQuery<Adresse> criteriaQuery = criteriaBuilder.createQuery(Adresse.class);		
			
			Root<Adresse> clauseFROM = criteriaQuery.from(Adresse.class);
			
			CriteriaQuery<Adresse> clauseSELECT = criteriaQuery.select(clauseFROM);
			
			TypedQuery<Adresse> getAllQuery = entityManager.createQuery(clauseSELECT);
			
			// 4. Execution et recup du resultat de la requete 
			List<Adresse> listeAdresse = getAllQuery.getResultList();
			
			return listeAdresse;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public void delete(int pIdAdresse) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Adresse adresseSup = entityManager.find(Adresse.class, pIdAdresse);
			entityManager.remove(adresseSup);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La suppression a échoué");
		}
		
	}

	@Override
	public Adresse getById(int pIdAdresse) {
		try {
			
			Adresse adresseRecherche = entityManager.find(Adresse.class, pIdAdresse);
			return adresseRecherche;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'affichage a échoué");
		}
		return null;
	}

	@Override
	public void add(Adresse pAdresse) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(pAdresse);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'ajout a échoué");
		}
		
	}

	@Override
	public void update(Adresse pAdresse, int pIdAdresse) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Adresse adresseModif = entityManager.find(Adresse.class, pIdAdresse);
			
			adresseModif.setRue(pAdresse.getRue());
			adresseModif.setCodePostal(pAdresse.getCodePostal());
			adresseModif.setVille(pAdresse.getVille());

			entityManager.merge(adresseModif);
			
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La modification a échoué");
		}
		
	}// end update
	
	public void attribuerAdresse(Administrateur pAdmin, Adresse pAdresse) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			
			int idAdmin = pAdmin.getIdentifiant();
			int idAdresse = pAdresse.getIdAdresse();
			
			Administrateur adminAttribution = entityManager.find(Administrateur.class, idAdmin);
			Adresse adresseAttribution = entityManager.find(Adresse.class, idAdresse);
			
			adminAttribution.setAdresse(adresseAttribution);
			
			tx.commit();

			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'attribution du cours a échoué");
		}
		
	}// end attribuerMatiere
	
	
	public void attribuerAdresseEnseignant(Enseignant pEnseignant, Adresse pAdresse) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			
			int idenseignant = pEnseignant.getIdentifiant();
			int idAdresse = pAdresse.getIdAdresse();
			
			Enseignant ensAttribution = entityManager.find(Enseignant.class, idenseignant);
			Adresse adresseAttribution = entityManager.find(Adresse.class, idAdresse);
			
			ensAttribution.setAdresse(adresseAttribution);
			
			tx.commit();

			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'attribution du cours a échoué");
		}
		
	}// end attribuerMatiere

}// end class
