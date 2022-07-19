package com.rekest.runtime;

import com.rekest.controllers.MainController;
import com.rekest.enums.NotificationType;
import com.rekest.utils.PropertyManager;
import com.rekest.utils.Utilitaire;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private Stage primaryStage;
    private MainController mainController;
    
    public Main() {
    	mainController = MainController.getInstance();
	}
    
    @Override
    public void start(Stage primaryStage) {
    	try {
    		 this.primaryStage = primaryStage;
    		 this.primaryStage.initStyle(StageStyle.UNDECORATED);
    		 this.primaryStage.getIcons().add(new Image(PropertyManager.getInstance().getApplicationIcon()));
    	     this.primaryStage.setResizable(false);
    	     mainController.initAuthentication(primaryStage);
    	} catch(Exception e) {
    		e.printStackTrace();
    		Utilitaire.notification(NotificationType.ERROR, 
    				"Main Windows Creation Stage", e.getMessage());
    	}
     
    }

    public static void main(String[] args) {
        launch(args);
    }
}
