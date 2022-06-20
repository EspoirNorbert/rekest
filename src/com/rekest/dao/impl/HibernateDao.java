package com.rekest.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.dao.IDao;
import com.rekest.utils.HibernateSession;

public class HibernateDao implements IDao {

	public final static Logger logger = LogManager.getLogger(HibernateDao.class);
	
	/*private static Session session = null;
	  private static Transaction transaction = null;
	*/
	private static HibernateDao daoInstance = null;
	
	private HibernateDao() {}

	public static HibernateDao getCurrentInstance () {
		if (daoInstance == null) daoInstance = new HibernateDao();
		return daoInstance;
	}

	
	public static void closeSession() {
		HibernateSession.close();		
	}

}