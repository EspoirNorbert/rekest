package com.rekest.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.utils.Utilitaire;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {

	/**
	 * Loggers
	 */
	public final static Logger logger = LogManager.getLogger(MainController.class);
	private static MainController instance = new MainController();
	
	private MainController() {
		logger.info("A unique instance of {} was created !" ,MainController.class.getSimpleName());
	}
	
	/**
	 * Attributes
	*/
	private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     * Controllers
    */
	private AuthenticationController authenticationController;
	private AdminRootLayoutController adminRootLayoutController;
	private AdminOverviewController adminOverviewController;
	private ManagerRootLayoutController managerRootLayoutController;
	private ManagerOverviewController managerOverviewController;
	private GestionnaireRootLayoutController gestionnaireRootLayoutController;
	private GestionnaireOverviewController gestionnaireOverviewController;

	/**
	 * Get instance of MainController
	 * @return
	 */
	public static MainController getInstance() {
		if (instance == null) {
			instance = new MainController();
			logger.info("An instance of {} was created" , instance);
		}
		return instance;
	}
	

	/**
	 * Initialize authentication windows
	 * @param primaryStage Stage to created
	 */
	public void initAuthentication(Stage primaryStage) {
		this.primaryStage = primaryStage;
		FXMLLoader loader =	Utilitaire.initFXMLoader("Authentication");
		AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);
		Utilitaire.createScene(root, primaryStage, "Application de suivie de taches - Authentication");
		authenticationController = loader.getController();       
		authenticationController.setPrimaryStage(this.primaryStage);
		Utilitaire.showStage(this.primaryStage);
		  Utilitaire.centrerStage(primaryStage);
	}


	/**
	 * 
	 * @param primaryStage
	 */
    public void initAdminRootLayout(Stage primaryStage) {
    	this.primaryStage = primaryStage;
    	this.primaryStage.setResizable(true);
    	FXMLLoader loader = Utilitaire.initFXMLoader("AdminRootLayout");
    	rootLayout = (BorderPane) Utilitaire.loadFXMLFile(loader, true);
        Utilitaire.createScene(rootLayout, primaryStage, null);
        adminRootLayoutController = loader.getController();       
        adminRootLayoutController.setPrimaryStage(primaryStage);
        adminRootLayoutController.setRootLayout(rootLayout);
        Utilitaire.showStage(primaryStage);
    }

    /**
     * Shows the Admin overview inside the root layout.
     */
    public void showAdminOverview() {
        Utilitaire.loadPageInRootLayout(rootLayout, "AdminOverview");
        adminOverviewController = new AdminOverviewController();
        adminOverviewController.setPrimaryStage(primaryStage);
    }
    
    
    /**
	 * 
	 * @param primaryStage
	 */
    public void initManagerRootLayout(Stage primaryStage) {
    	try {
    		this.primaryStage = primaryStage;
        	this.primaryStage.setResizable(true);
        	FXMLLoader loader = Utilitaire.initFXMLoader("ManagerRootLayout");
        	rootLayout = (BorderPane) Utilitaire.loadFXMLFile(loader, true);
            Utilitaire.createScene(rootLayout, primaryStage, null);
            managerRootLayoutController = loader.getController();       
            managerRootLayoutController.setPrimaryStage(primaryStage);
            managerRootLayoutController.setRootLayout(rootLayout);
            Utilitaire.showStage(primaryStage);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    	
    }

    /**
     * Shows the Manager overview inside the root layout.
     */
    public void showManagerOverview() {
        Utilitaire.loadPageInRootLayout(rootLayout, "ManagerOverview");
        managerOverviewController = new ManagerOverviewController();
        managerOverviewController.setPrimaryStage(primaryStage);
    }
    
    
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
