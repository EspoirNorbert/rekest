package com.rekest.controllers.impl;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.controllers.IController;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Directeur;
import com.rekest.entities.employes.DirecteurGeneral;
import com.rekest.entities.employes.Gestionnaire;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.enums.NotificationType;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;
import com.rekest.utils.PropertyManager;
import com.rekest.utils.Utilitaire;
import com.rekest.utils.Validator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AuthenticationController implements Initializable , IController {

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
		logger.info("Fenetre re�ue {}" , this.primaryStage.getTitle() );
	}

	public void setConnectedUser(Utilisateur utilisateur) {
		logger.info(utilisateur);
		this.connectedUser = utilisateur;
	}

	@FXML
	void handleClickedConnexion(ActionEvent event) {
		if (isInputValid()) {
			Utilisateur user = (Utilisateur) service.validerIdentifiants(
					Utilitaire.getTextField(txtLogin), 
					Utilitaire.getTextField(txtPassword));

			if (user!= null) {
				logger.info("{} connect� avec success", user.getEmployeProfil());
				clearField(); // clear field
				this.primaryStage.hide();
				this.setConnectedUser(user);
				connectUserToSpace();
				//Utilitaire.notification(NotificationType.INFO, "Bienvenue dans le votre ", "Vous etes connect� avec success !");
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
		
		if (connectedUser == null) {
			Utilitaire.alert(AlertType.ERROR, 
					primaryStage, 
					"Get user Data Error", 
					"User Data", 
					"Error when Application try get user connected data !");
		} else {

			this.connectedUser.setEmployeProfil(Utilitaire.setEmployeeProfil(connectedUser));
			String profil = this.connectedUser.getEmployeProfil();
			
			logger.info("Employe profil is {}" , profil );
			
			try {
				if (profil.equals(Administrateur.class.getSimpleName())) {
					mainController.initAdminRootLayout(connectedUser);
				} 

				if (profil.equals(ChefService.class.getSimpleName()) ||
						profil.equals(Directeur.class.getSimpleName()) ||
						profil.equals(DirecteurGeneral.class.getSimpleName())) {
						mainController.initManagerRootLayout(connectedUser);
				}

				if (profil.equals(Gestionnaire.class.getSimpleName())) {
					mainController.initGestionnaireRootLayout(connectedUser);
				} 

			} catch (Exception e) {
				e.printStackTrace();
				//Utilitaire.notification(NotificationType.ERROR, "Error", e.getMessage());
			}
		}

	}

	@FXML
	void handleClickedPasswordForget(ActionEvent event) {}

	@FXML
	void handleClickedQuitter(ActionEvent event) {
		System.exit(0);
	}

	public AuthenticationController() {
		logger.info("Instance of {} is created" , this.getClass().getName());
		mainController = MainController.getInstance();
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

		if (!Validator.validateText(Utilitaire.getTextField(txtLogin)))
			errorMessage += PropertyManager.getInstance().getApplicationLoginError();

		if (!Validator.validateText(Utilitaire.getTextField(txtPassword))) 
			errorMessage += PropertyManager.getInstance().getApplicationPasswordError();

		if (!Validator.validateText(errorMessage)) {
			return true;
		} else {
			Utilitaire.alert(AlertType.WARNING, 
					primaryStage, 
					PropertyManager.getInstance().getApplicationErrorFieldHeader(), 
					PropertyManager.getInstance().getApplicationErrorFields(), 
					errorMessage);

			return false;
		}
	}

	private void clearField() {
		Utilitaire.clear(txtLogin , txtPassword);
	}

}