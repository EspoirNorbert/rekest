package com.rekest.controllers.impl;

import java.io.IOException;

import com.rekest.controllers.IController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController implements IController {
	
	private Stage primaryStage;
    private BorderPane rootLayout;

	private IController authController;	

    public void initAuthLayout(Stage primaryStage) {
        try {
        	this.primaryStage = primaryStage;
        
        	FXMLLoader loader = new FXMLLoader ();
        	loader.setLocation(MainController.class.getResource("Auth.fxml"));
        	rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);

            authController = loader.getController();       
            authController.setPrimaryStage(primaryStage);

             System.out.print("FYES");
            this.primaryStage.show();
            
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}