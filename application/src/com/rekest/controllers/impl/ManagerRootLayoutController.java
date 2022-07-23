package com.rekest.controllers.impl;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.controllers.IController;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.utils.Utilitaire;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class ManagerRootLayoutController implements Initializable , IController {

	/**
	 * Loggers
	 */
	public final static Logger logger = LogManager.getLogger(AdminRootLayoutController.class);

	
	/**
	 * Controllers
	 */
	private DemandeController demandeController; 
	private ProfilController profilController;      
	private MainController mainController;

	/**
	 * Stage and Node
	 */
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	/**
	 * Composants
	 */
	@FXML
	private AnchorPane anchorPaneCenter;

	@FXML
	private Button btnAccueil;

	@FXML
	private Button btnDemande;

	@FXML
	private Button btnLogOut;

	@FXML
	private Button btnNotifications;

	@FXML
	private Button btnProfil;

	@FXML
	private Circle circleProfil;

	@FXML
	private ImageView imageLogo;

	@FXML
	private Label labelProfil;

	@FXML
	private Label labelUsername;
	
	private Utilisateur userConnected;

	private String currentPage = "Accueil";

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
		Utilitaire.setDimensionStage(primaryStage, 600, 1200);
		this.initData();
	}

	private void setTitle(String currentPage) {
		this.primaryStage.setTitle(currentPage + " - " +
				Utilitaire.setUserWindowTitle(userConnected , 
						Utilitaire.getTypeManager(userConnected))) ;
	}


	@FXML
	void handleClickedAccueil(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "ManagerOverview");
		this.setTitle(currentPage);
	}

	@FXML
	void handleClickedDemande(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Demande");
		this.setTitle("Demande");
	}

	@FXML
	void handleClickedLogOut(MouseEvent event) {
		Utilitaire.logout(primaryStage);
	}

	@FXML
	void handleClickedProfil(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Profil");
		this.setTitle("Profil");
	}

	@FXML
	void handleClicledNotification(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Notifications");
		this.setTitle("Notifications");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainController = MainController.getInstance();
	}


	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	@Override
	public void initData() {
	
	}
}
