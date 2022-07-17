package com.rekest.feature.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Demande;
import com.rekest.entities.Departement;
import com.rekest.entities.Note;
import com.rekest.entities.Produit;
import com.rekest.entities.Role;
import com.rekest.entities.Service;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Directeur;
import com.rekest.entities.employes.DirecteurGeneral;
import com.rekest.entities.employes.Employe;
import com.rekest.entities.employes.Manager;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exeptions.DAOException;
import com.rekest.feature.IFeature;
import com.rekest.observableList.impl.ObservableListDemande;
import com.rekest.observableList.impl.ObservableListDepartement;
import com.rekest.observableList.impl.ObservableListEmploye;
import com.rekest.observableList.impl.ObservableListManager;
import com.rekest.observableList.impl.ObservableListNote;
import com.rekest.observableList.impl.ObservableListProduit;
import com.rekest.observableList.impl.ObservableListRole;
import com.rekest.observableList.impl.ObservableListService;
import com.rekest.observableList.impl.ObservableListUtilisateur;
import com.rekest.utils.Utilitaire;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;

public class Feature implements IFeature {

	private static Feature instance = null;
	private static IDao dao = HibernateDao.getCurrentInstance();
	
	private ObservableListDepartement observableListDepartement;
	private ObservableListEmploye observableListEmploye ;
	private ObservableListProduit observableListProduit ;
	private ObservableListService observableListService ;
	private ObservableListRole observableListRole;
	private ObservableListDemande observableListDemande ;
	private ObservableListManager observableListManager ;
	private ObservableListNote observableListNote ;
	private ObservableListUtilisateur observableListUtilisateur;

	
	private Feature () {
		observableListDepartement = new ObservableListDepartement();
		observableListEmploye = new ObservableListEmploye();
		observableListProduit = new ObservableListProduit();
		observableListService = new ObservableListService();
		observableListRole = new ObservableListRole();
		observableListDemande = new ObservableListDemande();
		observableListManager = new ObservableListManager();
		observableListNote = new ObservableListNote();
		observableListUtilisateur = new ObservableListUtilisateur();
	}

	public static Feature getCurrentInstance () {
		if (instance == null) instance = new Feature ();
		return instance;
	}
	
	private Faker faker = new Faker();


