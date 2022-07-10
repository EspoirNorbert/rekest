package com.rekest.views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

	private Stage primaryStage;
	private AuthenticationController authenticationController;
	
	public void initAuthentication(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			// Load person overview.
	    	FXMLLoader loader = new FXMLLoader ();
	    	loader.setLocation(MainController.class.getResource("Authentification.fxml"));
	    	AnchorPane root = (AnchorPane) loader.load();

	        // Show the scene containing the root layout.
	        Scene scene = new Scene(root);
	        this.primaryStage.setScene(scene);

	        // Give the controller access to the main app.
	        authenticationController = loader.getController();       
	        authenticationController.setPrimaryStage(primaryStage);

	        // show UI
	        this.primaryStage.show();
		} catch (IOException e) {
			System.err.println("Erroor " + e.getMessage());
			e.printStackTrace();
		}
	}

	
}
