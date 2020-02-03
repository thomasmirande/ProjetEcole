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

public class PromotionDao implements IPromotionDao{
	
	private EntityManager entityManager = JpaUtil.getInstance();

	@Override
	public List<Promotion> getAll() {
		try {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
			CriteriaQuery<Promotion> criteriaQuery = criteriaBuilder.createQuery(Promotion.class);		
			
			Root<Promotion> clauseFROM = criteriaQuery.from(Promotion.class);
			
			CriteriaQuery<Promotion> clauseSELECT = criteriaQuery.select(clauseFROM);
			
			TypedQuery<Promotion> getAllQuery = entityManager.createQuery(clauseSELECT);
			
			// 4. Execution et recup du resultat de la requete 
			List<Promotion> listePromotion = getAllQuery.getResultList();
			
			return listePromotion;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public Promotion getById(int pIdPromotion) {
		try {
			
			Promotion promoRecherche = entityManager.find(Promotion.class, pIdPromotion);
			return promoRecherche;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'affichage a échoué");
		}
		return null;
	}

	@Override
	public void add(Promotion pPromotion) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(pPromotion);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'ajout a échoué");
		}
		
	}

	@Override
	public void update(Promotion pPromotion, int pIdPromotion) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Promotion promoModif = entityManager.find(Promotion.class, pIdPromotion);
			
			promoModif.setLibelle(pPromotion.getLibelle());
			entityManager.merge(promoModif);
			
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La modification a échoué");
		}
		
	}

	@Override
	public void delete(int pIdPromotion) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Promotion promoSup = entityManager.find(Promotion.class, pIdPromotion);
			entityManager.remove(promoSup);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La suppression a échoué");
		}
		
	}

	@Override
	public void attribuerCours(Promotion pPromotion, Cours pCours) {
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
		
	}// end attribuerCours

}// end class