	@Override
	public void initDepartement() {
		try {
			for (int i = 0; i <= 10; i++) {
				Departement department = 
						new Departement(faker.commerce().department());
				dao.save(department);
			}
		} catch (DAOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void initEmploye() {
		try {
			for (int i = 0; i <= 10; i++) {
				Employe employe = new Employe(
						faker.name().lastName(),
						faker.name().firstName(),
						faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), faker.address().fullAddress());
				dao.save(employe);
			}
		} catch (DAOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void initAdmin() {
		try {
			dao.save(createDefaultAdmin());
			for (int i = 0; i <= 3; i++) {
				Administrateur admin = new Administrateur(
						 faker.name().lastName(),
						 faker.name().firstName(),
						faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), faker.address().fullAddress());

				dao.save(admin);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initManagers() {
		try {
			// List<Manager> managers = new ArrayList<>();
			for (int i = 0; i <= 10; i++) {
				ChefService chefService = new ChefService(faker.name().firstName(), faker.name().lastName(),
						faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), faker.address().fullAddress());
				Utilitaire.generateLoginAndPassword(chefService);
				dao.save(chefService);
				Directeur directeur = new Directeur(faker.name().firstName(), faker.name().lastName(),
						faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), faker.address().fullAddress());
				Utilitaire.generateLoginAndPassword(directeur);
				dao.save(directeur);
				DirecteurGeneral directeurGeneral = new DirecteurGeneral(faker.name().firstName(),
						faker.name().lastName(), faker.phoneNumber().cellPhone(), faker.internet().emailAddress(),
						faker.address().fullAddress());
				Utilitaire.generateLoginAndPassword(directeurGeneral);
				dao.save(directeur);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Administrateur createDefaultAdmin() {
		Administrateur admin =  new Administrateur("Administrator", "System", "+221771234500", "rekest.app@rekest.sn",
				"Terrain foyer Rocade Fann Bel Air, BP 10 000 Dakar Liberté – SENEGAL");
		admin.setLogin("admin");
		admin.setPassword("admin");
		return admin;
	}

	@Override
	public void initAllEntity() {
		this.initAdmin();
		this.initEmploye();
		this.initManagers();
		this.initDepartement();
	}
	
	
	public ObservableListDemande getObservableListDemande() {
		return observableListDemande;
	}
	
	public ObservableListDepartement getObservableListDepartement() {
		return observableListDepartement;
	}
	
	public ObservableListEmploye getObservableListEmploye() {
		return observableListEmploye;
	}
	
	public ObservableListManager getObservableListManager() {
		return observableListManager;
	}
	
	public ObservableListNote getObservableListNote() {
		return observableListNote;
	}
	
	public ObservableListProduit getObservableListProduit() {
		return observableListProduit;
	}
	
	public ObservableListRole getObservableListRole() {
		return observableListRole;
	}
	
	public ObservableListService getObservableListService() {
		return observableListService;
	}
	
	public ObservableListUtilisateur getObservableListUtilisateur() {
		return observableListUtilisateur;
	}


	@Override
	public List<Departement> listerDepartements ()   {

		List<Object> objects =  null;
		List<Departement> departements = new ArrayList<> ();
		try {
			objects = dao.list ( new Departement());

			for (Object obj : objects) {
				if (obj instanceof Departement) {
					departements.add ( (Departement) obj);
				}
			}
		} catch (DAOException e) {
			Utilitaire.alert(AlertType.ERROR, null,
					"Error", e.getClass() +
					"Error while get departements",
					e.getMessage());
			e.printStackTrace();
		}
		return departements;
	}

	@Override
	public List<Departement> listerDepartements (String whereClause)  {

		List<Object> objects;
		List<Departement> objs = new ArrayList<> ();
		try {
			objects = dao.list ( Departement.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Departement) {
					objs.add ( (Departement) obj);
				}
			}
		} catch (DAOException e) {
			Utilitaire.alert(AlertType.ERROR, null,
					"Error", e.getClass() +
					"Error while get departements",
					e.getMessage());
			e.printStackTrace();
		}

		return objs;
	}

	@Override
	public boolean supprimerDepartement (Departement departement)   {
		try {
			dao.delete ( departement);
			loadDepartementsObservableList();
			return true;
		} catch (DAOException e) {
			Utilitaire.alert(AlertType.ERROR, null,
					"Error", e.getClass() +
					"Error while delete an",
					e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean modifierDepartement (Departement departement)   {

		try {
			dao.update ( departement);
			loadDepartementsObservableList();
			return true;
		} catch (DAOException e) {
			Utilitaire.alert(AlertType.ERROR, null,
					"Error", e.getClass() +
					"Error while edit department",
					e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerDepartement (Departement departement)   {

		try {
			dao.save ( departement);
			loadDepartementsObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}



	@Override
	public Departement rechercherDepartement (String whereClause)   {

		try {
			return (Departement) dao.find (  Departement.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Departement rechercherDepartement (Integer primaryKey)  {
		try {
			return (Departement) dao.find ( new Departement ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public boolean activerUtilisateur (Utilisateur utilisateur)   {

		try {
			dao.enableAccount (utilisateur);
			loadUtilisateursObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean desactiverUtilisateur (Utilisateur utilisateur)   {

		try {
			dao.disableAccount (utilisateur);
			loadUtilisateursObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/*
	@Override
	public boolean rafraichirUtilisateur (Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return dao.;
	}
	 */

	@Override
	public List<Utilisateur> listerUtilisateurs ()   {

		List<Object> objects;
		List<Utilisateur> objs = new ArrayList<> ();
		try {
			objects = dao.list ( new Utilisateur());

			for (Object obj : objects) {
				if (obj instanceof Utilisateur) {
					objs.add ( (Utilisateur) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Utilisateur> listerUtilisateurs (String whereClause)  {

		List<Object> objects;
		List<Utilisateur> objs = new ArrayList<> ();
		try {
			objects = dao.list ( Utilisateur.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Utilisateur) {
					objs.add ( (Utilisateur) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return objs;
	}

	@Override
	public boolean supprimerUtilisateur (Utilisateur utilisateur)   {
		try {
			dao.delete ( utilisateur);
			loadUtilisateursObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean modifierUtilisateur (Utilisateur utilisateur)   {

		try {
			dao.update ( utilisateur);
			loadUtilisateursObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerUtilisateur (Utilisateur utilisateur)   {

		try {
			dao.save ( utilisateur);
			loadUtilisateursObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}



	@Override
	public Utilisateur rechercherUtilisateur (String whereClause)   {

		try {
			return (Utilisateur) dao.find (  Utilisateur.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur rechercherUtilisateur (Integer primaryKey)  {
		try {
			return (Utilisateur) dao.find ( new Utilisateur ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Role> listerRoles ()   {

		List<Object> objects;
		List<Role> objs = new ArrayList<> ();
		try {
			objects = dao.list ( new Role());

			for (Object obj : objects) {
				if (obj instanceof Role) {
					objs.add ( (Role) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Role> listerRoles (String whereClause)  {

		List<Object> objects;
		List<Role> objs = new ArrayList<> ();
		try {
			objects = dao.list ( Role.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Role) {
					objs.add ( (Role) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return objs;
	}

	@Override
	public boolean supprimerRole (Role role)   {
		try {
			dao.delete ( role);
			loadRoleObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean modifierRole (Role role)   {

		try {
			dao.update ( role);
			loadRoleObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerRole (Role role)   {

		try {
			dao.save ( role);
			loadRoleObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}



	@Override
	public Role rechercherRole (String whereClause)   {

		try {
			return (Role) dao.find (  Role.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Role rechercherRole (Integer primaryKey)  {
		try {
			return (Role) dao.find ( new Role ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Manager> listerManagers ()   {

		List<Object> objects;
		List<Manager> objs = new ArrayList<> ();
		try {
			objects = dao.list ( new Manager());

			for (Object obj : objects) {
				if (obj instanceof Manager) {
					objs.add ( (Manager) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Manager> listerManagers (String whereClause)  {

		List<Object> objects;
		List<Manager> objs = new ArrayList<> ();
		try {
			objects = dao.list ( Manager.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Manager) {
					objs.add ( (Manager) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public boolean supprimerManager (Manager manager)   {
		try {
			dao.delete ( manager);
			loadManagerObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean modifierManager (Manager manager)   {

		try {
			dao.update ( manager);
			loadManagerObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerManager (Manager manager)   {

		try {
			dao.save ( manager);
			loadManagerObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}



	@Override
	public Manager rechercherManager (String whereClause)   {

		try {
			return (Manager) dao.find (  Manager.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Manager rechercherManager (Integer primaryKey)  {
		try {
			return (Manager) dao.find ( new Manager ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employe> listerEmployes ()   {

		List<Object> objects;
		List<Employe> objs = new ArrayList<> ();
		try {
			objects = dao.list ( new Employe());

			for (Object obj : objects) {
				if (obj instanceof Employe) {
					objs.add ( (Employe) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Employe> listerEmployes (String whereClause)  {

		List<Object> objects;
		List<Employe> objs = new ArrayList<> ();
		try {
			objects = dao.list ( Employe.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Employe) {
					objs.add ( (Employe) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return objs;
	}

	@Override
	public boolean supprimerEmploye (Employe employe)   {
		try {
			dao.delete ( employe);
			loadEmployesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			System.err.println("BLEM EMPLOYE");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean modifierEmploye (Employe employe)   {

		try {
			dao.update ( employe);
			loadEmployesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerEmploye (Employe employe)   {

		try {
			dao.save ( employe);
			loadEmployesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}



	@Override
	public Employe rechercherEmploye (String whereClause)   {

		try {
			return (Employe) dao.find (  Employe.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employe rechercherEmploye (Integer primaryKey)  {
		try {
			return (Employe) dao.find ( new Employe ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Service> listerServices ()   {

		List<Object> objects;
		List<Service> objs = new ArrayList<> ();
		try {
			objects = dao.list ( new Service());

			for (Object obj : objects) {
				if (obj instanceof Service) {
					objs.add ( (Service) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Service> listerServices (String whereClause)  {

		List<Object> objects;
		List<Service> objs = new ArrayList<> ();
		try {
			objects = dao.list ( Service.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Service) {
					objs.add ( (Service) obj);
				}
			}

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return objs;
	}

	@Override
	public boolean supprimerService (Service service)   {
		try {
			dao.delete ( service);
			loadServicesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean modifierService (Service service)   {

		try {
			dao.update ( service);
			loadServicesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerService (Service service)   {

		try {
			dao.save ( service);
			loadServicesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}



	@Override
	public Service rechercherService (String whereClause)   {

		try {
			return (Service) dao.find (  Service.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Service rechercherService (Integer primaryKey)  {
		try {
			return (Service) dao.find ( new Service ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Produit> listerProduits ()   {

		List<Object> objects;
		List<Produit> objs = new ArrayList<> ();
		try {
			objects = dao.list ( new Produit());

			for (Object obj : objects) {
				if (obj instanceof Produit) {
					objs.add ( (Produit) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Produit> listerProduits (String whereClause)  {

		List<Object> objects;
		List<Produit> objs = new ArrayList<> ();
		try {
			objects = dao.list ( Produit.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Produit) {
					objs.add ( (Produit) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return objs;
	}

	@Override
	public boolean supprimerProduit (Produit produit)   {
		try {
			dao.delete ( produit);
			loadProduitsObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean modifierProduit (Produit produit)   {

		try {
			dao.update ( produit);
			loadProduitsObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerProduit (Produit produit)   {

		try {
			dao.save ( produit);
			loadProduitsObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}



	@Override
	public Produit rechercherProduit (String whereClause)   {

		try {
			return (Produit) dao.find (  Produit.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Produit rechercherProduit (Integer primaryKey)  {
		try {
			return (Produit) dao.find ( new Produit ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Note> listerNotes ()    {
		Note truc = new Note();
		List<Note> objs = new ArrayList<> ();
		List<Object> objects;
		try {
			objects = dao.list ( truc);
			for  (Object obj : objects) {
				if  (obj instanceof Note) {
					objs.add (  (Note) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return objs;
	}

	@Override
	public List<Note> listerNotes (String whereClause)   {

		List<Object> objects;
		List<Note> objs = new ArrayList<> ();
		try {
			objects = dao.list ( Note.class, whereClause);
			for  (Object obj : objects) {
				if  (obj instanceof Note) {
					objs.add (  (Note) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;

	}

	@Override
	public boolean supprimerNote (Note note)   {

		try {
			dao.delete ( note);
			loadNoteObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}

	@Override
	public boolean modifierNote (Note note)   {

		try {
			dao.update ( note);
			loadNoteObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean creerNote (Note note)   {

		try {
			dao.save ( note); 
			loadNoteObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Note rechercherNote (String whereClause)   {

		try {
			return   (Note) dao.find ( Note.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Note rechercherNote (Integer primaryKey)   {


		try {
			return   (Note) dao.find ( new Note(), primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Demande> listerDemandes ()    {

		List<Demande> objs = new ArrayList<> ();
		List<Object> objects;
		try {
			objects = dao.list ( new Demande());
			for  (Object obj : objects) {
				if  (obj instanceof Demande) {
					objs.add (  (Demande) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return objs;
	}

	@Override
	public List<Demande> listerDemandes (String whereClause)   {

		List<Object> objects;
		List<Demande> objs = new ArrayList<> ();
		try {
			objects = dao.list ( Demande.class, whereClause);

			for  (Object obj : objects) {
				if  (obj instanceof Demande) {
					objs.add (  (Demande) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return objs;

	}

	@Override
	public boolean supprimerDemande (Demande demande)   {

		try {
			dao.delete ( demande);
			loadDemandesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean modifierDemande (Demande demande)   {

		try {
			dao.update ( demande);
			loadDemandesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerDemande (Demande demande)   {
		try {
			dao.save ( demande);
			loadDemandesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public Demande rechercherDemande (String whereClause)   {
		try {
			return   (Demande) dao.find ( Demande.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Demande rechercherDemande (Integer primaryKey)   {

		try {
			return   (Demande) dao.find ( new Demande(), primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getTheDaoImplementationClassname () {
		return null;
	}


	@Override
	public Integer RetournerNombreDemandesTotal () {
		return listerDemandes().size();
	}

	@Override
	public Integer RetournerNombreEmployesTotal () {
		return listerEmployes().size();
	}

	@Override
	public Integer RetournerNombreDepartementsTotal () {
		return listerDepartements().size();
	}

	@Override
	public Integer RetournerNombreServicesTotal () {
		return listerServices().size();
	}

	@Override
	public Integer RetournerNombreProduitsTotal () {
		return listerProduits().size();
	}

	@Override
	public ObservableList<Role> loadRoleObservableList()   {
		try {
			observableListRole.clear();
			observableListRole.addAll(  dao.list ( new Role() ));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return observableListRole.getData();
	}

	@Override
	public ObservableList<Produit> loadProduitsObservableList()   {

		try {
			observableListProduit.clear();
			observableListProduit.addAll(  dao.list ( new Produit() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return observableListProduit.getData();

	}

	@Override
	public ObservableList<Service> loadServicesObservableList()   {

		try {
			observableListService.clear();
			observableListService.addAll(  dao.list ( new Service() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return observableListService.getData();
	}

	@Override
	public ObservableList<Departement> loadDepartementsObservableList()   {


		try {
			observableListDepartement.clear();
			observableListDepartement.addAll(  dao.list ( new Departement() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return observableListDepartement.getData();
	}

	@Override
	public ObservableList<Demande> loadDemandesObservableList ()  {

		try {
			observableListDemande.clear();
			observableListDemande.addAll(  dao.list ( new Demande() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return observableListDemande.getData();
	}

	@Override
	public ObservableList<Employe> loadEmployesObservableList ()  {

		try {
			observableListEmploye.clear();
			observableListEmploye.addAll(  dao.list ( new Employe() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return observableListEmploye.getData();
	}


	@Override
	public ObservableList<Demande> loadDemandesByServiceObservableList (Service service)  {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ObservableList<Demande> loadDemandesByDirectionObservableList (Object direction)   {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ObservableList<Manager> loadManagerObservableList() {

		try {
			observableListManager.clear();
			observableListManager.addAll(  dao.list ( new Manager() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return observableListManager.getData();
	}

	@Override
	public ObservableList<Note> loadNoteObservableList() {

		try {
			observableListNote.clear();
			observableListNote.addAll(  dao.list ( new Note() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return observableListNote.getData();
	}

	@Override
	public ObservableList<Utilisateur> loadUtilisateursObservableList() {

		try {
			observableListUtilisateur.clear();
			observableListUtilisateur.addAll(  dao.list ( new Utilisateur() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return observableListUtilisateur.getData();
	}
	@Override
	public boolean repondreDemande (Demande demande, String reponse)    {
		try {
			dao.requestResponse (demande, reponse);
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public Object validerIdentifiants(String login, String password)   {

		Object obj = new Object();

		try {
			obj = HibernateDao.getCurrentInstance().validateCredential( login,  password);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean associerService(Employe employe, Service service)   {

		try {
			HibernateDao.getCurrentInstance().associateService( employe, service) ;
			loadEmployesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * 
	 * 
	 * 
	 * 
	@Override
	public boolean setDemandeList (List<Demande> demandes) {
		clearDemandeList ();
		getCurrentDemandeObservableList ().addAll (demandes);    
	}

		@Override
	public boolean setProduitList (List<Produit> produits) {
		clearProduitList ();
		getCurrentProduitObservableList ().addAll (produits);    
	}

		@Override
	public boolean setEmployeList (List<Employe> employes) {
		clearEmployeList ();
		getCurrentEmployeObservableList ().addAll (employes);    
	}

		@Override
	public boolean setServiceList (List<Service> services) {
		clearServiceList ();
		getCurrentServiceObservableList ().addAll (services);    
	}

		@Override
	public boolean setServiceList (List<Service> services) {
		clearServiceList ();
		getCurrentServiceObservableList ().addAll (services);    
	}

		@Override
	public boolean setServiceList (List<Service> services) {
		clearServiceList ();
		getCurrentServiceObservableList ().addAll (services);    
	}
	 */


}
