package com.rekest.utils;

import java.io.IOException;

import com.rekest.entities.employes.Utilisateur;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

public class Utilitaire {

	public static void alert(AlertType alertType, Window onwer, String title, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.initOwner(onwer);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		
		alert.showAndWait();

		if (alertType == AlertType.ERROR)
			// Fatal Error, exit System !
			System.exit(-1);     		
	}

	public static void generateLoginAndPassword(Utilisateur utilisateur) {
		utilisateur.setLogin(utilisateur.getNom() + "." +utilisateur.getPrenom()+ "@rekest.sn");
		utilisateur.setPassword(utilisateur.getEmployeProfil().toUpperCase());
	}

	public static void loadPageInRootLayout(BorderPane rootLayout ,String filename , Class<?> classe) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(classe.getResource(filename+".fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		rootLayout.setCenter(page);
	}

}
