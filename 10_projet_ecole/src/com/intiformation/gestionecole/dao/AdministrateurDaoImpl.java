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

import com.intiformation.gestionecole.entity.Enseignant;
import com.intiformation.gestionecole.tool.JpaUtil;

public class AdministrateurDaoImpl implements IAdministrateurDao {
	private EntityManager entityManager = JpaUtil.getInstance();
	@Override
	public List<Administrateur> getAll() {
try {
			
			
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
			
			
			CriteriaQuery<Administrateur> criteriaQuery = criteriaBuilder.createQuery(Administrateur.class);		
			
			
			Root<Administrateur> clauseFROM = criteriaQuery.from(Administrateur.class);
			
			
			CriteriaQuery<Administrateur> clauseSELECT = criteriaQuery.select(clauseFROM);
			
			
			TypedQuery<Administrateur> getAllQuery = entityManager.createQuery(clauseSELECT);
			
			
			List<Administrateur> listeAdministrateur = getAllQuery.getResultList();
			
			return listeAdministrateur;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	@Override
	public Administrateur getById(int pIdAdministrateur) {
		try {
			
			Administrateur adminRecherche = entityManager.find(Administrateur.class, pIdAdministrateur );
			return adminRecherche;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'affichage a échoué");
		}
		return null;
	}

	@Override
	public void add(Administrateur pAdministrateur) {
		try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(pAdministrateur);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("L'ajout a échoué");
		}
	}

	@Override
	public void update(Administrateur pAdministrateur, int pIdAdministrateur) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Administrateur adminModif = entityManager.find(Administrateur.class, pIdAdministrateur);
			
			adminModif.setMotDePasse(pAdministrateur.getMotDePasse());
			adminModif.setNom(pAdministrateur.getNom());
			adminModif.setPrenom(pAdministrateur.getPrenom());
			adminModif.setEmail(pAdministrateur.getEmail());
			entityManager.merge(adminModif);
			
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La modification a échoué");
		}
	}

	@Override
	public void delete(int pIdAdministrateur) {
try {
			
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Administrateur adminSup = entityManager.find(Administrateur.class, pIdAdministrateur);
			entityManager.remove(adminSup);
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("La suppression a échoué");
		}
	}

}
