package com.rekest.dao;

import java.util.List;

import com.rekest.exeptions.DAOException;

public interface IDao {
	
	/**
	 * @param entity
	 * @throws Exception 
	 * @ 
	 */
	public void save(Object entity) throws DAOException ;

	/**
	 * @param entity
	 * @throws Exception 
	 * @ 
	 */
	public void delete(Object entity) throws DAOException ;

	/**
	 * @param entityClass
	 * @param primaryKey
	 * @return
	 * @throws Exception 
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
	 * @throws Exception 
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
	 * @throws Exception 
	 * @ 
	 */
	public Object find(Class<?> entityClass, String whereClause) throws DAOException ;
	
}
