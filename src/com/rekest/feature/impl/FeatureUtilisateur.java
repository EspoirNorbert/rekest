package com.rekest.feature.impl;

import java.util.ArrayList;
import java.util.List;

import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exeption.DAOException;
import com.rekest.feature.IFeatureUtilisateur;
import com.rekest.utils.HibernateSession;

public class FeatureUtilisateur implements IFeatureUtilisateur {

	private static FeatureUtilisateur instance = null;
	
	private FeatureUtilisateur () {}

	public static FeatureUtilisateur getCurrentInstance  () {
		if  (instance == null) instance = new FeatureUtilisateur ();
		return instance;
	}
	
	@Override
	public void activerUtilisateur  (Utilisateur utilisateur) throws Exception {
		
		HibernateDao.getCurrentInstance ().enableAccount (utilisateur);
	
		
	}

	@Override
	public void desactiverUtilisateur  (Utilisateur utilisateur) throws Exception {
		
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
	public List<Utilisateur> listerUtilisateurs () throws Exception {

		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Utilisateur.class);
		List<Utilisateur> objs = new ArrayList<> ();
		for  (Object obj : objects) {
			if  (obj instanceof Utilisateur) {
				objs.add ( (Utilisateur) obj);
			}
		}
		
		return objs;
	}

	@Override
	public List<Utilisateur> listerUtilisateurs (String whereClause) throws Exception{
		
		List<Object> objects = HibernateDao.getCurrentInstance ().list ( Utilisateur.class, whereClause);
		List<Utilisateur> objs = new ArrayList<> ();
		for  (Object obj : objects) {
			if  (obj instanceof Utilisateur) {
				objs.add ( (Utilisateur) obj);
			}
		}
		
		return objs;
	}

	@Override
	public void supprimerUtilisateur (Utilisateur utilisateur) throws Exception {
		 HibernateDao.getCurrentInstance ().delete ( utilisateur);
		
	}

	@Override
	public void modifierUtilisateur (Utilisateur utilisateur) throws Exception {

		HibernateDao.getCurrentInstance ().update ( utilisateur);
	}

	@Override
	public void creerUtilisateur (Utilisateur utilisateur) throws Exception {
	
		HibernateDao.getCurrentInstance ().save ( utilisateur);
		
	}


	@Override
	public Utilisateur rechercherUtilisateur (String whereClause) throws Exception {
		
		return  (Utilisateur) HibernateDao.getCurrentInstance ().find (  Utilisateur.class, whereClause);
	}

	@Override
	public Utilisateur rechercherUtilisateur (Integer primaryKey) throws Exception{
		
		Utilisateur user = new Utilisateur( null, null, null, null);
		return  (Utilisateur) HibernateDao.getCurrentInstance ().find ( user , primaryKey);
	}

	@Override
	public String getTheDaoImplementationClassname () {
		// TODO Auto-generated method stub
		return null;
	}

}
