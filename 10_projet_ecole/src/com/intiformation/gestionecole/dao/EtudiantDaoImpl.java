package com.intiformation.gestionecole.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import com.intiformation.gestionecole.entity.Enseignant;
import com.intiformation.gestionecole.entity.Etudiant;
import com.intiformation.gestionecole.tool.JpaUtil;

public class EtudiantDaoImpl implements IEtudiantDao {
	private EntityManager entityManager = JpaUtil.getInstance();
	@Override
	public List<Etudiant> getAll() {
			try {
			
			
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
			
			
			CriteriaQuery<Etudiant> criteriaQuery = criteriaBuilder.createQuery(Etudiant.class);		
			
			
			Root<Etudiant> clauseFROM = criteriaQuery.from(Etudiant.class);
			
			
			CriteriaQuery<Etudiant> clauseSELECT = criteriaQuery.select(clauseFROM);
			
			
			TypedQuery<Etudiant> getAllQuery = entityManager.createQuery(clauseSELECT);
			
			
			List<Etudiant> listeEtudiant = getAllQuery.getResultList();
			
			return listeEtudiant;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} 
		return null;
	}
	

	@Override
	public Etudiant getById(int pidEtudiant) {
		try {
			
			Etudiant etudiantRecherche = entityManager.find(Etudiant.class, pidEtudiant);
			return etudiantRecherche;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'affichage a échoué");
		}
		return null;
	}

	@Override
	public void add(Etudiant pEtudiant) {
try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(pEtudiant);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'ajout a échoué");
		}
	}

	@Override
	public void update(Etudiant pEtudiant, int pidEtudiant) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Etudiant etudiantModif = entityManager.find(Etudiant.class, pidEtudiant);
			
			etudiantModif.setMotDePasse(pEtudiant.getMotDePasse());
			etudiantModif.setNom(pEtudiant.getNom());
			etudiantModif.setPrenom(pEtudiant.getPrenom());
			etudiantModif.setEmail(pEtudiant.getEmail());
			etudiantModif.setDateDeNaissance(pEtudiant.getDateDeNaissance());
			entityManager.merge(etudiantModif);
			
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La modification a échoué");
		}
	}
	
	public void update(Etudiant pEtudiant) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Etudiant etudiantModif = entityManager.find(Etudiant.class, pEtudiant.getIdentifiant());
			
			etudiantModif.setMotDePasse(pEtudiant.getMotDePasse());
			etudiantModif.setNom(pEtudiant.getNom());
			etudiantModif.setPrenom(pEtudiant.getPrenom());
			etudiantModif.setEmail(pEtudiant.getEmail());
			etudiantModif.setDateDeNaissance(pEtudiant.getDateDeNaissance());
			entityManager.merge(etudiantModif);
			
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La modification a échoué");
		}
	}

	@Override
	public void delete(int pidEtudiant) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Etudiant etudiantSup = entityManager.find(Etudiant.class, pidEtudiant);
			entityManager.remove(etudiantSup);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La suppression a échoué");
		}
	}


	@Override
	public boolean isExist(String pLogin, String pMotDePasse) {
		String requeteCount = "SELECT COUNT(e.identifiant) FROM etudiant e WHERE e.email = :pEtudiantLogin AND e.motDePasse = :pMotDePasse";
		
		try {
			
			
			Query countQuery = entityManager.createQuery(requeteCount);
			countQuery.setParameter("pEtudiantLogin", pLogin);
			countQuery.setParameter("pMotDePasse", pMotDePasse);
			
			Long nombreEtudiant = (Long) countQuery.getSingleResult();
			
			return(nombreEtudiant ==1)?true:false;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		}
		return false;
	}

}
