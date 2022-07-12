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

	
	public void createEmptyAdressBook();

	/**
	 * @param primaryStage
	 */
	public void selectAnAddressBookToLoad(Stage primaryStage);

	/**
	 * @return
	 */
	public boolean saveCurrentOpenedDemandeFile();

	/**
	 * @param primaryStage
	 */
	public void selectDemandeFileToSaveAs(Stage primaryStage);


	public void setDemandeList(List<Demande> demandes) throws DAOException ;


	/**
	 * Returns a list of all 'services'.
	 * 
	 * @return
	 */
	public List<Service> listerServices () throws DAOException;

	/**
	 * Returns a list of all 'services' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Service> listerServices ( String whereClause)  throws DAOException;

	/**
	 * Delete the 'service' set in parameter.
	 * 
	 * 
	 * @param service
	 */
	public void supprimerService (Service service) throws DAOException;

	/**
	 * Update the 'service' set in parameter. 
	 * 
	 * 
	 * @param service
	 */
	public void modifierService (Service service) throws DAOException;

	/**
	 * Save the 'service' set in parameter. 
	 *  
	 * 
	 * @param service
	 */
	public void creerService (Service service) throws DAOException;



	/**
	 * Find and return the 'service' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Service rechercherService( String whereClause)  throws DAOException;

	/**
	 * Find and return the 'service' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Service rechercherService( Integer primaryKey)  throws DAOException;	





	/**
	 * Returns a list of all 'departements'.
	 * 
	 * @param 
	 * @return
	 */
	public List<Departement> listerDepartements () throws DAOException ;

	/**
	 * 
	 * Returns a list of 'departements' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Departement> listerDepartements ( String whereClause) throws DAOException ;

	/**
	 * Delete the 'departement' set in parameter.
	 * 
	 * 
	 * @param departement
	 */
	public void supprimerDepartement (Departement departement) throws DAOException ;

	/**
	 * Update the 'departement' set in parameter.
	 * 
	 * 
	 * @param departement
	 */
	public void modifierDepartement (Departement departement) throws DAOException ;

	/**
	 * Save the 'departement' set in parameter.
	 * 
	 * 
	 * @param departement
	 */
	public void creerDepartement (Departement departement) throws DAOException ;


	/**
	 * Find the 'departement' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Departement rechercherDepartement ( String whereClause) throws DAOException ;

	/**
	 * Find the 'departement' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Departement rechercherDepartement ( Integer primaryKey) throws DAOException ;	



	/**
	 * Returns a list of all 'managers'.
	 * 
	 * @return
	 */
	public List<Manager> listerManagers () throws DAOException ;

	/**
	 * Returns a list of all 'manager' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Manager> listerManagers ( String whereClause)  throws DAOException ;

	/**
	 * Delete the 'manager' set in parameter. 
	 * 
	 * 
	 * @param service
	 */
	public void supprimerManager (Manager manager) throws DAOException ;

	/**
	 * Update the 'manager' set in parameter. 
	 *  
	 * 
	 * @param service
	 */
	public void modifierManager (Manager manager) throws DAOException ;

	/**
	 * Save the 'manager' set in parameter. 
	 *  
	 * 
	 * @param service
	 */
	public void creerManager (Manager manager) throws DAOException ;



	/**
	 * Find and return the 'manager' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Manager rechercherManager( String whereClause)  throws DAOException ;

	/**
	 * Find and return the 'manager' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Manager rechercherManager( Integer primaryKey)  throws DAOException;



	/**
	 * Enable the user set in parameter.
	 *  
	 * 
	 * @param utilisateur
	 * @return
	 */
	public void activerUtilisateur  (Utilisateur utilisateur) throws DAOException;	

	/**
	 * Disable the user set in parameter.
	 * 
	 * 
	 * @param utilisateur
	 * @return
	 */
	public void desactiverUtilisateur  (Utilisateur utilisateur) throws DAOException;	

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
	public List<Utilisateur> listerUtilisateurs  () throws DAOException;

	/**
	 * Returns a list of all 'utilisteurs' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Utilisateur> listerUtilisateurs  ( String whereClause)  throws DAOException;

	/**
	 * 
	 * Delete the 'utilisateur' set in parameter.
	 * 
	 * 
	 * @param utilisateur
	 */
	public void supprimerUtilisateur  (Utilisateur utilisateur) throws DAOException;

	/**
	 * Update the 'utilisateur' set in parameter. 
	 * 
	 * 
	 * @param utilisateur
	 */
	public void modifierUtilisateur  (Utilisateur utilisateur) throws DAOException;

	/**
	 * Save the 'utilisateur' set in parameter. 
	 * 
	 * 
	 * @param utilisateur
	 */
	public void creerUtilisateur  (Utilisateur utilisateur) throws DAOException;


	/**
	 * Find and return the 'utilisateur' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Utilisateur rechercherUtilisateur ( String whereClause)  throws DAOException;

	/**
	 * Find and return the 'utilisateur' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Utilisateur rechercherUtilisateur ( Integer primaryKey)  throws DAOException;	



	/**
	 * TODO
	 * 
	 * @return
	 */
	public String getTheDaoImplementationClassname () throws DAOException;

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
	public List<Produit> listerProduits  () throws DAOException;

	/**
	 * Returns a list of all 'produits' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Produit> listerProduits  ( String whereClause)  throws DAOException;

	/**
	 * Delete the 'produit' set in parameter. 
	 * 
	 *  
	 * @param produit
	 */
	public void supprimerProduit  (Produit produit) throws DAOException;

	/**
	 * Update the 'produit' set in parameter. 
	 *  
	 * 
	 * 
	 * @param produit
	 */
	public void modifierProduit  (Produit produit) throws DAOException;

	/**
	 * Save the 'produit' set in parameter. 
	 * 
	 * 
	 * @param produit
	 */
	public void creerProduit  (Produit produit) throws DAOException;


	/**
	 * Find and return the 'produit' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Produit rechercherProduit ( String whereClause)  throws DAOException;

	/**
	 * Find and return the 'produit' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Produit rechercherProduit ( Integer primaryKey)  throws DAOException;	






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
	public List<Role> listerRoles  () throws DAOException;

	/**
	 * Returns a list of all 'roles' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Role> listerRoles  ( String whereClause)  throws DAOException;

	/**
	 * Delete the 'role' set in parameter. 
	 * 
	 *  
	 * @param role
	 */
	public void supprimerRole  (Role role) throws DAOException;

	/**
	 * Update the 'role' set in parameter. 
	 * 
	 * 
	 * 
	 * @param role
	 */
	public void modifierRole  (Role role) throws DAOException;

	/**
	 * Save the 'role' set in parameter. 
	 * 
	 * 
	 * @param role
	 */
	public void creerRole  (Role role) throws DAOException;


	/**
	 * Find and return the 'role' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Role rechercherRole ( String whereClause)  throws DAOException;


	/**
	 * Find and return the 'role' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Role rechercherRole ( Integer primaryKey)  throws DAOException;	



	/**
	 * Returns a list of all 'employes'.
	 * 
	 * @param persons
	 * @return
	 */
	public List<Employe> listerEmployes  () throws DAOException;

	/**
	 * Returns a list of all 'employes' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Employe> listerEmployes  ( String whereClause)  throws DAOException;

	/**
	 * Delete the 'employe' set in parameter. 
	 * 
	 *  
	 * @param employe
	 */
	public void supprimerEmploye  (Employe employe) throws DAOException;

	/**
	 * Update the 'employe' set in parameter. 
	 * 
	 * 
	 * 
	 * @param employe
	 */
	public void modifierEmploye  (Employe employe) throws DAOException;

	/**
	 * Save the 'employe' set in parameter. 
	 * 
	 * 
	 * @param employe
	 */
	public void creerEmploye  (Employe employe) throws DAOException;


	/**
	 * Find and return the 'employe' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Employe rechercherEmploye ( String whereClause)  throws DAOException;

	/**
	 * Find and return the 'employe' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */

	public Employe rechercherEmploye ( Integer primaryKey)  throws DAOException;	



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

	public List<Demande> listerDemandes () throws DAOException ;



	/**
	 * Returns a list of all 'Demande' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */

	public List<Demande> listerDemandes ( String whereClause)  throws DAOException ;



	/**
	 * Delete the 'Demande' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param service
	 */

	public void supprimerDemande (Demande Demande) throws DAOException ;


	/**
	 * Update the 'Demande' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */

	public void modifierDemande (Demande Demande) throws DAOException ;


	/**
	 * Save the 'Demande' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */
	public void creerDemande (Demande Demande) throws DAOException ;


	/**
	 * Find and return the 'Demande' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */

	public Demande rechercherDemande( String whereClause)  throws DAOException ;


	/**
	 * Find and return the 'Demande' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */

	public Demande rechercherDemande( Integer primaryKey)  throws DAOException;

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
	public List<Note> listerNotes () throws DAOException ;

	/**
	 * Returns a list of all 'note' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Note> listerNotes ( String whereClause)  throws DAOException ;

	/**
	 * Delete the 'note' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param service
	 */
	public void supprimerNote (Note note) throws DAOException ;

	/**
	 * Update the 'note' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */

	public void modifierNote (Note note) throws DAOException ;


	/**
	 * Save the 'note' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */
	public void creerNote (Note note) throws DAOException ;


	/**
	 * Find and return the 'note' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Note rechercherNote( Integer primaryKey)  throws DAOException;

	/**
	 * Find and return the 'note' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @throws DAOException
	 */
	public Note rechercherNote (String whereClause) throws DAOException;

	/**
	 * Returns the number of 'Demandes'
	 * 
	 * @return
	 */
	public Integer RetournerNombreDemandesTotal ();

	/**
	 * Returns the number of 'Employes'
	 * 
	 * @return
	 */
	public Integer RetournerNombreEmployesTotal ();

	/**
	 * Returns the number of 'Departements'
	 * 
	 * @return
	 */
	public Integer RetournerNombreDepartementsTotal ();

	/**
	 * Returns the number of 'Services'
	 * 
	 * @return
	 */
	public Integer RetournerNombreServicesTotal ();

	/**
	 * Returns the number of 'Produits'
	 * 
	 * @return
	 */
	public Integer RetournerNombreProduitsTotal();


	public ObservableList<Demande> loadDemandesObservableList () throws DAOException;


	public ObservableList<Demande> getCurrentDemandesObservableList () throws DAOException;


	public ObservableList<Employe> loadEmployesObservableList () throws DAOException;


	public ObservableList<Employe> getCurrentEmployesObservableList () throws DAOException;


	public ObservableList<Role> loadRoleObservableList () throws DAOException;


	public ObservableList<Role> getCurrentRolesObservableList () throws DAOException;


	public ObservableList<Produit> loadProduitsObservableList () throws DAOException;


	public ObservableList<Produit> getCurrentProduitsObservableList () throws DAOException;


	public ObservableList<Service> loadServicesObservableList () throws DAOException;


	public ObservableList<Service> getCurrentServicesObservableList () throws DAOException;


	public ObservableList<Departement> loadDepartementsObservableList () throws DAOException;


	public ObservableList<Departement> getCurrentDepartementsObservableList () throws DAOException;



	/**
	 * @return
	 */
	public ObservableList<Demande> loadDemandesByServiceObservableList (Service service) throws DAOException;

	/**
	 * @return
	 */
	public ObservableList<Demande> getCurrentDemandesByServiceObservableList () throws DAOException;


	/**
	 * @return
	 */
	public ObservableList<Demande> loadDemandesByDirectionObservableList (Object direction) throws DAOException;




	/**
	 * Retourne l'utilisateur identifi�, sinon null
	 * 
	 * @param login
	 * @param password
	 * @return
	 * @throws DAOException
	 */
	public  Object validerIdentifiants(String login, String password) throws DAOException;

	/**
	 * Method qui permet de definir la reponse de la demande (rejeter , cloturée ...)
	 *
	 * @param demande
	 * @param reponse
	 * @throws DAOException
	 */
	public void repondreDemande(Demande demande, String reponse) throws DAOException; 


	/**
	 * Associate an employe to a service
	 * @param employe
	 * @param service
	 * @throws DAOException
	 */
	public void associerService(Employe employe, Service service) throws DAOException;

}