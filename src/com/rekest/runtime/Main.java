package com.rekest.runtime;

import com.rekest.controllers.MainController;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;

public class Main extends Application {

	public static final String APPLICATION_ICON_URL = "com/rekest/assets/images/rekest_logo.png"; 	
    private Stage primaryStage;
    private MainController mainController;
    
    public Main() {
    	mainController = new MainController();
	}
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.getIcons().add(new Image(APPLICATION_ICON_URL));
        this.primaryStage.setResizable(false);
        mainController.initAuthentication(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
