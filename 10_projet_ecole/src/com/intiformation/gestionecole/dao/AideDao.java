package com.intiformation.gestionecole.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.intiformation.gestionecole.entity.Aide;
import com.intiformation.gestionecole.tool.JpaUtil;

public class AideDao implements IAideDao {
	// 1. recup de l'EntityManager à partir de l'utilitaire JpaUtil
				private EntityManager entityManager = JpaUtil.getInstance();

				@Override
				public List<Aide> getAll() {
					
					try {
						
						// 2. Construction de la requete de type Criteria 
						// 2.1 recup de l'interface principale de l'API Criteria (cette interface permet de créer la requete Criteria)
						// CriteriaBuilder permet de construire la requete
						CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
					
						
						// 2.2 recup d'une instance de type CriteriaQuery
						// -> CriteriaQuery = enveloppe dans laquelle on va construire la requete
						//                  -> définit toutes les requetes de sélection de bdd
						//					-> modélise toutes les clauses de requete select du JPQL (WHERE...)
						CriteriaQuery<Aide> criteriaQuery = criteriaBuilder.createQuery(Aide.class);		
						
						/**
						 * Reproduction de la requete JPQL :
						 * SELECT a FROM aide a
						 */
						// 2.2.1 Construcion du FROM de la requete : FROM etudiant e
						Root<Aide> clauseFROM = criteriaQuery.from(Aide.class);
						
						// 2.2.2 Construcion du SELECT de la requete : SELECT e
						CriteriaQuery<Aide> clauseSELECT = criteriaQuery.select(clauseFROM);
						
						// 3. Transmission de la requete Criteria à l'EntityManager
						TypedQuery<Aide> getAllQuery = entityManager.createQuery(clauseSELECT);
						
						// 4. Execution et recup du resultat de la requete 
						List<Aide> listeAide = getAllQuery.getResultList();
						
						return listeAide;
						
					} catch (PersistenceException e) {
						e.printStackTrace();
					} 
					return null;

					
				}// end getAll

				@Override
				public Aide getById(int id) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean add(Aide t) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean update(Aide t, int id) {
					// TODO Auto-generated method stub
					return false;
				}

				

				@Override
				public boolean delete(int id) {
					// TODO Auto-generated method stub
					return false;
				}
				
}
