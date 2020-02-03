package com.intiformation.gestionecole.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.intiformation.gestionecole.entity.Cours;
import com.intiformation.gestionecole.entity.Matiere;
import com.intiformation.gestionecole.tool.JpaUtil;

public class MatiereDao implements IMatiereDao{
	
	// 1. recup de l'EntityManager à partir de l'utilitaire JpaUtil
	private EntityManager entityManager = JpaUtil.getInstance();

	@Override
	public List<Matiere> getAll() {
		try {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
			CriteriaQuery<Matiere> criteriaQuery = criteriaBuilder.createQuery(Matiere.class);		
			
			Root<Matiere> clauseFROM = criteriaQuery.from(Matiere.class);
			
			CriteriaQuery<Matiere> clauseSELECT = criteriaQuery.select(clauseFROM);
			
			TypedQuery<Matiere> getAllQuery = entityManager.createQuery(clauseSELECT);
			
			// 4. Execution et recup du resultat de la requete 
			List<Matiere> listeMatiere = getAllQuery.getResultList();
			
			return listeMatiere;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public Matiere getById(int pIdMatiere) {
		try {
			
			Matiere matiereRecherche = entityManager.find(Matiere.class, pIdMatiere);
			return matiereRecherche;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'affichage a échoué");
		}
		return null;
	}

	@Override
	public void add(Matiere pMatiere) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(pMatiere);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'ajout a échoué");
		}
		
	}

	@Override
	public void update(Matiere pMatiere, int pIdMatiere) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Matiere matiereModif = entityManager.find(Matiere.class, pIdMatiere);
			
			matiereModif.setLibelle(pMatiere.getLibelle());
			entityManager.merge(matiereModif);
			
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La modification a échoué");
		}
		
	}

	@Override
	public void delete(int pIdMatiere) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Matiere matiereSup = entityManager.find(Matiere.class, pIdMatiere);
			entityManager.remove(matiereSup);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La suppression a échoué");
		}
		
	}

	@Override
	public void attribuerCours(Matiere pMatiere, Cours pCours) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			
			int idCours = pCours.getIdCours();
			int idMatiere = pMatiere.getIdMatiere();
			
			Cours coursAttribution = entityManager.find(Cours.class, idCours);
			Matiere matiereAttribution = entityManager.find(Matiere.class, idMatiere);
			
			coursAttribution.setMatiere(matiereAttribution);
			
			tx.commit();

			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'attribution du cours a échoué");
		}
		
		
	}// end attribuerCours

}// end class
