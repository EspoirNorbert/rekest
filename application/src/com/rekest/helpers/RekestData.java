package com.rekest.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.github.javafaker.Faker;
import com.rekest.entities.Departement;
import com.rekest.entities.Produit;
import com.rekest.entities.Role;
import com.rekest.controllers.impl.AdminRootLayoutController;
import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Service;

import com.rekest.entities.employes.Administrateur;

import com.rekest.entities.employes.ChefService;

import com.rekest.entities.employes.ChefDepartement;
import com.rekest.entities.employes.Directeur;
import com.rekest.entities.employes.DirecteurGeneral;

import com.rekest.entities.employes.Employe;

import com.rekest.entities.employes.Gestionnaire;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;

import com.rekest.exeptions.DAOException;

import com.rekest.utils.Utilitaire;

public class RekestData implements IRekestData {

	public final static Logger logger = LogManager.getLogger(AdminRootLayoutController.class);

	private static IDao dao = HibernateDao.getCurrentInstance();

	private Faker faker = new Faker();

	private IFeature feature = Feature.getCurrentInstance();

	@Override
	public void initAdmins() {
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
	public Administrateur createDefaultAdmin() {
		Administrateur admin =  new Administrateur("Administrator", "System", "+221771234500", "rekest.app@rekest.sn",
				"Terrain foyer Rocade Fann Bel Air, BP 10 000 Dakar Liberté – SENEGAL");
		admin.setLogin("admin");
		admin.setPassword("admin");
		return admin;
	}

	@Override
	public void initEmployes() {
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
	public void initGestionnaire() {
		List<Gestionnaire> gestionnaires = new ArrayList<>();
		for (int i = 0; i <=1; i++) {
			gestionnaires.add(new Gestionnaire(faker.name().firstName(), 
					faker.name().lastName(),
					faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), faker.address().fullAddress()));

		}
		// For each admin in ArrayList we add in database
		gestionnaires.forEach(gestionnaire -> {
			logger.info("{}" , gestionnaire.getFullName());
			Boolean resultat = feature.createUtilisateur(gestionnaire);
			if (resultat)
				logger.info("Departement {} was created successfully ", gestionnaire.getFullName());

		});
	}

	@Override
	public void initChefServices() {
		List<ChefService> chefServices = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			chefServices.add(new ChefService(faker.name().firstName(), 
					faker.name().lastName(),
					faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), faker.address().fullAddress()));

		}
		// For each admin in ArrayList we add in database
		chefServices.forEach(chefService -> {
			logger.info("{}" , chefService.getFullName());
			Boolean resultat = feature.createUtilisateur(chefService);
			if (resultat)
				logger.info("Departement {} was created successfully ", chefService.getFullName());

		});

	}

	@Override
	public void initChefDepartement() {}


	@Override
	public void initDirecteurGeneral() {	}

	@Override
	public void initDirection() {}


	@Override
	public void initDepartement() {
		List<Departement> departements = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			departements.add(new Departement(faker.commerce().department()));
		}
		// For each admin in ArrayList we add in database
		departements.forEach(departement -> {
			logger.info("{}" , departement.getNom());
			Boolean resultat = feature.createDepartement(departement);
			if (resultat)
				logger.info("Departement {} was created successfully ", departement.getNom());

		});
	}


	@Override
	public void initService() {
		try {
			for (int i = 0; i <= 10; i++) {
				ChefService chefService = new ChefService(faker.name().firstName(), faker.name().lastName(),
						faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), faker.address().fullAddress());	
				Utilitaire.generateLoginAndPassword(chefService);
				dao.save(chefService);

				ChefDepartement chefDefpartement = new ChefDepartement(faker.name().firstName(), faker.name().lastName(),
						faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), faker.address().fullAddress());	
				Utilitaire.generateLoginAndPassword(chefDefpartement);
				dao.save(chefDefpartement);

				Departement department = 
						new Departement(faker.commerce().department());

				Service service = new Service(faker.commerce().department());

				service.setChefService(chefService);
				dao.save(service);

				department.addService(service);
				department.setChefDepartement(chefDefpartement);
				dao.save(department);

			}
		} catch (DAOException e) {
			System.err.println(e.getMessage());
		}
	}



	@Override
	public void initRole() {
		Stream.of("ALL",  "LISTER" , "MODIFIER" , "SUPPRIMER")
		.forEach(roleName -> {
			logger.info("{}" ,roleName);
			Boolean resultat = feature.createRole(new Role(roleName));
			if (resultat)
				logger.info("Role {} was created successfully ", roleName);
		});
	}

	@Override
	public void initProduit() {
		List<Produit> produits = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			produits.add(new Produit(faker.commerce().productName(), 
					Integer.parseInt(faker.commerce().price().replace(",", "")), 
					new Random().nextInt() * 2));
		}
		// For each admin in ArrayList we add in database
		produits.forEach(produit -> {
			logger.info("{}" , produit.getNom());
			Boolean resultat = feature.createProduit(produit);
			if (resultat)
				logger.info("Produit {} was created successfully ", produit.getNom());

		});
	}

	@Override
	public void initDemande() {}

	@Override
	public void initManagers() {
		try {
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
	public void initAllEntity() {
		this.initAdmins();
		this.initEmployes();
		this.initManagers();
		this.initDepartement();
		this.initService();
	}


}
