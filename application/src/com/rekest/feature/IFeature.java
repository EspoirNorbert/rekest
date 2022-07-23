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

import javafx.collections.ObservableList;

/** 
 * @author Pape Omar Sylla
 */
public interface IFeature {

	
	/**
	 * Returns a list of all 'services'.
	 * 
	 * @return
	 */
	public List<Service> listerServices ()  ;

	/**
	 * Returns a list of all 'services' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Service> listerServices ( String whereClause)   ;
	
	/**
	 * Delete the 'service' set in parameter.
	 * Returns true if it succeeded, else false.
	 * 
	 * @param service
	 */
	public boolean supprimerService (Service service)  ;

	/**
	 * Update the 'service' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param service
	 */
	public boolean modifierService (Service service)  ;

	/**
	 * Save the 'service' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param service
	 */
	public boolean creerService (Service service)  ;
	


	/**
	 * Find and return the 'service' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Service rechercherService( String whereClause)   ;

	/**
	 * Find and return the 'service' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Service rechercherService( Integer primaryKey)   ;	
	

	/**
	 * Returns a list of all 'departements'.
	 * 
	 * @param 
	 * @return
	 */
	public List<Departement> listerDepartements ()   ;

	/**
	 * 
	 * Returns a list of 'departements' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Departement> listerDepartements ( String whereClause)   ;
	
	/**
	 * Delete the 'departement' set in parameter.
	 * Returns true if it succeeded, else false.
	 * 
	 * @param departement
	 */
	public boolean supprimerDepartement (Departement departement)   ;

	/**
	 * Update the 'departement' set in parameter.
	 * Returns true if it succeeded, else false.
	 * 
	 * @param departement
	 */
	public boolean modifierDepartement (Departement departement)   ;

	/**
	 * Save the 'departement' set in parameter.
	 * 
	 * 
	 * @param departement
	 */
	public boolean creerDepartement (Departement departement)   ;


	/**
	 * Find the 'departement' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Departement rechercherDepartement ( String whereClause)   ;

	/**
	 * Find the 'departement' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Departement rechercherDepartement ( Integer primaryKey)   ;	
	
	

	/**
	 * Returns a list of all 'managers'.
	 * 
	 * @return
	 */
	public List<Manager> listerManagers ()   ;

	/**
	 * Returns a list of all 'manager' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Manager> listerManagers ( String whereClause)    ;
	
	/**
	 * Delete the 'manager' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param service
	 */
	public boolean supprimerManager (Manager manager)   ;

	/**
	 * Update the 'manager' set in parameter. 
	 * Returns true if it succeeded, else false.
	 *  
	 * 
	 * @param service
	 */
	public boolean modifierManager (Manager manager)   ;

	/**
	 * Save the 'manager' set in parameter. 
	 *  
	 * 
	 * @param service
	 */
	public boolean creerManager (Manager manager)   ;
	


	/**
	 * Find and return the 'manager' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Manager rechercherManager( String whereClause)    ;

	/**
	 * Find and return the 'manager' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Manager rechercherManager( Integer primaryKey)   ;
	
	
	
	/**
	 * Enable the user set in parameter.
	 * Returns true if it succeeded, else false.
	 *  
	 * 
	 * @param utilisateur
	 * @return
	 */
	public boolean activerUtilisateur  (Utilisateur utilisateur)  ;	
	
	/**
	 * Disable the user set in parameter.
	 * Returns true if it succeeded, else false.
	 * 
	 * 
	 * @param utilisateur
	 * @return
	 */
	public boolean desactiverUtilisateur  (Utilisateur utilisateur)  ;	
	
	/**
	 * 
	 */
	//public boolean rafraichirUtilisateur (Utilisateur utilisateur)  ;


	/**
	 * Returns a list of all 'utilisteurs'.
	 * 
	 * @param persons
	 * @return
	 */
	public List<Utilisateur> listerUtilisateurs  ()  ;

	/**
	 * Returns a list of all 'utilisteurs' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Utilisateur> listerUtilisateurs  ( String whereClause)   ;
	
	/**
	 * 
	 * Delete the 'utilisateur' set in parameter.
	 * Returns true if it succeeded, else false.
	 * 
	 * 
	 * @param utilisateur
	 */
	public boolean supprimerUtilisateur  (Utilisateur utilisateur)  ;

