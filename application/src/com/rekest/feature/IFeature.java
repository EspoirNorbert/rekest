package com.rekest.feature;

import java.util.List;


import com.rekest.entities.Demande;
import com.rekest.entities.Departement;
import com.rekest.entities.Note;
import com.rekest.entities.Produit;
import com.rekest.entities.Role;
import com.rekest.entities.Service;
import com.rekest.entities.employes.Employe;
import com.rekest.entities.employes.Manager;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exeptions.DAOException;

import javafx.collections.ObservableList;
import javafx.stage.Stage;

public interface IFeature {


	default void createEmptyAdressBook() {}

	/**
	 * @param primaryStage
	 */
	default void selectAnAddressBookToLoad(Stage primaryStage) {}

	/**
	 * @return
	 */
	default boolean saveCurrentOpenedDemandeFile() {
		return false;
	}

	/**
	 * @param primaryStage
	 */
	default void selectDemandeFileToSaveAs(Stage primaryStage) {}


	default void setDemandeList(List<Demande> demandes) throws DAOException {}


	/**
	 * Returns a list of all 'services'.
	 * 
	 * @return
	 */
	default List<Service> listerServices () throws DAOException {
		return null;
	}

	/**
	 * Returns a list of all 'services' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default List<Service> listerServices ( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Delete the 'service' set in parameter.
	 * 
	 * 
	 * @param service
	 */
	default void supprimerService (Service service) throws DAOException {}

	/**
	 * Update the 'service' set in parameter. 
	 * 
	 * 
	 * @param service
	 */
	default void modifierService (Service service) throws DAOException {}

	/**
	 * Save the 'service' set in parameter. 
	 *  
	 * 
	 * @param service
	 */
	default void creerService (Service service) throws DAOException {}



	/**
	 * Find and return the 'service' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default Service rechercherService( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Find and return the 'service' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	default Service rechercherService( Integer primaryKey)  throws DAOException {
		return null;
	}





	/**
	 * Returns a list of all 'departements'.
	 * 
	 * @param 
	 * @return
	 */
	default List<Departement> listerDepartements () throws DAOException {
		return null;
	}

	/**
	 * 
	 * Returns a list of 'departements' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default List<Departement> listerDepartements ( String whereClause) throws DAOException {
		return null;
	}

	/**
	 * Delete the 'departement' set in parameter.
	 * 
	 * 
	 * @param departement
	 */
	default void supprimerDepartement (Departement departement) throws DAOException {}

	/**
	 * Update the 'departement' set in parameter.
	 * 
	 * 
	 * @param departement
	 */
	default void modifierDepartement (Departement departement) throws DAOException {}

	/**
	 * Save the 'departement' set in parameter.
	 * 
	 * 
	 * @param departement
	 */
	default void creerDepartement (Departement departement) throws DAOException {}


	/**
	 * Find the 'departement' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default Departement rechercherDepartement ( String whereClause) throws DAOException {
		return null;
	}

	/**
	 * Find the 'departement' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	default Departement rechercherDepartement ( Integer primaryKey) throws DAOException {
		return null;
	}



	/**
	 * Returns a list of all 'managers'.
	 * 
	 * @return
	 */
	default List<Manager> listerManagers () throws DAOException {
		return null;
	}

	/**
	 * Returns a list of all 'manager' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default List<Manager> listerManagers ( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Delete the 'manager' set in parameter. 
	 * 
	 * 
	 * @param service
	 */
	default void supprimerManager (Manager manager) throws DAOException {}

	/**
	 * Update the 'manager' set in parameter. 
	 *  
	 * 
	 * @param service
	 */
	default void modifierManager (Manager manager) throws DAOException {}

	/**
	 * Save the 'manager' set in parameter. 
	 *  
	 * 
	 * @param service
	 */
	default void creerManager (Manager manager) throws DAOException {}



	/**
	 * Find and return the 'manager' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default Manager rechercherManager( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Find and return the 'manager' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	default Manager rechercherManager( Integer primaryKey)  throws DAOException {
		return null;
	}



	/**
	 * Enable the user set in parameter.
	 *  
	 * 
	 * @param utilisateur
	 * @return
	 */
	default void activerUtilisateur  (Utilisateur utilisateur) throws DAOException {}

	/**
	 * Disable the user set in parameter.
	 * 
	 * 
	 * @param utilisateur
	 * @return
	 */
	default void desactiverUtilisateur  (Utilisateur utilisateur) throws DAOException {}

	/**
	 * 
	 */
	//public void rafraichirUtilisateur (Utilisateur utilisateur) throws DAOException;


	/**
	 * Returns a list of all 'utilisteurs'.
	 * 
	 * @param persons
	 * @return
	 */
	default List<Utilisateur> listerUtilisateurs  () throws DAOException {
		return null;
	}

	/**
	 * Returns a list of all 'utilisteurs' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default List<Utilisateur> listerUtilisateurs  ( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * 
	 * Delete the 'utilisateur' set in parameter.
	 * 
	 * 
	 * @param utilisateur
	 */
	default void supprimerUtilisateur  (Utilisateur utilisateur) throws DAOException {}

