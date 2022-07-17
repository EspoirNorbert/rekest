package com.rekest.tests;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Departement;
import com.rekest.entities.Role;
import com.rekest.entities.Service;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;
import com.rekest.feature.impl.FeatureDepartement;
import com.rekest.observableList.impl.ObservableListDepartement;

import javafx.collections.ObservableList;


public class TestDataBase {

	public final static Logger logger = LogManager.getLogger(TestDataBase.class);
	
	public static void main_1(String[] args) {

		IDao dao = HibernateDao.getCurrentInstance();
		IFeature feature = FeatureDepartement.getInstance();
		ChefService chefService = new ChefService("BIPOMBO", "Espoir", "espoir-b", "passer");

		try {

			dao.save(chefService);
			Service serviceEntreprise = new Service ("Service Informatique");		
			dao.save(serviceEntreprise);

			Utilisateur utilisateur = new Utilisateur("AKINOCHO", "Ghislain");
			dao.save(utilisateur);

			Role gerant = new Role("Gerant system");
			Role superviseur = new Role("Superviseur system");
			dao.save(superviseur);
			dao.save(gerant);
			gerant.setIntitule("Nouvelle modification");
			dao.update(gerant);
			dao.delete(superviseur);

		
			dao.associateService(utilisateur, serviceEntreprise);
			Service infographie = new Service("Infographie");
			dao.associateService(utilisateur, infographie);
			dao.associateService(chefService, infographie);

			dao.enableAccount(utilisateur);
			dao.disableAccount(chefService);
			
			
			Administrateur seynabou = new Administrateur("Seynabou","Diagne");
			dao.save(seynabou);
			
			Feature.getCurrentInstance().initAllEntity();
			List<Departement> departments = feature.listerDepartements();
			
			for (Departement departement : departments) {
				logger.info(departement);
				System.out.println("Affichage du department " + departement.getNom());
				System.out.println(departement);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ObservableListDepartement obserlistDepart 
							= new ObservableListDepartement();
		
	}
	
	// Ajout d'un test de la recuperation de la liste des services en tant qu'observable
	public static void main_2(String[] args) {
		IDao dao = HibernateDao.getCurrentInstance();
		IFeature feature = Feature.getCurrentInstance();
		
		try {
			ObservableList<Service> services = feature.loadServicesObservableList();		
			for (Service service : services) {
				logger.info(service);
				System.out.println("Affichage du department " + service.getNom());
				System.out.println(service);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		logger.info(feature.getClass());
	}
}
