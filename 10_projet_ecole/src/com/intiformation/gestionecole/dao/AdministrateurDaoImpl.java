package com.intiformation.gestionecole.dao;

import java.util.List;

import javax.persistence.EntityManager;
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
	public Administrateur getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Administrateur t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Administrateur t, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