	/**
	 * Update the 'utilisateur' set in parameter. 
	 * 
	 * 
	 * @param utilisateur
	 */
	default void modifierUtilisateur  (Utilisateur utilisateur) throws DAOException {}

	/**
	 * Save the 'utilisateur' set in parameter. 
	 * 
	 * 
	 * @param utilisateur
	 */
	default void creerUtilisateur  (Utilisateur utilisateur) throws DAOException {}


	/**
	 * Find and return the 'utilisateur' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default Utilisateur rechercherUtilisateur ( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Find and return the 'utilisateur' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	default Utilisateur rechercherUtilisateur ( Integer primaryKey)  throws DAOException {
		return null;
	}



	/**
	 * TODO
	 * 
	 * @return
	 */
	default String getTheDaoImplementationClassname () throws DAOException {
		return null;
	}

	/**
	 * @return
	 * @throws DAOException 
	 */
	//public ObservableList<Utilisateur> chargerUtilisateurObservableList () throws DAOException;

	/**
	 * @return
	 */
	//public ObservableList<Utilisateur> getCurrentUtilisateurObservableList () throws DAOException;


	/**
	 * Returns a list of all 'produits'.
	 * 
	 * @param persons
	 * @return
	 */
	default List<Produit> listerProduits  () throws DAOException {
		return null;
	}

	/**
	 * Returns a list of all 'produits' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default List<Produit> listerProduits  ( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Delete the 'produit' set in parameter. 
	 * 
	 *  
	 * @param produit
	 */
	default void supprimerProduit  (Produit produit) throws DAOException {}

	/**
	 * Update the 'produit' set in parameter. 
	 *  
	 * 
	 * 
	 * @param produit
	 */
	default void modifierProduit  (Produit produit) throws DAOException {}

	/**
	 * Save the 'produit' set in parameter. 
	 * 
	 * 
	 * @param produit
	 */
	default void creerProduit  (Produit produit) throws DAOException {}


	/**
	 * Find and return the 'produit' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default Produit rechercherProduit ( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Find and return the 'produit' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	default Produit rechercherProduit ( Integer primaryKey)  throws DAOException {
		return null;
	}






	/**
	 * TODO
	 */
	//public void rafraichirRole  (Role role) throws DAOException;


	/**
	 * Returns a list of all 'roles'.
	 * 
	 * @param persons
	 * @return
	 */
	default List<Role> listerRoles  () throws DAOException {
		return null;
	}

	/**
	 * Returns a list of all 'roles' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default List<Role> listerRoles  ( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Delete the 'role' set in parameter. 
	 * 
	 *  
	 * @param role
	 */
	default void supprimerRole  (Role role) throws DAOException {}

	/**
	 * Update the 'role' set in parameter. 
	 * 
	 * 
	 * 
	 * @param role
	 */
	default void modifierRole  (Role role) throws DAOException {}

	/**
	 * Save the 'role' set in parameter. 
	 * 
	 * 
	 * @param role
	 */
	default void creerRole  (Role role) throws DAOException {}


	/**
	 * Find and return the 'role' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default Role rechercherRole ( String whereClause)  throws DAOException {
		return null;
	}


	/**
	 * Find and return the 'role' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	default Role rechercherRole ( Integer primaryKey)  throws DAOException {
		return null;
	}



	/**
	 * Returns a list of all 'employes'.
	 * 
	 * @param persons
	 * @return
	 */
	default List<Employe> listerEmployes  () throws DAOException {
		return null;
	}

	/**
	 * Returns a list of all 'employes' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default List<Employe> listerEmployes  ( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Delete the 'employe' set in parameter. 
	 * 
	 *  
	 * @param employe
	 */
	default void supprimerEmploye  (Employe employe) throws DAOException {}

	/**
	 * Update the 'employe' set in parameter. 
	 * 
	 * 
	 * 
	 * @param employe
	 */
	default void modifierEmploye  (Employe employe) throws DAOException {}

	/**
	 * Save the 'employe' set in parameter. 
	 * 
	 * 
	 * @param employe
	 */
	default void creerEmploye  (Employe employe) throws DAOException {}


	/**
	 * Find and return the 'employe' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default Employe rechercherEmploye ( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Find and return the 'employe' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */

	default Employe rechercherEmploye ( Integer primaryKey)  throws DAOException {
		return null;
	}



	/**
	 * TODO
	 * @param Demande
	 * @return
	 */
	//public void rafraichirDemande (Demande Demande) throws Exception 




	/**
	 * Returns a list of all 'Demandes'.
	 * 
	 * @return
	 */

	default List<Demande> listerDemandes () throws DAOException {
		return null;
	}



	/**
	 * Returns a list of all 'Demande' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */

	default List<Demande> listerDemandes ( String whereClause)  throws DAOException {
		return null;
	}



	/**
	 * Delete the 'Demande' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param service
	 */

	default void supprimerDemande (Demande Demande) throws DAOException {}


