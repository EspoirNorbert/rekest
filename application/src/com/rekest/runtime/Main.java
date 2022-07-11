package com.rekest.runtime;

import com.rekest.controllers.MainController;
import com.rekest.utils.Utilitaire;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	
    private Stage primaryStage;
    private MainController mainController;
    
    public Main() {
    	mainController = new MainController();
	}
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.getIcons().add(new Image(Utilitaire.getApplicationIconUrl()));
        this.primaryStage.setResizable(false);
        mainController.initAuthentication(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
