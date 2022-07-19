package com.rekest.controllers;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.utils.Utilitaire;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class ManagerRootLayoutController implements Initializable {

	public final static Logger logger = LogManager.getLogger(ManagerRootLayoutController.class);

	private MainController mainController;

	private Stage primaryStage;

	private BorderPane rootLayout;

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

	@FXML
	void handleClickedAccueil(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "ManagerOverview");
	}

	@FXML
	void handleClickedDemande(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "ManagerDemande");
	}

	@FXML
	void handleClickedLogOut(MouseEvent event) {
		mainController.initAuthentication(primaryStage);
	}

	@FXML
	void handleClickedProfil(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "ManagerProfil");
	}

	@FXML
	void handleClicledNotification(MouseEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainController = MainController.getInstance();
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Espace Manager - Manager connecté");
		this.primaryStage.setHeight(600);
		this.primaryStage.setWidth(1200);
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
}
