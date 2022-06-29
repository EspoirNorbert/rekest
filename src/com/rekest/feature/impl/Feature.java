package com.rekest.feature.impl;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Departement;
import com.rekest.exeptions.DAOException;

public class Feature  {
	
	private static IDao dao =  HibernateDao.getCurrentInstance();
	private static Feature instance = new Feature();
	private static Faker faker = new Faker(Locale.FRANCE);
	
	private Feature() {}
	
	public static Feature getCurrentInstance  () {
		if (instance == null) instance = new Feature ();
		return instance;
	}
	
	public static void initDepartement() {
		try {
			for (int i = 0; i <= 10; i++) {
					Departement department = new Departement(faker.commerce().department());
					dao.save(department);
				}
		} catch (DAOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void initService() {}
	
	public static void initRole() {}
	
	public static void initProduit() {}
	
	public static void initEmploye() {}
	
}