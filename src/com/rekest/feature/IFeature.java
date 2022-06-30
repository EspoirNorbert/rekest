package com.rekest.feature;

import com.rekest.entities.Departement;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exeptions.DAOException;

import javafx.collections.ObservableList;

import java.util.List;

public interface IFeature {
	
	/**************Utilisateurs**************/
	default void activerUtilisateur(Utilisateur utilisateur) throws DAOException {}
	default void desactiverUtilisateur(Utilisateur utilisateur) throws DAOException {}
	default List<Utilisateur> listerUtilisateurs() throws DAOException {return null;}
	default List<Utilisateur> listerUtilisateurs(String whereClause) throws DAOException {return null;}
	default void supprimerUtilisateur(Utilisateur utilisateur) throws DAOException {};
	default void modifierUtilisateur(Utilisateur utilisateur) throws DAOException {};
	default void creerUtilisateur(Utilisateur utilisateur) throws DAOException {};
	default Utilisateur rechercherUtilisateur(String whereClause) throws DAOException {return null;};
	default Utilisateur rechercherUtilisateur(Integer primaryKey) throws DAOException {return null;};

	/**************Departement**************/
	default ObservableList<Departement> loadDepartementObservableList() throws DAOException {return null;}
	default ObservableList<Departement> getCurrentDepartmentObservableList() throws DAOException {return null;}
	default void clearDepartementList() throws DAOException {};
	default void setDepartmentList(List<Departement> departements) throws DAOException {}
	default List<Departement> listerDepartements() throws DAOException {return null;}
	default List<Departement> listerDepartements(String whereClause) throws DAOException {return null;}
	default void supprimerDepartement(Departement departement) throws DAOException {}
	default void modifierDepartement(Departement departement) throws DAOException {}
	default void creerDepartement(Departement departement) throws DAOException {}
	default Departement rechercherDepartement(String whereClause) throws DAOException {return null;}
	default Departement rechercherDepartement(Integer primaryKey) throws DAOException {return null;}
	
	/**
	 * Others methodes
	 */
	default void refresh() {};
}
