package com.rekest.utils;

import com.rekest.entities.employes.Utilisateur;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

public class Utilitaire {

	public static void alert(AlertType alertType, Window onwer, String title, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.initOwner(onwer);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        // -
        alert.showAndWait();
        
        if (alertType == AlertType.ERROR)
	        // Fatal Error, exit System !
	        System.exit(-1);     		
	}
	
	public void generateLoginAndPassword(Utilisateur utilisateur) {
		utilisateur.setLogin(utilisateur.getNom() + "." +utilisateur.getPrenom()+ "@rekest.sn");
		utilisateur.setPassword(utilisateur.getEmployeProfil().toUpperCase());
	}

	
}
