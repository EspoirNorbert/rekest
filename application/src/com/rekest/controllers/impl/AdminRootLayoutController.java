package com.rekest.controllers.impl;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

/**
 * RootLayout des windows Admins
 * @author Fatoumata DICKO
 */
public class AdminRootLayoutController implements Initializable , IController {

	/**
	 * Loggers
	 */
	public final static Logger logger = LogManager.getLogger(AdminRootLayoutController.class);

	/**
	 * Controllers
	 */
	private DepartementController departementController; 
	private ServiceController serviceController;      
	private MainController mainController;

	/**
	 * Stage and Node
	 */
	private Stage primaryStage;
	private BorderPane rootLayout;

	/**
	 * Les composants
	*/
	@FXML
	private AnchorPane anchorPaneCenter;

	@FXML
	private Button btnAccueil;

	@FXML
	private Button btnDemande;

	@FXML
	private Button btnDepartement;

	@FXML
	private Button btnEmploye;

	@FXML
	private Button btnLogOut;

	@FXML
	private Button btnNotifications;

	@FXML
	private Button btnProduit;

	@FXML
	private Button btnProfil;

	@FXML
	private Button btnRole;

	@FXML
	private Button btnService;

	@FXML
	private Button btnUtlisateurs;

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

	
	@Override
	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
		logger.info("Root layout a été setter");
	}


	@FXML
	void handleClickedAccueil(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "AdminOverview");
		Utilitaire.setTiteStage(primaryStage , "Accueil" , userConnected);
	}

	@FXML
	void handleClickedDemande(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Demandes");
		Utilitaire.setTiteStage(primaryStage , "Demandes" , userConnected);
	}

	@FXML
	void handleClickedDepartement(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Departement");
		Utilitaire.setTiteStage(primaryStage , "Departement" , userConnected);
	}

	@FXML
	void handleClickedEmploye(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Employes");
		Utilitaire.setTiteStage(primaryStage , "Employe" , userConnected);
	}


	@FXML
	void handleClickedParametre(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Parametres");
		Utilitaire.setTiteStage(primaryStage , "Parametres" , userConnected);
	}

	@FXML
	void handleClickedProduit(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Produits");
		Utilitaire.setTiteStage(primaryStage , "Produits" , userConnected);
	}

	@FXML
	void handleClickedRole(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Roles");
		Utilitaire.setTiteStage(primaryStage , "Roles" , userConnected);
	}

	@FXML
	void handleClickedProfil(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Profil");
		Utilitaire.setTiteStage(primaryStage , "Profil" , userConnected);
	}

	@FXML
	void handleClickedUtilisateur(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Profil");
		Utilitaire.setTiteStage(primaryStage , "Utilisateurs" , userConnected);
	}

	@FXML
	void handleClickedService(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Services");
		Utilitaire.setTiteStage(primaryStage , "Services" , userConnected);
	}

	@FXML
	void handleClicledNotification(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Notifications");
		Utilitaire.setTiteStage(primaryStage , "Notifications" , userConnected);
	}

	@FXML
	void handleClickedLogOut(MouseEvent event) {
		Utilitaire.logout(primaryStage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainController = MainController.getInstance();
	}

	public DepartementController getDepartementController() {
		return departementController;
	}

	public void setDepartementController(DepartementController departementController) {
		this.departementController = departementController;
	}

	public ServiceController getServiceController() {
		return serviceController;
	}

	public void setServiceController(ServiceController serviceController) {
		this.serviceController = serviceController;
	}

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}


	public AnchorPane getAnchorPaneCenter() {
		return anchorPaneCenter;
	}

	public void setAnchorPaneCenter(AnchorPane anchorPaneCenter) {
		this.anchorPaneCenter = anchorPaneCenter;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	@Override
	public void initData() {
		userConnected = Utilitaire.getConnectedUser(primaryStage);
		logger.info(userConnected.getFullName());
		Utilitaire.initData(userConnected, primaryStage, labelProfil, labelUsername, currentPage);
		primaryStage.setTitle(currentPage);
	}

}