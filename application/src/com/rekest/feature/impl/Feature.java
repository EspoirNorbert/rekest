package com.rekest.feature.impl;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Departement;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Directeur;
import com.rekest.entities.employes.DirecteurGeneral;
import com.rekest.entities.employes.Employe;
import com.rekest.exeptions.DAOException;
import com.rekest.feature.IFeature;
import com.rekest.utils.Utilitaire;

public class Feature implements IFeature {

	private static IDao dao = HibernateDao.getCurrentInstance();
	private static IFeature instance = new Feature();
	private static Faker faker = new Faker(Locale.FRANCE);

	private Feature() {
	}

	public static IFeature getCurrentInstance() {
		return instance;
	}

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
						faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), faker.address().fullAddress(),
						null);
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
}