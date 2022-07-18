package com.rekest.controllers;

import com.rekest.utils.Utilitaire;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/***
 * MainController For gestionnaire Files
 * @author Fatoumata DICKO
 */
public class GestionnaireMainController  {

	private Stage primaryStage;
	private BorderPane rootLayout;

	// controllers
	private GestionnaireRootLayoutController gestionnaireRootLayoutController;
	private GestionnaireOverviewController gestionnaireOverviewController;

	/**
	 * 
	 * @param primaryStage
	 */
	public void initGestionnaireRootLayout(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setResizable(true);
		FXMLLoader loader = Utilitaire.initFXMLoader("GestionnaireRootLayout");
		rootLayout = (BorderPane) Utilitaire.loadFXMLFile(loader, true);
		Utilitaire.createScene(rootLayout, primaryStage, null);
		gestionnaireRootLayoutController = loader.getController();       
		gestionnaireRootLayoutController.setPrimaryStage(primaryStage);
		gestionnaireRootLayoutController.setRootLayout(rootLayout);
		Utilitaire.showStage(primaryStage);
	}

	/**
	 * Shows the Gestionnaire overview inside the root layout.
	 */
	public void showGestionnaireOverview() {
		Utilitaire.loadPageInRootLayout(rootLayout, "GestionnaireOverview");
		gestionnaireOverviewController = new GestionnaireOverviewController();
		gestionnaireOverviewController.setPrimaryStage(primaryStage);
	}

}