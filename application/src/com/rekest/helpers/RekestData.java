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


public class RekestData implements IRekestData {

	public final static Logger logger = LogManager.getLogger(AdminRootLayoutController.class);

	private static IDao dao = HibernateDao.getCurrentInstance();

	private Faker faker = new Faker();

	private IFeature feature = Feature.getCurrentInstance();

	@Override
	public void initAdmins() {
		Administrateur defaultAdmin = createDefaultAdmin();
		feature.createUtilisateur(defaultAdmin);
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
	public void initEmployes() {}


	@Override
	public void initGestionnaire() {}

	@Override
	public void initChefServices() {}

	@Override
	public void initChefDepartement() {}


	@Override
	public void initDirecteurGeneral() {	}

	@Override
	public void initDirection() {}


	@Override
	public void initDepartement() {}


	@Override
	public void initService() {}



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
	public void initProduit() {}

	@Override
	public void initDemande() {}

	@Override
	public void initManagers() {}

	@Override
	public void initAllEntity() {
		this.initAdmins();
		this.initRole();
	}


}
