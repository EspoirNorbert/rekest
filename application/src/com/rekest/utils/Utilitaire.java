package com.rekest.utils;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.controllers.MainController;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Directeur;
import com.rekest.entities.employes.DirecteurGeneral;
import com.rekest.entities.employes.Gestionnaire;
import com.rekest.entities.employes.Utilisateur;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Utilitaire {

	public final static Logger logger = LogManager.getLogger(HibernateDao.class);
	public static final String PATH_VIEWS_FILES = "/com/rekest/views/";
	public static final String APPLICATION_ICON_URL = "com/rekest/assets/images/rekest_logo.png"; 	

	public static String getApplicationIconUrl() {
		return APPLICATION_ICON_URL;
	}
	
	/**
	 * Alert Function for javaFX
	 * @param alertType
	 * @param onwer
	 * @param title
	 * @param headerText
	 * @param contentText
	 */
	public static void alert(AlertType alertType, Window onwer, String title, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.initOwner(onwer);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);

		alert.showAndWait();

		/*
		if (alertType == AlertType.ERROR)
			// Fatal Error, exit System !
			System.exit(-1);
		 */     		
	}

	/**
	 * Generate login and password for user
	 * @param utilisateur
	 * @return
	 */
	public static Utilisateur generateLoginAndPassword(Utilisateur utilisateur) {
		utilisateur.setLogin(utilisateur.getNom() + "." +utilisateur.getPrenom()+ "@rekest.sn");
		utilisateur.setPassword(Utilitaire.setUserProfil(utilisateur));
		return utilisateur;
	}

	/**
	 * Set password to user according to profil
	 * @param u
	 * @return
	 */
	public static String setUserProfil(Utilisateur u) {
		if (u instanceof Administrateur ) return "admin";
		if (u instanceof Gestionnaire ) return "gestionnaire";
		if (u instanceof ChefService ) return "chef";
		if (u instanceof Directeur ) return "directeur";
		if (u instanceof DirecteurGeneral ) return "dg";
		return null;
	}

	/**
	 * Charge FXML file into BorderPane 
	 * @param rootLayout
	 * @param filename
	 * @param classe
	 * @throws IOException
	 */
	public static void loadPageInRootLayout(BorderPane rootLayout ,String filename) {
		FXMLLoader loader = Utilitaire.initFXMLoader(filename);
		AnchorPane page   = (AnchorPane) Utilitaire.loadFXMLFile(loader, false) ;
		rootLayout.setCenter(page);
	}
	
	public static Parent loadFXMLFile(FXMLLoader loader, Boolean isRoot) {
		Parent root = null;
		try {
			if (isRoot)
				root = (BorderPane) loader.load();
			else
				root = (AnchorPane) loader.load();
			
			return root;
		} catch (IOException io) {
			  Utilitaire.alert(AlertType.ERROR, null,
		                "Error", io.getClass() +
		                "Error while loading fxml file",
		                io.getMessage());
		}
		return null;
	}

	/**
	 * Get full path to access to FXML file in views's folder
	 * @param filename
	 * @return
	 */
	public static String getFileInViews(String filename) {
		return PATH_VIEWS_FILES + filename + ".fxml";
	}

	/**
	 * Init FXMLoader setting location
	 * @param fxmlLoader FXMLLoader to load
	 * @param filename Name of file to load
	 * @return Object charged
	 */
	public static FXMLLoader initFXMLoader(String filename){
	    FXMLLoader	fxmlLoader = new FXMLLoader ();
		fxmlLoader.setLocation(MainController.class.getResource(Utilitaire
				.getFileInViews(filename)));
			
		if (fxmlLoader.getLocation() != null) 
			logger.info("Chargement de la vue {} avec le chemin {}",filename,fxmlLoader.getLocation().toString()); 
		
		return fxmlLoader;
	}

	public static void saveLogError() {}

	/**
	 * Create Scene 
	 * @param root
	 * @param stage
	 * @param title
	 * @return Stage
	 */
	public static Stage createScene(Parent root , Stage stage , String title) {
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle(title);
		return stage;
	}
	
	/**
	 * Create Dialog Box
	 * @param root
	 * @param primaryStage
	 * @param title
	 * @return
	 */
	public static Stage createDialog(Parent root , Stage primaryStage , String title) {
		  Stage dialogStage = new Stage();
          dialogStage.setTitle(title);
          dialogStage.getIcons().add(new Image(APPLICATION_ICON_URL));
          dialogStage.initModality(Modality.WINDOW_MODAL);
          dialogStage.initOwner(primaryStage);
          Scene scene = new Scene(root);
          dialogStage.setScene(scene);
          return dialogStage;
	}
	
	/**
	 * Show Dialog
	 * @param dialogStage
	 */
	public static void showDialog(Stage dialogStage) {
		dialogStage.showAndWait();
	}
	
	/**
	 * Show Stage
	 * @param stage
	 */
	public static void showStage(Stage stage) {
		stage.show();
	}

}
