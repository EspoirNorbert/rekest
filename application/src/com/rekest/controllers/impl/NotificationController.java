package com.rekest.controllers.impl;

import com.rekest.entities.employes.Utilisateur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class NotificationController {

    @FXML
    private Label labelDate;

    @FXML
    private Label labelHeure;

    @FXML
    private Label labelNoteEmisse;

    @FXML
    private Label labelNumeroDemande;

    @FXML
    private ListView<?> listViewNotifications;
    
	
    private Utilisateur connectedUser;

	private Stage primaryStage;
    
    public void setPrimaryStage(Stage primaryStage) {
 		this.primaryStage = primaryStage;
    }
 	
 	public void setConnectedUser(Utilisateur connectedUser) {
 		this.connectedUser = connectedUser;
 	}

}
