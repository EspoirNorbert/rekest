package com.rekest.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Directeur;
import com.rekest.entities.employes.DirecteurGeneral;
import com.rekest.entities.employes.Gestionnaire;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.enums.NotificationType;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;
import com.rekest.utils.Utilitaire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AuthenticationController implements Initializable {

	public final static Logger logger = LogManager.getLogger(AuthenticationController.class);

	@FXML
	private TextField txtLogin;

	@FXML
	private PasswordField txtPassword;

	private IFeature service = Feature.getCurrentInstance();

	private Stage primaryStage;

	private MainController mainController;

	private Utilisateur connectedUser;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void setConnectedUser(Utilisateur utilisateur) {
		this.connectedUser = utilisateur;
	}

	@FXML
	void handleClickedConnexion(ActionEvent event) {
		if (isInputValid()) {
			Utilisateur user = (Utilisateur) service.validerIdentifiants(
					Utilitaire.getTextField(txtLogin), 
					Utilitaire.getTextField(txtPassword));

			if (user!= null) {
				logger.info("{} connecté avec success", user.getNom());
				clearField(); // clear field
				String profil = user.getEmployeProfil();
				this.setConnectedUser(user);
				this.primaryStage.setUserData(user);
				this.primaryStage.hide();
				connectUserToSpace();
				Utilitaire.notification(NotificationType.INFO, "Bienvenue dans le votre ", "Vous etes connecté avec success !");
			} else {
				Utilitaire.notification(NotificationType.ERROR, 
						"Echec de connexion", "Informations incorrects");
			}
		}
	}

	/**
	 * Connect a user to this space according user profil
	 */
	private void connectUserToSpace() {

		String profil = this.connectedUser.getEmployeProfil();
		mainController = MainController.getInstance();

		if (profil.equals(Administrateur.class.getSimpleName())) {
			mainController.initAdminRootLayout(primaryStage);
			mainController.showAdminOverview();
		} 

		if (profil.equals(ChefService.class.getSimpleName()) ||
				profil.equals(Directeur.class.getSimpleName()) ||
				profil.equals(DirecteurGeneral.class.getSimpleName())) {
			mainController.initManagerRootLayout(primaryStage);
			//mainController.showManagerOverview();
		}

		if (profil.equals(Gestionnaire.class.getSimpleName())) {
			mainController.initGestionnaireRootLayout(primaryStage);
			mainController.showGestionnaireOverview();
		} 

	}

	@FXML
	void handleClickedPasswordForget(ActionEvent event) {

	}

	@FXML
	void handleClickedQuitter(ActionEvent event) {
		System.exit(0);
	}

	public AuthenticationController() {
		logger.info("Instance of {} is created" , this.getClass().getName());
		service.initAllEntity();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}


	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (Utilitaire.getTextField(txtLogin) == null || Utilitaire.getTextField(txtLogin).length() == 0)
			errorMessage += "Le login est invalide!\n";


		if (Utilitaire.getTextField(txtPassword) == null || Utilitaire.getTextField(txtPassword).length() == 0) 
			errorMessage += "Le mot de passe est invalide!\n";


		if (errorMessage.length() == 0) {
			return true;
		} else {
			Utilitaire.alert(AlertType.WARNING, 
					primaryStage, 
					"Invalid Fields", 
					"Please correct invalid fields", 
					errorMessage);

			return false;
		}
	}

	private void clearField() {
		Utilitaire.clear(txtLogin , txtPassword);
	}

}