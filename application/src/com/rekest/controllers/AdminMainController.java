package com.rekest.controllers;

import com.rekest.utils.Utilitaire;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/***
 * MainController For admin Files
 * @author Fatoumata DICKO
*/
public class AdminMainController  {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    
    // controllers
	private AdminRootLayoutController adminRootLayoutController;
	private AdminOverviewController adminOverviewController;
	
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
    
    
    
}