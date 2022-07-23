package com.rekest.controllers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.controllers.IController;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.utils.PropertyManager;
import com.rekest.utils.Utilitaire;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {


	/** Loggers*/
	public final static Logger logger = LogManager.getLogger(MainController.class);
	private static MainController instance = new MainController();

	/**
	 * Attributes
	*/
	private BorderPane rootLayout;
	private PropertyManager propertyManager;
	
	/**
	 * Controllers
	 */
	private AppMainWindowController appMainWindowController;
	private AuthenticationController authenticationController;
	private AdminRootLayoutController adminRootLayoutController;
	private ManagerRootLayoutController managerRootLayoutController;
	private GestionnaireRootLayoutController gestionnaireRootLayoutController;

	private MainController() {
		propertyManager = PropertyManager.getInstance();
		adminRootLayoutController = new AdminRootLayoutController();
		managerRootLayoutController = new ManagerRootLayoutController();
		gestionnaireRootLayoutController = new GestionnaireRootLayoutController();
		//adminOverviewController = new AdminOverviewController();
		logger.info("A unique instance of {} was created !" ,MainController.class.getSimpleName());
	}
	
	public static MainController getInstance() {
		if (instance == null) {
			instance = new MainController();
			logger.info("An instance of {} was created" , instance);
		}
		return instance;
	}

	/**
	 * Initialize Main windows
	 * @param primaryStage Stage to created
	 */
	public void initApplication() {
		this.loadInitStage("MainWindow", null , appMainWindowController , true , false , null);
	}

	/**
	 * Initialize authentication windows
	 * @param primaryStage Stage to created
	*/
	public void initAuthentication() {
		this.loadInitStage("Authentication", "Authentication", authenticationController, true, false , null);
		
	}

	/**
	 * Show AdminRootLayout and charge AdminOverview
	 * @param primaryStage
	 */
	public void initAdminRootLayout(Utilisateur auth) {
		this.loadInitStage("AdminRootLayout", null, adminRootLayoutController, false, true , auth);
		Utilitaire.loadPageInRootLayout(rootLayout, "AdminOverview");
	}

	/**
	 * 
	 * @param primaryStage
	 */
	public void initManagerRootLayout(Utilisateur auth) {
		this.loadInitStage("ManagerRootLayout", null, managerRootLayoutController, false, true , auth);
		Utilitaire.loadPageInRootLayout(rootLayout, "ManagerOverview");
	}

	/**
	 * 
	 * @param primaryStage
	 */
	public void initGestionnaireRootLayout(Utilisateur auth) {
		this.loadInitStage("GestionnaireRootLayout", null, gestionnaireRootLayoutController, false, true , auth);
		Utilitaire.loadPageInRootLayout(rootLayout, "GestionnaireOverview");
	}

	/**
	 * Load Stage 
	 * @param primaryStage Stage to load
	 * @param fxmlFilename FXML File to load for stage
	 * @param title	Title of stage
	 * @param instance Controller associated to FXMLFile
	 * @param isDecored Define if stage is decored
	 * @param isRoot Define if use borderPane or AnchorBane
	 */
	private void loadInitStage(String fxmlFilename , String title , 
			IController controller , Boolean isDecored , Boolean isRoot , Utilisateur auth) {
		Stage primaryStage = null;
		FXMLLoader loader =	Utilitaire.initFXMLoader(fxmlFilename);
		
		if (isRoot) {
			logger.info(title);
			rootLayout = (BorderPane) Utilitaire.loadFXMLFile(loader, true);
			controller.setRootLayout(rootLayout);
			primaryStage = Utilitaire.createStage(rootLayout, title, isDecored);
		} else {
			AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);
			primaryStage = Utilitaire.createStage(root, title, isDecored);
		}
		
		if (auth != null) {
			primaryStage.setUserData(auth);
		}
		
		controller = loader.getController();       
		controller.setPrimaryStage(primaryStage);
		Utilitaire.showStage(primaryStage);
	}

}