	/**
	 * Update the 'Demande' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */

	default void modifierDemande (Demande Demande) throws DAOException {}


	/**
	 * Save the 'Demande' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */
	default void creerDemande (Demande Demande) throws DAOException {}


	/**
	 * Find and return the 'Demande' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */

	default Demande rechercherDemande( String whereClause)  throws DAOException {
		return null;
	}


	/**
	 * Find and return the 'Demande' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */

	default Demande rechercherDemande( Integer primaryKey)  throws DAOException {
		return null;
	}

	/**
	 * TODO
	 * @param note
	 * @return
	 */


	/**
	 * Returns a list of all 'notes'.
	 * 
	 * @return
	 */
	default List<Note> listerNotes () throws DAOException {
		return null;
	}

	/**
	 * Returns a list of all 'note' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	default List<Note> listerNotes ( String whereClause)  throws DAOException {
		return null;
	}

	/**
	 * Delete the 'note' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param service
	 */
	default void supprimerNote (Note note) throws DAOException {}

	/**
	 * Update the 'note' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */

	default void modifierNote (Note note) throws DAOException {}


	/**
	 * Save the 'note' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */
	default void creerNote (Note note) throws DAOException {}


	/**
	 * Find and return the 'note' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	default Note rechercherNote( Integer primaryKey)  throws DAOException {
		return null;
	}

	/**
	 * Find and return the 'note' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @throws DAOException
	 */
	default Note rechercherNote (String whereClause) throws DAOException {
		return null;
	}

	/**
	 * Returns the number of 'Demandes'
	 * 
	 * @return
	 */
	default Integer RetournerNombreDemandesTotal () {
		return 0;
	}

	/**
	 * Returns the number of 'Employes'
	 * 
	 * @return
	 */
	default Integer RetournerNombreEmployesTotal () {
		return 0;
	}

	/**
	 * Returns the number of 'Departements'
	 * 
	 * @return
	 */
	default Integer RetournerNombreDepartementsTotal () {
		return 0;
	}

	/**
	 * Returns the number of 'Services'
	 * 
	 * @return
	 */
	default Integer RetournerNombreServicesTotal () {
		return 0;
	}

	/**
	 * Returns the number of 'Produits'
	 * 
	 * @return
	 */
	default Integer RetournerNombreProduitsTotal() {
		return 0;
	}


	default ObservableList<Demande> loadDemandesObservableList () throws DAOException{
		return null;
	}


	default ObservableList<Demande> getCurrentDemandesObservableList () throws DAOException {
		return null;
	}


	default ObservableList<Employe> loadEmployesObservableList () throws DAOException {
		return null;
	}


	default ObservableList<Employe> getCurrentEmployesObservableList () throws DAOException {
		return null;
	}


	default ObservableList<Role> loadRoleObservableList () throws DAOException {
		return null;
	}


	default ObservableList<Role> getCurrentRolesObservableList () throws DAOException {
		return null;
	}


	default ObservableList<Produit> loadProduitsObservableList () throws DAOException {
		return null;
	}


	default ObservableList<Produit> getCurrentProduitsObservableList () throws DAOException {
		return null;
	}


	default ObservableList<Service> loadServicesObservableList () throws DAOException {
		return null;
	}


	default ObservableList<Service> getCurrentServicesObservableList () throws DAOException {
		return null;
	}


	default ObservableList<Departement> loadDepartementsObservableList () throws DAOException {
		return null;
	}


	default ObservableList<Departement> getCurrentDepartementsObservableList () throws DAOException{
		return null;
	}



	/**
	 * @return
	 */
	default ObservableList<Demande> loadDemandesByServiceObservableList (Service service) throws DAOException {
		return null;
	}

	/**
	 * @return
	 */
	default ObservableList<Demande> getCurrentDemandesByServiceObservableList () throws DAOException {
		return null;
	}


	/**
	 * @return
	 */
	default ObservableList<Demande> loadDemandesByDirectionObservableList (Object direction) throws DAOException{
		return null;
	}




	/**
	 * Retourne l'utilisateur identifi�, sinon null
	 * 
	 * @param login
	 * @param password
	 * @return
	 * @throws DAOException
	 */
	default  Object validerIdentifiants(String login, String password) throws DAOException { return null;}

	/**
	 * Method qui permet de definir la reponse de la demande (rejeter , cloturée ...)
	 *
	 * @param demande
	 * @param reponse
	 * @throws DAOException
	 */
	default void repondreDemande(Demande demande, String reponse) throws DAOException {}


	/**
	 * Associate an employe to a service
	 * @param employe
	 * @param service
	 * @throws DAOException
	 */
	default void associerService(Employe employe, Service service) throws DAOException {}


	default ObservableList<Departement> loadDepartementObservableList() throws DAOException {return null;}
	default ObservableList<Departement> getCurrentDepartmentObservableList() throws DAOException {return null;}
	default void clearDepartementList() throws DAOException {};
	default void setDepartmentList(List<Departement> departements) throws DAOException {}
}