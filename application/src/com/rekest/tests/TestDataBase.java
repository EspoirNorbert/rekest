package com.rekest.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.feature.impl.RekestData;


public class TestDataBase {

	public final static Logger logger = LogManager.getLogger(TestDataBase.class);

	public static void main(String[] args) {
		RekestData.getInstance().initAdmins();
	}
	
	
}
