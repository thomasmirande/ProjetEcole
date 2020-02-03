package com.intiformation.gestionecole.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
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
	public Etudiant getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Etudiant t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Etudiant t, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
