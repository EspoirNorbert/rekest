package com.rekest.controllers.impl;

import java.net.URL;
import java.util.ResourceBundle;

import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;
//import com.rekest.feature.IFeature;
//import com.rekest.feature.impl.Feature;
import com.rekest.utils.Utilitaire;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AdminOverviewController implements Initializable {

	@FXML
	private Label countDemandes;

	@FXML
	private Label countDepartements;

	@FXML
	private Label countEmployes;

	@FXML
	private Label countProduits;

	@FXML
	private Label countRoles;

	@FXML
	private Label countServices;
	
	private Stage primaryStage;
	
	private IFeature service = Feature.getCurrentInstance();
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.refreshEntitiesCounter();
	}
	 		
	private void initEntiesCounter() {
		/***
		 * 0 seront remplacer par Service.getTotal
		 */
		Utilitaire.setLabel(countDemandes, 
				service.getNumberDemandes().toString() /*"0"*/);
		Utilitaire.setLabel(countDepartements, 
				service.getNumberDepartements().toString() /* "0"*/);
		Utilitaire.setLabel(countEmployes, service.getNumberEmployes().toString() /* "0"*/);
		Utilitaire.setLabel(countProduits, service.getNumberProduits().toString() /* "0"*/);
		Utilitaire.setLabel(countRoles,service.getNumberRoles().toString());
		Utilitaire.setLabel(countServices, service.getNumberServices().toString() /* "0"*/);
	}
	
	private void refreshEntitiesCounter() {
		this.initEntiesCounter();
	}
	
	
}
