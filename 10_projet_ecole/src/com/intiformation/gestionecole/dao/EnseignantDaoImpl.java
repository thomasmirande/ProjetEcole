package com.intiformation.gestionecole.dao;

import java.util.List;

import javax.persistence.EntityManager;
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
	public Enseignant getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Enseignant t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Enseignant t, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
