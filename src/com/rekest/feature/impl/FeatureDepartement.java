package com.rekest.feature.impl;

import java.util.ArrayList;
import java.util.List;

import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Departement;
import com.rekest.exeptions.DAOException;
import com.rekest.feature.IFeature;

public class FeatureDepartement implements IFeature {

	private static FeatureDepartement instance = null;
	private IDao dao;
	
	private FeatureDepartement () {
		dao = HibernateDao.getCurrentInstance();
	}

	public static FeatureDepartement getCurrentInstance  () {
		if (instance == null) instance = new FeatureDepartement ();
		return instance;
	}
	
	@Override
	public List<Departement> listerDepartements () throws DAOException   {

		List<Object> objects = dao.list ( Departement.class);
		List<Departement> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if  (obj instanceof Departement) {
				objs.add ( (Departement) obj);
			}
		}
		
		return objs;
	}

	@Override
	public List<Departement> listerDepartements (String whereClause) throws DAOException  {

		List<Object> objects = dao.list ( Departement.class, whereClause);
		List<Departement> objs = new ArrayList<> ();
		for  (Object obj : objects) {
			if  (obj instanceof Departement) {
				objs.add (  (Departement) obj);
			}
		}
		
		return objs;
		
	}

	@Override
	public void supprimerDepartement (Departement departement) throws DAOException {
		
		  dao.delete ( departement);
		
	}

	@Override
	public void modifierDepartement (Departement departement) throws DAOException {
		
		  dao.update ( departement);
	}

	@Override
	public void creerDepartement (Departement departement) throws DAOException  {

		  dao.save ( departement);
		
	}

	@Override
	public Departement rechercherDepartement (String whereClause) throws DAOException {
		
		return   (Departement) dao.find ( Departement.class, whereClause);
	}

	@Override
	public Departement rechercherDepartement (Integer primaryKey) throws DAOException  {

		Departement dep   = new Departement();
		return   (Departement) dao.find ( dep, primaryKey);
	}

}
