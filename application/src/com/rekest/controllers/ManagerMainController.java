package com.rekest.controllers;

import com.rekest.utils.Utilitaire;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/***
 * MainController For manager Files
 * @author Fatoumata DICKO
*/
public class ManagerMainController  {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    
    // controllers
	private ManagerRootLayoutController managerRootLayoutController;
	private ManagerOverviewController managerOverviewController;
	
	/**
	 * 
	 * @param primaryStage
	 */
    public void initManagerRootLayout(Stage primaryStage) {
    	this.primaryStage = primaryStage;
    	this.primaryStage.setResizable(true);
    	FXMLLoader loader = Utilitaire.initFXMLoader("ManagerRootLayout");
    	rootLayout = (BorderPane) Utilitaire.loadFXMLFile(loader, true);
        Utilitaire.createScene(rootLayout, primaryStage, null);
        managerRootLayoutController = loader.getController();       
        managerRootLayoutController.setPrimaryStage(primaryStage);
        managerRootLayoutController.setRootLayout(rootLayout);
        Utilitaire.showStage(primaryStage);
    }

    /**
     * Shows the Manager overview inside the root layout.
     */
    public void showManagerOverview() {
        Utilitaire.loadPageInRootLayout(rootLayout, "ManagerOverview");
        managerOverviewController = new ManagerOverviewController();
        managerOverviewController.setPrimaryStage(primaryStage);
    }
    
    
    
}