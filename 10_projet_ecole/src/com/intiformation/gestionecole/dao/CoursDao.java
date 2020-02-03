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
import com.intiformation.gestionecole.entity.Promotion;
import com.intiformation.gestionecole.tool.JpaUtil;

public class CoursDao implements ICoursDao{
	
	// 1. recup de l'EntityManager à partir de l'utilitaire JpaUtil
	private EntityManager entityManager = JpaUtil.getInstance();

	@Override
	public List<Cours> getAll() {
		try {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
			CriteriaQuery<Cours> criteriaQuery = criteriaBuilder.createQuery(Cours.class);		
			
			Root<Cours> clauseFROM = criteriaQuery.from(Cours.class);
			
			CriteriaQuery<Cours> clauseSELECT = criteriaQuery.select(clauseFROM);
			
			TypedQuery<Cours> getAllQuery = entityManager.createQuery(clauseSELECT);
			
			// 4. Execution et recup du resultat de la requete 
			List<Cours> listeCours = getAllQuery.getResultList();
			
			return listeCours;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public Cours getById(int pIdCours) {
		try {
			
			Cours coursRecherche = entityManager.find(Cours.class, pIdCours);
			return coursRecherche;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'affichage a échoué");
		}
		return null;
	}

	@Override
	public void add(Cours pCours) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(pCours);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'ajout a échoué");
		}
		
		
	}

	@Override
	public void update(Cours pCours, int pIdCours) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Cours coursModif = entityManager.find(Cours.class, pIdCours);
			
			coursModif.setLibelle(pCours.getLibelle());
			coursModif.setDate(pCours.getDate());
			coursModif.setDuree(pCours.getDuree());
			coursModif.setDescription(pCours.getDescription());
			entityManager.merge(coursModif);
			
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La modification a échoué");
		}
		
	}

	@Override
	public void delete(int pIdCours) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Cours coursSup = entityManager.find(Cours.class, pIdCours);
			entityManager.remove(coursSup);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La suppression a échoué");
		}
		
	}

	@Override
	public void attribuerMatiere(Cours pCours, Matiere pMatiere) {
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
		
	}// end attribuerMatiere

	@Override
	public void attribuerPromotion(Cours pCours, Promotion pPromotion) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			
			int idCours = pCours.getIdCours();
			int idPromotion = pPromotion.getIdPromotion();
			
			Cours coursAttribution = entityManager.find(Cours.class, idCours);
			Promotion promoAttribution = entityManager.find(Promotion.class, idPromotion);
			
			coursAttribution.setPromotion(promoAttribution);
			
			tx.commit();

			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'attribution du cours a échoué");
		}
		
	}// end attribuerPromotion

}// end class
