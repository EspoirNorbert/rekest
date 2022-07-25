package com.rekest.controllers.impl;

import java.net.URL;
import java.util.ResourceBundle;

import com.rekest.entities.Notification;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class NotificationController implements Initializable {

    @FXML
    private Label labelDate;

    @FXML
    private Label labelHeure;

    @FXML
    private Label labelNoteEmisse;

    @FXML
    private Label labelNumeroDemande;

    @FXML
    private ListView<Notification> listViewNotifications;
    
    private IFeature feature = Feature.getCurrentInstance();
    
    private Utilisateur connectedUser;

	private Stage primaryStage;
    
    public void setPrimaryStage(Stage primaryStage) {
 		this.primaryStage = primaryStage;
    }
 	
 	public void setConnectedUser(Utilisateur connectedUser) {
 		this.connectedUser = connectedUser;
 	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initListView();
	}
	

	private void initListView() {
		ObservableList<Notification> notifications = 
				feature.loadNotificationObservableList();
		listViewNotifications = new ListView<Notification>(notifications);
		
		listViewNotifications.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		
		for (Notification note : notifications) {
			System.out.println(note);
		}
	}
	
	
	private void addListener() {
	
	}

}
