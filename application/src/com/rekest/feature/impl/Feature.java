package com.rekest.feature.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.rekest.dao.impl.HibernateDao;
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
import com.rekest.feature.IFeature;
import com.rekest.observableList.impl.ObservableListDemande;
import com.rekest.observableList.impl.ObservableListDepartement;
import com.rekest.observableList.impl.ObservableListEmploye;
import com.rekest.observableList.impl.ObservableListProduit;
import com.rekest.observableList.impl.ObservableListRole;
import com.rekest.observableList.impl.ObservableListService;
import com.rekest.utils.FileDemandeManager;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Feature implements IFeature {

	
	private static Feature instance = null;
	
	private Feature () {}

	public static Feature getCurrentInstance () {
		if (instance == null) instance = new Feature ();
		return instance;
	}
	
	public ObservableListDepartement OLDepartement = new ObservableListDepartement();
	public ObservableListEmploye OLEmploye = new ObservableListEmploye();
	public ObservableListProduit OLProduit = new ObservableListProduit();
	public ObservableListService OLService = new ObservableListService();
	public ObservableListRole OLRole = new ObservableListRole();
	public ObservableListDemande OLDemande = new ObservableListDemande();
	
	@Override
	public List<Role> listerRoles () throws DAOException {

		Role truc = new Role();
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( truc);
		List<Role> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Role) {
				objs.add ( (Role) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public List<Role> listerRoles (String whereClause) throws DAOException{

		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Role.class, whereClause);
		List<Role> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Role) {
				objs.add ( (Role) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public void supprimerRole (Role role) throws DAOException{
	
		HibernateDao.getCurrentInstance ().delete ( role);
		
	}

	@Override
	public void modifierRole (Role role) throws DAOException{


		 HibernateDao.getCurrentInstance ().update ( role);
		
	}

	@Override
	public void creerRole (Role role) throws DAOException{

		HibernateDao.getCurrentInstance ().save ( role);
		
	}

	@Override
	public Role rechercherRole (String whereClause) throws DAOException{

		return (Role) HibernateDao.getCurrentInstance ().find ( Role.class, whereClause);
	}

	@Override
	public Role rechercherRole (Integer primaryKey) throws DAOException {

		Role role = new Role ();
		return (Role) HibernateDao.getCurrentInstance ().find ( role, primaryKey);
	}
	
	
	@Override
	public List<Departement> listerDepartements () throws DAOException   {
		Departement truc = new Departement();
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( truc);
		List<Departement> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Departement) {
				objs.add ( (Departement) obj);
			}
		}
		
		return objs;
	}

	@Override
	public List<Departement> listerDepartements (String whereClause) throws DAOException  {

		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Departement.class, whereClause);
		List<Departement> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Departement) {
				objs.add ( (Departement) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public void supprimerDepartement (Departement departement) throws DAOException {
		
		  HibernateDao.getCurrentInstance ().delete ( departement);
		
	}

	@Override
	public void modifierDepartement (Departement departement) throws DAOException {
		
		  HibernateDao.getCurrentInstance ().update ( departement);
	}

	@Override
	public void creerDepartement (Departement departement) throws DAOException  {

		  HibernateDao.getCurrentInstance ().save ( departement);
		
	}

	@Override
	public Departement rechercherDepartement (String whereClause) throws DAOException {
		
		return (Departement) HibernateDao.getCurrentInstance ().find ( Departement.class, whereClause);
	}

	@Override
	public Departement rechercherDepartement (Integer primaryKey) throws DAOException  {

		Departement dep   = new Departement ();
		return (Departement) HibernateDao.getCurrentInstance ().find ( dep, primaryKey);
	}
	
	@Override
	public List<Manager> listerManagers () throws DAOException  {
		Manager truc = new Manager();
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( truc);
		List<Manager> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Manager) {
				objs.add ( (Manager) obj);
			}
		}
		
		return objs;
	}

	@Override
	public List<Manager> listerManagers (String whereClause) throws DAOException {

		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Manager.class, whereClause);
		List<Manager> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Manager) {
				objs.add ( (Manager) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public void supprimerManager (Manager manager) throws DAOException {
		
		HibernateDao.getCurrentInstance ().delete ( manager);
		
	}

	@Override
	public void modifierManager (Manager manager) throws DAOException {
		
		 HibernateDao.getCurrentInstance ().update ( manager);
	}

	@Override
	public void creerManager (Manager manager) throws DAOException {

		 HibernateDao.getCurrentInstance ().save ( manager);
		
	}

	@Override
	public Manager rechercherManager (String whereClause) throws DAOException {
		
		return (Manager) HibernateDao.getCurrentInstance ().find ( Manager.class, whereClause);
	}

	@Override
	public Manager rechercherManager (Integer primaryKey) throws DAOException {

		Manager manager = new Manager ();
		return (Manager) HibernateDao.getCurrentInstance ().find ( manager, primaryKey);
	}
	
	@Override
	public List<Produit> listerProduits () throws DAOException {
		Produit truc = new Produit();
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( truc);
		List<Produit> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Produit) {
				objs.add ( (Produit) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public List<Produit> listerProduits (String whereClause) throws DAOException{

		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Produit.class, whereClause);
		List<Produit> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Produit) {
				objs.add ( (Produit) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public void supprimerProduit (Produit produit) throws DAOException{
	
		HibernateDao.getCurrentInstance ().delete ( produit);
		
	}

	@Override
	public void modifierProduit (Produit produit) throws DAOException{


		 HibernateDao.getCurrentInstance ().update ( produit);
		
	}

	@Override
	public void creerProduit (Produit produit) throws DAOException{

		HibernateDao.getCurrentInstance ().save ( produit);
		
	}

	@Override
	public Produit rechercherProduit (String whereClause) throws DAOException{

		return (Produit) HibernateDao.getCurrentInstance ().find ( Produit.class, whereClause);
	}

	@Override
	public Produit rechercherProduit (Integer primaryKey) throws DAOException {

		Produit prod = new Produit ();
		return (Produit) HibernateDao.getCurrentInstance ().find ( prod, primaryKey);
	}
	
	@Override
	public List<Employe> listerEmployes () throws DAOException {
		Employe e = new Employe();
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( e);
		List<Employe> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Employe) {
				objs.add ( (Employe) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public List<Employe> listerEmployes (String whereClause) throws DAOException{

		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Employe.class, whereClause);
		List<Employe> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Employe) {
				objs.add ( (Employe) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public void supprimerEmploye (Employe employe) throws DAOException{
	
		HibernateDao.getCurrentInstance ().delete ( employe);
		
	}

	@Override
	public void modifierEmploye (Employe employe) throws DAOException{


		 HibernateDao.getCurrentInstance ().update ( employe);
		
	}

	@Override
	public void creerEmploye (Employe employe) throws DAOException{

		HibernateDao.getCurrentInstance ().save ( employe);
		
	}

	@Override
	public Employe rechercherEmploye (String whereClause) throws DAOException{

		return (Employe) HibernateDao.getCurrentInstance ().find ( Employe.class, whereClause);
	}

	@Override
	public Employe rechercherEmploye (Integer primaryKey) throws DAOException {

		Employe prod = new Employe ();
		return (Employe) HibernateDao.getCurrentInstance ().find ( prod, primaryKey);
	}
	
	
	
	@Override
	public List<Service> listerServices () throws DAOException{

		Service truc = new Service();
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( truc);
		List<Service> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Service) {
				objs.add ( (Service) obj);
			}
		}
		
		return objs;
	}

	@Override
	public List<Service> listerServices (String whereClause) throws DAOException{

		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Service.class, whereClause);
		List<Service> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Service) {
				objs.add ( (Service) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public void supprimerService (Service service) throws DAOException{
		
		 HibernateDao.getCurrentInstance ().delete ( service);
		
	}

	@Override
	public void modifierService (Service service) throws DAOException {
		
		HibernateDao.getCurrentInstance ().update ( service);
	}

	@Override
	public void creerService (Service service) throws DAOException{

		 HibernateDao.getCurrentInstance ().save ( service);
		
	}

	@Override
	public Service rechercherService (String whereClause) throws DAOException {
		
		return (Service) HibernateDao.getCurrentInstance ().find ( Service.class, whereClause);
	}

	@Override
	public Service rechercherService (Integer primaryKey) throws DAOException {

		Service serv = new Service ();
		return (Service) HibernateDao.getCurrentInstance ().find ( serv, primaryKey);
	}

	@Override
	public void activerUtilisateur (Utilisateur utilisateur) throws DAOException {
		
		HibernateDao.getCurrentInstance ().enableAccount (utilisateur);
	
		
	}

	@Override
	public void desactiverUtilisateur (Utilisateur utilisateur) throws DAOException {
		
		HibernateDao.getCurrentInstance ().disableAccount (utilisateur);
	}

	/*
	@Override
	public void rafraichirUtilisateur (Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return HibernateDao.getCurrentInstance ().;
	}
	*/

	@Override
	public List<Utilisateur> listerUtilisateurs () throws DAOException {

		Utilisateur truc = new Utilisateur();
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( truc);
		List<Utilisateur> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Utilisateur) {
				objs.add ( (Utilisateur) obj);
			}
		}
		
		return objs;
	}

	@Override
	public List<Utilisateur> listerUtilisateurs (String whereClause) throws DAOException{
		
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Utilisateur.class, whereClause);
		List<Utilisateur> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if (obj instanceof Utilisateur) {
				objs.add ( (Utilisateur) obj);
			}
		}
		
		return objs;
	}

	@Override
	public void supprimerUtilisateur (Utilisateur utilisateur) throws DAOException {
		 HibernateDao.getCurrentInstance ().delete ( utilisateur);
		
	}

	@Override
	public void modifierUtilisateur (Utilisateur utilisateur) throws DAOException {

		HibernateDao.getCurrentInstance ().update ( utilisateur);
	}

	@Override
	public void creerUtilisateur (Utilisateur utilisateur) throws DAOException {
	
		HibernateDao.getCurrentInstance ().save ( utilisateur);
		
	}


	
	@Override
	public Utilisateur rechercherUtilisateur (String whereClause) throws DAOException {
		
		return (Utilisateur) HibernateDao.getCurrentInstance ().find (  Utilisateur.class, whereClause);
	}

	@Override
	public Utilisateur rechercherUtilisateur (Integer primaryKey) throws DAOException{
		
		Utilisateur user = new Utilisateur ( null, null);
		return (Utilisateur) HibernateDao.getCurrentInstance ().find ( user , primaryKey);
	}
	
	
	
	
	@Override
	public List<Note> listerNotes () throws DAOException  {
		Note truc = new Note();
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( truc);
		List<Note> objs = new ArrayList<> ();
		for  (Object obj : objects) {
			if  (obj instanceof Note) {
				objs.add (  (Note) obj);
			}
		}
		
		return objs;
	}

	@Override
	public List<Note> listerNotes (String whereClause) throws DAOException {

		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Note.class, whereClause);
		List<Note> objs = new ArrayList<> ();
		for  (Object obj : objects) {
			if  (obj instanceof Note) {
				objs.add (  (Note) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public void supprimerNote (Note note) throws DAOException {
		
		HibernateDao.getCurrentInstance ().delete ( note);
		
	}

	@Override
	public void modifierNote (Note note) throws DAOException {
		
		 HibernateDao.getCurrentInstance ().update ( note);
	}

	@Override
	public void creerNote (Note note) throws DAOException {

		 HibernateDao.getCurrentInstance ().save ( note);
		
	}

	@Override
	public Note rechercherNote (String whereClause) throws DAOException {
		
		return   (Note) HibernateDao.getCurrentInstance ().find ( Note.class, whereClause);
	}

	@Override
	public Note rechercherNote (Integer primaryKey) throws DAOException {


		return   (Note) HibernateDao.getCurrentInstance ().find ( Note.class, primaryKey);
	}

	

	
	
	@Override
	public List<Demande> listerDemandes () throws DAOException  {
		Demande truc = new Demande();
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( truc);
		List<Demande> objs = new ArrayList<> ();
		for  (Object obj : objects) {
			if  (obj instanceof Demande) {
				objs.add (  (Demande) obj);
			}
		}
		
		return objs;
	}

	@Override
	public List<Demande> listerDemandes (String whereClause) throws DAOException {

		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Demande.class, whereClause);
		List<Demande> objs = new ArrayList<> ();
		for  (Object obj : objects) {
			if  (obj instanceof Demande) {
				objs.add (  (Demande) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public void supprimerDemande (Demande demande) throws DAOException {
		
		HibernateDao.getCurrentInstance ().delete ( demande);
		
	}

	@Override
	public void modifierDemande (Demande demande) throws DAOException {
		
		 HibernateDao.getCurrentInstance ().update ( demande);
	}

	@Override
	public void creerDemande (Demande demande) throws DAOException {

		 HibernateDao.getCurrentInstance ().save ( demande);
		
	}

	@Override
	public Demande rechercherDemande (String whereClause) throws DAOException {
		
		return   (Demande) HibernateDao.getCurrentInstance ().find ( Demande.class, whereClause);
	}

	@Override
	public Demande rechercherDemande (Integer primaryKey) throws DAOException {


		return   (Demande) HibernateDao.getCurrentInstance ().find ( Demande.class, primaryKey);
	}

	@Override
	public String getTheDaoImplementationClassname () {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Integer RetournerNombreDemandesTotal () {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer RetournerNombreEmployesTotal () {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer RetournerNombreDepartementsTotal () {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer RetournerNombreServicesTotal () {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer RetournerNombreProduitsTotal () {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ObservableList<Role> loadRoleObservableList() throws DAOException {

		Role truc = new Role();
		OLRole.addAll(  HibernateDao.getCurrentInstance ().list ( truc ));
		return OLRole.getData();
		
	}

	@Override
	public ObservableList<Role> getCurrentRolesObservableList() throws DAOException {
		
		return OLRole.getData();
		
	}

	@Override
	public ObservableList<Produit> loadProduitsObservableList() throws DAOException {

		Produit truc = new Produit();
		OLProduit.addAll(  HibernateDao.getCurrentInstance ().list ( truc ));
		return OLProduit.getData();
		
	}

	@Override
	public ObservableList<Produit> getCurrentProduitsObservableList() throws DAOException {

		return OLProduit.getData();
		
	}

	@Override
	public ObservableList<Service> loadServicesObservableList() throws DAOException {

		
		Service truc = new Service();
		OLService.addAll(  HibernateDao.getCurrentInstance ().list ( truc ));
		return OLService.getData();
		
	}

	@Override
	public ObservableList<Service> getCurrentServicesObservableList() throws DAOException {
		
		return OLService.getData();
		
	}

	@Override
	public ObservableList<Departement> loadDepartementsObservableList() throws DAOException {
		
		Departement truc = new Departement();
		OLDepartement.addAll(  HibernateDao.getCurrentInstance ().list ( truc ));
		return OLDepartement.getData();
	}

	@Override
	public ObservableList<Departement> getCurrentDepartementsObservableList() throws DAOException {
		
		return OLDepartement.getData();
		
	}

	@Override
	public ObservableList<Demande> loadDemandesObservableList () throws DAOException{
		
		Demande truc = new Demande();
		OLDemande.addAll(  HibernateDao.getCurrentInstance ().list ( truc ));
		return OLDemande.getData();
	}

	@Override
	public ObservableList<Demande> getCurrentDemandesObservableList () throws DAOException{
		// TODO Auto-generated method stub
		return OLDemande.getData(); 
	}

	@Override
	public ObservableList<Employe> loadEmployesObservableList () throws DAOException{
		
		
		Employe truc = new Employe();
		OLEmploye.addAll(  HibernateDao.getCurrentInstance ().list ( truc ));
		
		return OLEmploye.getData();
	}

	@Override
	public ObservableList<Employe> getCurrentEmployesObservableList () throws DAOException{
		// TODO Auto-generated method stub
		return OLEmploye.getData(); 
	}

	@Override
	public ObservableList<Demande> loadDemandesByServiceObservableList (Service service) throws DAOException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<Demande> getCurrentDemandesByServiceObservableList () throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<Demande> loadDemandesByDirectionObservableList (Object direction) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void repondreDemande (Demande demande, String reponse) throws DAOException  {
		HibernateDao.getCurrentInstance ().requestResponse (demande, reponse);
		
	}

	@Override
	public void createEmptyAdressBook() {
		
		OLDemande.clear();
		FileDemandeManager.setDemandeFilePath(null);
		
	}
	
	@Override
	public void setDemandeList(List<Demande> demandes) throws DAOException {
		
		OLDemande.clear();
		getCurrentDemandesObservableList().addAll(demandes);    
	}


	@Override
	public void selectAnAddressBookToLoad(Stage primaryStage) {


		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showOpenDialog(primaryStage);

		if (file != null) {
			FileDemandeManager.loadDemandeDataFromFile(file);
		}     
		
	}

	@Override
	public boolean saveCurrentOpenedDemandeFile() {
		
		File personFile = FileDemandeManager.getDemandeFilePath();
		if (personFile != null) {
			FileDemandeManager.saveDemandeDataToFile(personFile);
			return true;
		}

		return false;
	}

	@Override
	public void selectDemandeFileToSaveAs(Stage primaryStage) {


		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(primaryStage);

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			FileDemandeManager.saveDemandeDataToFile(file);
		}
		
	}

	@Override
	public Object validerIdentifiants(String login, String password) throws DAOException {
		return HibernateDao.getCurrentInstance().validateCredential( login,  password);
	}

	@Override
	public void associerService(Employe employe, Service service) throws DAOException {
		HibernateDao.getCurrentInstance().associateService( employe, service) ;
		
	}



/*
 * 
 * 
 * 
 * 
	@Override
	public void setDemandeList (List<Demande> demandes) {
		clearDemandeList ();
		getCurrentDemandeObservableList ().addAll (demandes);    
	}
	
		@Override
	public void setProduitList (List<Produit> produits) {
		clearProduitList ();
		getCurrentProduitObservableList ().addAll (produits);    
	}
	
		@Override
	public void setEmployeList (List<Employe> employes) {
		clearEmployeList ();
		getCurrentEmployeObservableList ().addAll (employes);    
	}
	
		@Override
	public void setServiceList (List<Service> services) {
		clearServiceList ();
		getCurrentServiceObservableList ().addAll (services);    
	}
		
		@Override
	public void setServiceList (List<Service> services) {
		clearServiceList ();
		getCurrentServiceObservableList ().addAll (services);    
	}
		
		@Override
	public void setServiceList (List<Service> services) {
		clearServiceList ();
		getCurrentServiceObservableList ().addAll (services);    
	}
	
	
 */
	

}