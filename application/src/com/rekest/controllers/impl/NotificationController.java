package com.rekest.controllers.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.rekest.entities.Notification;
import com.rekest.entities.Service;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;
import com.rekest.utils.PropertyManager;
import com.rekest.utils.Utilitaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class NotificationController implements Initializable {

	private ObservableList<Notification> notificationList = FXCollections.observableArrayList();
	
    @FXML private Label labelDate;

    @FXML private Label labelHeure;

    @FXML private Label labelNoteEmisse;

    @FXML private Label labelNumeroDemande;

    @FXML private ListView<Notification> listViewNotifications;
    
    private IFeature feature = Feature.getCurrentInstance();
    
    private Utilisateur connectedUser;

	private Stage primaryStage;
    
	private Notification selectNotification;
	
    public void setPrimaryStage(Stage primaryStage) {
 		this.primaryStage = primaryStage;
    }
 	
 	public void setConnectedUser(Utilisateur connectedUser) {
 		this.connectedUser = connectedUser;
 	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadNotifications();
		listenerNotification();
		
			
	}
	
	private void listenerNotification() {
		listViewNotifications.getSelectionModel().selectedItemProperty()
		.addListener(ov -> {
			if (notificationList.size() > 0)
				selectNotification = listViewNotifications.getSelectionModel().getSelectedItem();
			
			this.loadNotificationDetail();
		});
	}

	private void loadNotificationDetail() {
		
		if (selectNotification != null) {
			Utilitaire.setLabel(labelDate, Utilitaire.parseState(selectNotification.getCreatedAt()));
		} else {
			Utilitaire.alert(AlertType.WARNING, 
					null, 
					"No selection",
					"No Notification selected",
					"Please select an notifications into the list ");

		}
		
	}

	/**
	 * Initialize the value of combox box service
	 * 
	 */
	public void loadNotifications(){
		notificationList.clear();
		List<Notification> notifications = feature.listerNotifications();
		for (Notification notification : notifications) {
			notificationList.add(notification);
		}
		
		
		
		listViewNotifications.setCellFactory(new Callback<ListView<Notification>, ListCell<Notification>>() {
			
			@Override
			public ListCell<Notification> call(ListView<Notification> param) {
				ListCell<Notification> cell = new ListCell<Notification>() {
					
					protected void updateItem(Notification item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setGraphic(new ImageView(new Image(PropertyManager.getInstance().getApplicationIcon())));
							setText(item.getMessage() + "\n" + (item.isRead() ? " (Lu) " : " (Non lu) "));
						}
					};
				};
				return cell;
			}
		});
		listViewNotifications.setItems(notificationList);
	}
	
	
	/**
	 * Serialize a observablelist of services 
	 * @param service list
	 * @return list of strings with service id and name only
	 */
	public List<String> serialize(List<Notification> notificationList){

		List<String> strings = new ArrayList<>();

		for (Notification notification : notificationList) {
			strings.add(notification.getId()+ " " + notification.getMessage() + " - le " + 
					Utilitaire.parseState(notification.getCreatedAt())
			         + (notification.isRead() ? " (Lu) " : " (Non lu) "));
		}
		
		for (String string : strings) {
			System.out.println(string);
		}

		return strings;
	}

	public ObservableList<Notification> getNotificationList() {
		return notificationList;
	}

}
