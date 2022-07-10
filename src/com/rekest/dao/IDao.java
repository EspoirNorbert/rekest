package com.rekest.dao;

import java.util.List;

import com.rekest.entities.Departement;
import com.rekest.entities.Service;
import com.rekest.entities.employes.Employe;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exeptions.DAOException;

import javafx.collections.ObservableList;

public interface IDao {
	
	/**
	 * @param entity
	 * @throws DAOException 
	 * @ 
	 */
	public void save(Object entity) throws DAOException ;

	/**
	 * @param entity
	 * @throws DAOException 
	 * @ 
	 */
	public void delete(Object entity) throws DAOException ;

	/**
	 * @param entityClass
	 * @param primaryKey
	 * @return
	 * @throws DAOException 
	 * @ 
	 */
	public Object find(Object entityClass, Integer primaryKey) throws DAOException ;
	
	/**
	 * @param entityClass
	 * @return
	 * @ 
	 */
	public List<Object> list(Object entityClass) throws DAOException;
	
	/**
	 * @param entityClass
	 * @return
	 * @throws DAOException 
	 * @ 
	 */
	public List<Object> list(Class<?> entityClass, String whereClause) throws DAOException ;
	
	/**
	 * @param entity
	 * @ 
	 */
	public void update(Object entity) throws DAOException;

	/**
	 * @param entityClass
	 * @param whereClause
	 * @return
	 * @throws DAOException 
	 * @ 
	 */
	public Object find(Class<?> entityClass, String whereClause) throws DAOException ;
	
	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 * @throws DAOException
	 */
	public default Object validateCredential(String login, String password) throws DAOException{return null;};
	
	/**
	 * 
	 * @param entity
	 * @throws DAOException
	 */
	public default void enableAccount(Utilisateur entity) throws DAOException{};
	
	/**
	 * 
	 * @param entity
	 * @throws DAOException
	 */
	public default void disableAccount(Utilisateur entity) throws DAOException{};
	
	/**
	 * 
	 * @param employe
	 * @param service
	 * @throws DAOException
	 */
	public default void associateService(Employe employe, Service service) throws DAOException{};
	
	/**
	 * 
	 */
	public default void refresh() {}
	
	/**
	 * @return
	 * @throws DAOException
	 */
	public default ObservableList<Departement> departementlistObservable() throws DAOException {
		return null;
	}
}
