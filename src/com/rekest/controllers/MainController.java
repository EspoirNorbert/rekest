package com.rekest.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.utils.Utilitaire;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

	public final static Logger logger = LogManager.getLogger(MainController.class);

	private Stage primaryStage;
	private AuthenticationController authenticationController;

	public MainController() {
		logger.info("An instance of {} was created" , this);
	}

	public void initAuthentication(Stage primaryStage) {
		this.primaryStage = primaryStage;
		FXMLLoader loader =	Utilitaire.initFXMLoader("Authentication");
		AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);
		Utilitaire.createScene(root, primaryStage, "Rekest - Authentication");
		authenticationController = loader.getController();       
		authenticationController.setPrimaryStage(this.primaryStage);
		Utilitaire.showStage(this.primaryStage);
	}

}