	/**
	 * Update the 'utilisateur' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * 
	 * @param utilisateur
	 */
	public boolean modifierUtilisateur  (Utilisateur utilisateur)  ;

	/**
	 * Save the 'utilisateur' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * 
	 * @param utilisateur
	 */
	public boolean creerUtilisateur  (Utilisateur utilisateur)  ;


	/**
	 * Find and return the 'utilisateur' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Utilisateur rechercherUtilisateur ( String whereClause)   ;

	/**
	 * Find and return the 'utilisateur' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Utilisateur rechercherUtilisateur ( Integer primaryKey)   ;	
	
	
	
	/**
	 * TODO
	 * 
	 * @return
	 */
	public String getTheDaoImplementationClassname ()  ;
	
	/**
	 * @return
	 * @  
	 */
	//public ObservableList<Utilisateur> chargerUtilisateurObservableList ()  ;

	/**
	 * @return
	 */
	//public ObservableList<Utilisateur> getCurrentUtilisateurObservableList ()  ;


	/**
	 * Returns a list of all 'produits'.
	 * 
	 * @param persons
	 * @return
	 */
	public List<Produit> listerProduits  ()  ;

	/**
	 * Returns a list of all 'produits' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Produit> listerProduits  ( String whereClause)   ;
	
	/**
	 * Delete the 'produit' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 *  
	 * @param produit
	 */
	public boolean supprimerProduit  (Produit produit)  ;

	/**
	 * Update the 'produit' set in parameter. 
	 *  Returns true if it succeeded, else false.
	 * 
	 * 
	 * @param produit
	 */
	public boolean modifierProduit  (Produit produit)  ;

	/**
	 * Save the 'produit' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param produit
	 */
	public boolean creerProduit  (Produit produit)  ;


	/**
	 * Find and return the 'produit' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Produit rechercherProduit ( String whereClause)   ;

	/**
	 * Find and return the 'produit' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Produit rechercherProduit ( Integer primaryKey)   ;	

	
	
	

	
	/**
	 * TODO
	 */
	//public boolean rafraichirRole  (Role role)  ;


	/**
	 * Returns a list of all 'roles'.
	 * 
	 * @param persons
	 * @return
	 */
	public List<Role> listerRoles  ()  ;

	/**
	 * Returns a list of all 'roles' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Role> listerRoles  ( String whereClause)   ;
	
	/**
	 * Delete the 'role' set in parameter. 
	 * Returns true if it succeeded, else false.
	 *  
	 * @param role
	 */
	public boolean supprimerRole  (Role role)  ;

	/**
	 * Update the 'role' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * 
	 * @param role
	 */
	public boolean modifierRole  (Role role)  ;

	/**
	 * Save the 'role' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param role
	 */
	public boolean creerRole  (Role role)  ;


	/**
	 * Find and return the 'role' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Role rechercherRole ( String whereClause)   ;
	

	/**
	 * Find and return the 'role' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Role rechercherRole ( Integer primaryKey)   ;	



	/**
	 * Returns a list of all 'employes'.
	 * 
	 * @param persons
	 * @return
	 */
	public List<Employe> listerEmployes  ()  ;

	/**
	 * Returns a list of all 'employes' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Employe> listerEmployes  ( String whereClause)   ;
	
	/**
	 * Delete the 'employe' set in parameter. 
	 * Returns true if it succeeded, else false.
	 *  
	 * @param employe
	 */
	public boolean supprimerEmploye  (Employe employe)  ;

	/**
	 * Update the 'employe' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * 
	 * @param employe
	 */
	public boolean modifierEmploye  (Employe employe)  ;

	/**
	 * Save the 'employe' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param employe
	 */
	public boolean creerEmploye  (Employe employe)  ;


	/**
	 * Find and return the 'employe' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Employe rechercherEmploye ( String whereClause)   ;

	/**
	 * Find and return the 'employe' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */

	public Employe rechercherEmploye ( Integer primaryKey)   ;	
	

	
	/**
	 * TODO
	 * @param Demande
	 * @return
	 */
	//public boolean rafraichirDemande (Demande Demande) throws Exception 




	/**
	 * Returns a list of all 'Demandes'.
	 * 
	 * @return
	 */

	public List<Demande> listerDemandes ()   ;

	

	/**
	 * Returns a list of all 'Demande' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */

	public List<Demande> listerDemandes ( String whereClause)    ;

	
	/**
	 * Delete the 'Demande' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param service
	 */

