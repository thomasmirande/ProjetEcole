package com.intiformation.gestionecole.dao;

import java.util.List;

public interface IGestion<T> {

	/**
	 * R�cup de la liste des objets 
	 * @return
	 */
	public List<T> getAll();
	
	/**
	 * R�cup d'un objet via son id 
	 * @param id
	 * @return
	 */
	public T getById(int id);
	
	/**
	 * Ajoute un objet dans la bdd
	 * @param t : l'objet � ajouter 
	 * @return
	 */
	public boolean add(T t);
	
	/**
	 * Modif d'un objet dans la bdd
	 * @param t : l'objet � modifier
	 * @return
	 */
	public boolean update(T t, int id);
	
	
	
	
	/**
	 * Suppression d'un objet dans la bdd via son id
	 * @param t
	 * @return
	 */
	public boolean delete(int id);

}// end interface
