package com.rekest.controllers.impl;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.entities.employes.Utilisateur;
import com.rekest.utils.Utilitaire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProfilController implements Initializable {

	/**
	 * Loggers
	 */
	public final static Logger logger = LogManager.getLogger(ProfilController.class);
	
    @FXML
    private Button btnSauveegarder;

    @FXML
    private TextField textFieldAdresse;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldNom;

    @FXML
    private TextField textFieldPrenom;

    @FXML
    private TextField textFieldTelephone;

    private Utilisateur connectedUser;
    
    public void setConnectedUser(Utilisateur connectedUser) {
		this.connectedUser = connectedUser;
		initUserData();
	}
    
    public ProfilController() {
		logger.info("Creation du profil controller avec utilisateur {} ");
	}
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		logger.info("All composants is charged");
	}
	
	private void initUserData() {
		if (connectedUser != null) {
			Utilitaire.setTextField(textFieldNom,  connectedUser.getNom());
			Utilitaire.setTextField(textFieldPrenom, connectedUser.getPrenom());
			Utilitaire.setTextField(textFieldAdresse, connectedUser.getAdresse());
			Utilitaire.setTextField(textFieldTelephone, connectedUser.getTelephone());
			Utilitaire.setTextField(textFieldEmail, connectedUser.getEmail());
		} else {
			logger.info("nULL USEERDARA");
		}
	}

	
	   @FXML
	    void handleClickedSauvegarder(ActionEvent event) {

	    }
}
