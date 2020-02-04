package com.intiformation.gestionecole.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.intiformation.gestionecole.entity.Aide;

import com.intiformation.gestionecole.entity.Enseignant;
import com.intiformation.gestionecole.entity.Personne;
import com.intiformation.gestionecole.tool.JpaUtil;

public class EnseignantDaoImpl implements IEnseignantDao {
	
	private EntityManager entityManager = JpaUtil.getInstance();
	@Override
	public List<Enseignant> getAll() {
		
		try {
			
			
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
			
			
			CriteriaQuery<Enseignant> criteriaQuery = criteriaBuilder.createQuery(Enseignant.class);		
			
			
			Root<Enseignant> clauseFROM = criteriaQuery.from(Enseignant.class);
			
			
			CriteriaQuery<Enseignant> clauseSELECT = criteriaQuery.select(clauseFROM);
			
			
			TypedQuery<Enseignant> getAllQuery = entityManager.createQuery(clauseSELECT);
			
			
			List<Enseignant> listeEnseignant = getAllQuery.getResultList();
			
			return listeEnseignant;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public Enseignant getById(int pIdEnseignant) {
		try {
			
			Enseignant enseignantRecherche = entityManager.find(Enseignant.class, pIdEnseignant);
			return enseignantRecherche;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'affichage a échoué");
		}
		return null;
	}
	

	@Override
	public void add(Enseignant pEnseignant) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(pEnseignant);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'ajout a échoué");
		}
	
	}

	@Override
	public void update(Enseignant pEnseignant, int pIdEnseignant) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Enseignant enseignantModif = entityManager.find(Enseignant.class, pIdEnseignant);
			
			enseignantModif.setMotDePasse(pEnseignant.getMotDePasse());
			enseignantModif.setNom(pEnseignant.getNom());
			enseignantModif.setPrenom(pEnseignant.getPrenom());
			enseignantModif.setEmail(pEnseignant.getEmail());
			entityManager.merge(enseignantModif);
			
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La modification a échoué");
		}
		
	}
	

	@Override
	public void delete(int pIdEnseignant) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Enseignant enseignantSup = entityManager.find(Enseignant.class, pIdEnseignant);
			entityManager.remove(enseignantSup);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La suppression a échoué");
		}
	}

	@Override
	public boolean isExist(String pLogin, String pMotDePasse) {
		Enseignant enseignantLog = new Enseignant(motDePasse, nom, prenom, email)
	}

	/* 	ajouter des cours et exercices associés.				==>Add ok
 		afficher les cours par promotion, matière et date.		==>Get all ok
		gérer les absences des élèves à leurs cours.			==>
 		afficher un récapitulatif des absences des étudiants.	==>
 		*/

	

}
