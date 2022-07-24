package com.rekest.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.javafaker.Faker;
import com.rekest.entities.Departement;
import com.rekest.entities.Produit;
import com.rekest.entities.Role;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Employe;
import com.rekest.entities.employes.Gestionnaire;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;
import com.rekest.utils.Utilitaire;

public class RekestData implements IRekestData {

	public final static Logger logger = LogManager.getLogger(RekestData.class);
	private IFeature feature = Feature.getCurrentInstance();
	private Faker faker = new Faker(Locale.FRENCH);
	
	private static RekestData instance = new RekestData();
	
	private RekestData() {
		logger.info("A RekestData instance was created");
	}
	
	public static RekestData getInstance() {
		if (instance == null) return new RekestData();
		return instance;
	}

	@Override
	public void initAdmins() {
		List<Administrateur> admins = new ArrayList<>();
		for (int i = 0; i <= 3; i++) {
			String lastName = faker.name().lastName();
			String firstName = faker.name().firstName();
			String phoneNumber = faker.phoneNumber().cellPhone();
			String email = faker.internet().emailAddress();
			String adresse = faker.address().fullAddress();
			admins.add(new Administrateur(lastName,firstName,phoneNumber, email, adresse));
		}
		// add defautl admin
		admins.add(Utilitaire.getDefaultAdmin());
		// For each admin in ArrayList we add in database
		admins.forEach(admin -> {
			logger.info("{}" , admin.getFullName());
			Boolean resultat = feature.creerUtilisateur(admin);
			if (resultat)
				logger.info("Admin {} was created successfully " , 
						admin.getNom() + " " + admin.getPrenom());
	
		});
	}

	@Override
	public void initEmployes() {
		List<Employe> employes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String lastName = faker.name().lastName();
			String firstName = faker.name().firstName();
			String phoneNumber = faker.phoneNumber().cellPhone();
			String email = faker.internet().emailAddress();
			String adresse = faker.address().fullAddress();
			employes.add(new Employe(lastName,firstName,phoneNumber, email, adresse));
		}
		// add defautl admin
		employes.add(Utilitaire.getDefaultAdmin());
		// For each admin in ArrayList we add in database
		employes.forEach(employe -> {
			logger.info("{}" , employe.getFullName());
			Boolean resultat = feature.creerEmploye(employe);
			if (resultat)
				logger.info("Admin {} was created successfully " , 
						employe.getNom() + " " + employe.getPrenom());
	
		});

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
			Boolean resultat = feature.creerUtilisateur(gestionnaire);
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
			Boolean resultat = feature.creerUtilisateur(chefService);
			if (resultat)
				logger.info("Departement {} was created successfully ", chefService.getFullName());
	
		});
	}

	@Override
	public void initChefDepartement() {}

	@Override
	public void initDirecteurGeneral() {}

	@Override
	public void initDirection() {
		
	}

	@Override
	public void createDefaultAdmin() {}

	@Override
	public void initDepartement() {
		List<Departement> departements = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			departements.add(new Departement(faker.commerce().department()));
		}
		// For each admin in ArrayList we add in database
		departements.forEach(departement -> {
			logger.info("{}" , departement.getNom());
			Boolean resultat = feature.creerDepartement(departement);
			if (resultat)
				logger.info("Departement {} was created successfully ", departement.getNom());
	
		});
	}

	@Override
	public void initService() {}

	@Override
	public void initRole() {
		Stream.of("ALL",  "LISTER" , "MODIFIER" , "SUPPRIMER")
		.forEach(roleName -> {
			logger.info("{}" ,roleName);
			Boolean resultat = feature.creerRole(new Role(roleName));
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
			Boolean resultat = feature.creerProduit(produit);
			if (resultat)
				logger.info("Produit {} was created successfully ", produit.getNom());
	
		});
	}

	@Override
	public void initDemande() {
		// TODO Auto-generated method stub
	}

}
