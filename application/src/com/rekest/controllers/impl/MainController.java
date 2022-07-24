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
	@SuppressWarnings("unused")
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
	public void initApplication(Stage primaryStage) {
		this.loadInitStage("MainWindow",null, appMainWindowController, true);
	}

	/**
	 * Initialize authentication windows
	 * @param primaryStage Stage to created
	 */
	public void initAuthentication(Stage stage) {
		this.loadInitStage("Authentication","Authentication", authenticationController, true);
	}

	public void initAdminRootLayout(Utilisateur auth) {
		this.loadInitRootLayout(auth, "AdminRootLayout", adminRootLayoutController);
		Utilitaire.loadPageInRootLayout(rootLayout, "AdminOverview");
	}

	public void initManagerRootLayout(Utilisateur auth) {
		this.loadInitRootLayout(auth, "ManagerRootLayout", managerRootLayoutController);
		Utilitaire.loadPageInRootLayout(rootLayout, "ManagerOverview");
	}

	public void initGestionnaireRootLayout(Utilisateur auth) {
		this.loadInitRootLayout(auth, "GestionnaireRootLayout", gestionnaireRootLayoutController);
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
	private void loadInitStage(String fxmlFilename , String title , IController controller , Boolean isDecored) {
		FXMLLoader loader =	Utilitaire.initFXMLoader(fxmlFilename);
		AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);
		Stage primaryStage  = Utilitaire.createStage(root, title, isDecored);
		controller = loader.getController();  
		controller.setPrimaryStage(primaryStage);
		Utilitaire.showStage(primaryStage);
	}

	/**
	 * Load RootLayout Window
	 * @param auth
	 * @param filename
	 * @param rootController
	 */
	private void loadInitRootLayout(Utilisateur auth , String filename , IController rootController) {
		FXMLLoader loader = Utilitaire.initFXMLoader(filename);
		rootLayout = (BorderPane) Utilitaire.loadFXMLFile(loader, true);
		Stage primaryStage = Utilitaire.createStage(rootLayout, null, false);
		primaryStage.setUserData(auth);
		rootController = loader.getController();       
		rootController.setPrimaryStage(primaryStage);
		rootController.setRootLayout(rootLayout);
		Utilitaire.showStage(primaryStage);
	}


}
