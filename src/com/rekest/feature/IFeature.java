package com.rekest.feature;


import com.rekest.entities.Departement;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exeptions.DAOException;

import java.util.List;


public interface IFeature {


	/**
	 * Enable the user set in parameter.
	 * Return true if it succeeded, else false. 
	 * @param utilisateur
	 * @return
	 */
	 default void activerUtilisateur  (Utilisateur utilisateur) 
			throws DAOException {}

	/**
	 * Disable the user set in parameter.
	 * Return true if it succeeded, else false. 
	 * @param utilisateur
	 * @return
	 */
	 default void desactiverUtilisateur  (Utilisateur utilisateur) 
			throws DAOException {}

	/**
	 * Return a list of all 'utilisteurs'.
	 * @param persons
	 * @return
	 */
	 default List<Utilisateur> listerUtilisateurs() 
			throws DAOException {return null;}

	/**
	 * Return a list of all 'utilisteurs' according to the filters.
	 * @param whereClause
	 * @return
	 * @ 
	 */
	 default List<Utilisateur> listerUtilisateurs(String whereClause)  
			 throws DAOException{return null;}

	/**
	 * Delete the 'utilisateur' set in parameter.
	 * Return true if it succeeded, else false.
	 * @param utilisateur
	 */
	default void supprimerUtilisateur  (Utilisateur utilisateur) 
			throws DAOException {};

	/**
	 * Update the 'utilisateur' set in parameter. 
	 * Return true if it succeeded, else false.
	 * @param utilisateur
	 */
	default void modifierUtilisateur  (Utilisateur utilisateur) 
			throws DAOException {};

	/**
	 * Save the 'utilisateur' set in parameter. 
	 * Return true if it succeeded, else false.
	 * @param utilisateur
	 */
	default void creerUtilisateur(Utilisateur utilisateur) 
			throws DAOException {};

	/**
	 * Find and return the 'utilisateur' set in parameter if it exist, else null.
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default Utilisateur rechercherUtilisateur ( String whereClause)  
			throws DAOException {return null;};

	/**
	 * Find and return the 'utilisateur' set in parameter if it exist, else null.
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	default Utilisateur rechercherUtilisateur ( Integer primaryKey)  
			throws DAOException {return null;};	

	/**
	 * Return a list of all 'departements'.
	 * @param 
	 * @return
	 */
	default List<Departement> listerDepartements () 
			throws DAOException {return null;} ;

	/**
	 * Return a list of 'departements' according to the filters.
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default List<Departement> listerDepartements (String whereClause) 
			throws DAOException {return null;} ;

	/**
	 * Delete the 'departement' set in parameter.
	 * Return true if it succeeded, else false.
	 * @param departement
	 */
	default void supprimerDepartement (Departement departement) 
			throws DAOException {} ;

	/**
	 * Update the 'departement' set in parameter.
	 * Return true if it succeeded, else false.
	 * @param departement
	 */
	default void modifierDepartement (Departement departement) 
			throws DAOException {} ;

	/**
	 * Save the 'departement' set in parameter.
	 * Return true if it succeeded, else false.
	 * @param departement
	 */
	default void creerDepartement (Departement departement) 
			throws DAOException {} ;


	/**
	 * Find the 'departement' set in parameter if it exist, else null.
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default Departement rechercherDepartement ( String whereClause) 
			throws DAOException {return null;} ;

	/**
	 * Find the 'departement' set in parameter if it exist, else null.
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	default Departement rechercherDepartement ( Integer primaryKey) 
			throws DAOException {return null;}
}