	public boolean supprimerDemande (Demande Demande)   ;


	/**
	 * Update the 'Demande' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */

	public boolean modifierDemande (Demande Demande)   ;


	/**
	 * Save the 'Demande' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */
	public boolean creerDemande (Demande Demande)   ;


	/**
	 * Find and return the 'Demande' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */

	public Demande rechercherDemande( String whereClause)    ;


	/**
	 * Find and return the 'Demande' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */

	public Demande rechercherDemande( Integer primaryKey)   ;

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
	public List<Note> listerNotes ()   ;
	
/**
	 * Returns a list of all 'note' according to the filters.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public List<Note> listerNotes ( String whereClause)    ;

	/**
	 * Delete the 'note' set in parameter. 
	 * Returns true if it succeeded, else false.
	 * 
	 * @param service
	 */
	public boolean supprimerNote (Note note)   ;

	/**
	 * Update the 'note' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */

	public boolean modifierNote (Note note)   ;


	/**
	 * Save the 'note' set in parameter. 
	 * Returns true if it succeeded, else false. 
	 * 
	 * @param service
	 */
	public boolean creerNote (Note note)   ;


	/**
	 * Find and return the 'note' set in parameter if it exist, else null.
	 * 
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Note rechercherNote( Integer primaryKey)   ;
	
	/**
	 * Find and return the 'note' set in parameter if it exist, else null.
	 * 
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Note rechercherNote (String whereClause)  ;
	
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
	

	/**
	 * Returns a Observable list of the stored 'Demandes'
	 * 
	 * @return
	 * @ 
	 */
	public ObservableList<Demande> loadDemandesObservableList ()  ;


	
	
	/**
	 * Returns a Observable list of the stored 'Employes'
	 * 
	 * @return
	 * @ 
	 */
	public ObservableList<Employe> loadEmployesObservableList ()  ;	
	
	/**
	 * Returns a Observable list of the stored 'Utilisateurs'
	 * 
	 * @return
	 * @ 
	 */
	public ObservableList<Utilisateur> loadUtilisateursObservableList ()  ;




	/**
	 * Returns a Observable list of the stored 'Roles'
	 * 
	 * @return
	 * @ 
	 */
	public ObservableList<Role> loadRoleObservableList ()  ;


	/**
	 * Returns a Observable list of the stored 'Managers'
	 * 
	 * @return
	 * @ 
	 */
	public ObservableList<Manager> loadManagerObservableList ()  ;


	/**
	 * Returns a Observable list of the stored 'Notes'
	 * 
	 * @return
	 * @ 
	 */
	public ObservableList<Note> loadNoteObservableList ()  ;




	/**
	 * Returns a Observable list of the stored 'Produits'
	 * 
	 * @return
	 * @ 
	 */
	public ObservableList<Produit> loadProduitsObservableList ()  ;



	/**
	 * Returns a Observable list of the stored 'Services'
	 * 
	 * @return
	 * @ 
	 */
	public ObservableList<Service> loadServicesObservableList ()  ;




	/**
	 * Returns a Observable list of the stored 'Departement'
	 * 
	 * @return
	 * @ 
	 */
	public ObservableList<Departement> loadDepartementsObservableList ()  ;



	
	 
	/**
	 * Todo
	 * Returns a Observable list of the stored 'Demandes'.
	 * 
	 * @return
	 */
	public ObservableList<Demande> loadDemandesByServiceObservableList (Service service)  ;


	/**
	 * Todo
	 * Returns a Observable list of the stored 'Demandes' by direction.
	 * 
	 * @return
	 */
	public ObservableList<Demande> loadDemandesByDirectionObservableList (Object direction)  ;




	/**
	 * Returns the user identified, else null.
	 * 
	 * @param login
	 * @param password
	 * @return
	 * @ 
	 */
	public  Object validerIdentifiants(String login, String password)  ;
	
	/**
	 * Method qui permet de definir la reponse de la demande (rejeter , cloturée ...).
	 * Returns true if it succeeded, else false.
	 *
	 * @param demande
	 * @param reponse
	 * @ 
	 */
	public boolean repondreDemande(Demande demande, String reponse)  ; 
	
	
	/**
	 * Associate an employe to a service.
	 * Returns true if it succeeded, else false.
	 * 
	 * @param employe
	 * @param service
	 * @ 
	 */
	public boolean associerService(Employe employe, Service service);
	
}
