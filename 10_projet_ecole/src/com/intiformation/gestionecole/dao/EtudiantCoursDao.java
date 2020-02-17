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
import com.intiformation.gestionecole.entity.EtudiantCours;
import com.intiformation.gestionecole.tool.JpaUtil;

public class EtudiantCoursDao implements IEtudiantCoursDao{

	@Override
	public List<EtudiantCours> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	@Override
	public EtudiantCours getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(EtudiantCours t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EtudiantCours t, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
//	private EntityManager entityManager = JpaUtil.getInstance();
//	@Override
//	public List<EtudiantCours> getAll() {
//			try {
//			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		
//			CriteriaQuery<EtudiantCours> criteriaQuery = criteriaBuilder.createQuery(EtudiantCours.class);		
//			
//			Root<EtudiantCours> clauseFROM = criteriaQuery.from(EtudiantCours.class);
//			
//			CriteriaQuery<EtudiantCours> clauseSELECT = criteriaQuery.select(clauseFROM);
//			
//			TypedQuery<EtudiantCours> getAllQuery = entityManager.createQuery(clauseSELECT);
//			
//			// 4. Execution et recup du resultat de la requete 
//			List<EtudiantCours> listeEtudiantCours = getAllQuery.getResultList();
//			
//			return listeEtudiantCours;
//			
//		} catch (PersistenceException e) {
//			e.printStackTrace();
//		} 
//		return null;
//	}
//	
//
//	@Override
//	public EtudiantCours getById(int pIdEtudiantCours) {
//		try {
//			
//			EtudiantCours etudiantCoursRecherche = entityManager.find(EtudiantCours.class, pIdEtudiantCours);
//			return etudiantCoursRecherche;
//			
//		} catch (PersistenceException e) {
//			e.printStackTrace();
//			System.out.println("L'affichage a échoué");
//		}
//		return null;
//	}
//	
//
//	@Override
//	public void add(EtudiantCours pEtudiantCours) {
//		try {
//			
//			EntityTransaction tx = entityManager.getTransaction();
//			tx.begin();
//			entityManager.persist(pEtudiantCours);
//			tx.commit();
//			
//		} catch (PersistenceException e) {
//			e.printStackTrace();
//			System.out.println("L'ajout a échoué");
//		}
//		
//	}
//
//	@Override
//	public void update(EtudiantCours pEtudiantCours, int pIdEtudiantCours) {
//		try {
//			EntityTransaction tx = entityManager.getTransaction();
//			tx.begin();
//			EtudiantCours etudiantCoursModif = entityManager.find(EtudiantCours.class, pIdEtudiantCours);
//			
//			etudiantCoursModif.setAbsence(pEtudiantCours.getAbsence());
//			etudiantCoursModif.setMotif(pEtudiantCours.getMotif());
//			etudiantCoursModif.setCours_id(pEtudiantCours.getCours_id());
//			etudiantCoursModif.setEtudiant_id(pEtudiantCours.getEtudiant_id());
//			entityManager.merge(etudiantCoursModif);
//			
//			tx.commit();
//			
//		} catch (PersistenceException e) {
//			e.printStackTrace();
//			System.out.println("La modification a échoué");
//		}
//		
//	}
//
//	@Override
//	public void delete(int pIdEtudiantCours) {
//			try {
//			
//			EntityTransaction tx = entityManager.getTransaction();
//			tx.begin();
//			EtudiantCours etudiantCoursSup = entityManager.find(EtudiantCours.class, pIdEtudiantCours);
//			entityManager.remove(etudiantCoursSup);
//			tx.commit();
//			
//		} catch (PersistenceException e) {
//			e.printStackTrace();
//			System.out.println("La suppression a échoué");
//		}
//		
//	}

}
