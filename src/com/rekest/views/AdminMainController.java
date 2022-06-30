package com.rekest.views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Data;

/***
 * MainController principale des windows admin
 * @author hp
 */
@Data
public class AdminMainController  {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    
    // controllers
	private AdminRootLayoutController adminRootLayoutController;
	private AdminAcceuilController adminAcceuilController;
	
	 /**
     * Initializes the Admin root layout.
     */
    public void initAdminRootLayout(Stage primaryStage) {
        try {
        	this.primaryStage = primaryStage;
        
        	// Load person overview.
        	FXMLLoader loader = new FXMLLoader ();
        	loader.setLocation(MainController.class.getResource("AdminRootLayout.fxml"));
        	rootLayout =  (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);

            // Give the controller access to the main app.
            adminRootLayoutController = loader.getController();       
            adminRootLayoutController.setPrimaryStage(primaryStage);
            adminRootLayoutController.setRootLayout(rootLayout);

            // show windows
            this.primaryStage.show();
            
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showAdminOverview() {
        try {
            // Load person overview.    
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(MainController.class.getResource("Acceuil.fxml"));
        	AnchorPane adminOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(adminOverview);
        
            // Give the controller access to the main app.
            adminAcceuilController = loader.getController();
            adminAcceuilController.setPrimaryStage(primaryStage);
        } catch (IOException e) {
        	// TODO
        }
    }
    
    
    
}