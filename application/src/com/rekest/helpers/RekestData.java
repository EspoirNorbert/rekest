package com.rekest.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.javafaker.Faker;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;

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
		List<Utilisateur> findAdmins = 
			feature.listerUtilisateurs("where employe_profil = 'Administrateur'");
		logger.info(findAdmins.size());
		return ;
		/*
		if (feature.listerUtilisateurs("where employe_profil = 'Administrateur'").isEmpty()) {
			for (int i = 0; i <= 3; i++) {
				String lastName = faker.name().lastName();
				String firstName = faker.name().firstName();
				String phoneNumber = faker.phoneNumber().cellPhone();
				String email = faker.internet().emailAddress();
				String adresse = faker.address().fullAddress();
				admins.add(new Administrateur(lastName,firstName,phoneNumber, email, adresse));
			}
			// For each admin in ArrayList we add in database
			admins.forEach(admin -> {
				logger.info("{}" , admin.getNom());
				Boolean resultat = feature.creerUtilisateur(admin);
				if (resultat)
					logger.info("Admin {} was created successfully " , 
							admin.getNom() + " " + admin.getPrenom());
		
			});
		}
		*/
	}

	@Override
	public void initEmployes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initGestionnaire() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initChefServices() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initChefDepartement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initDirecteurGeneral() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initDirection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createDefaultAdmin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initDepartement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initService() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initRole() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initProduit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initDemande() {
		// TODO Auto-generated method stub
	}

}
