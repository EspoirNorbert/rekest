package com.rekest.controllers;

import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.controlsfx.control.Notifications;

import com.rekest.entities.employes.Utilisateur;
import com.rekest.enums.NotificationType;
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
public class AdminRootLayoutController implements Initializable {

	public final static Logger logger = LogManager.getLogger(AdminRootLayoutController.class);

	private DepartementController departementController; 
	private ServiceController serviceController;      
	private MainController mainController;
	private EmployeController employeController;

	private Stage primaryStage;

	private BorderPane rootLayout;

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
	private Button btnParametre;

	@FXML
	private Button btnProduit;

	@FXML
	private Button btnRole;

	@FXML
	private Button btnService;

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
		this.initData();
	}
	
	private void setTitle(String currentPage) {
		this.primaryStage.setTitle(currentPage + " - " +
				Utilitaire.setUserWindowTitle(userConnected , "Admin")) ;
	}


	@FXML
	void handleClickedAccueil(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "AdminOverview");
		this.setTitle("Accueil");
	}

	@FXML
	void handleClickedDemande(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Demandes");
		this.setTitle("Demandes");
	}

	@FXML
	void handleClickedDepartement(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Departement");
		this.setTitle("Departement");
	}

	@FXML
	void handleClickedEmploye(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Employes");
		this.setTitle("Employe");
	}


	@FXML
	void handleClickedParametre(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Parametres");
		this.setTitle("Parametres");
	}

	@FXML
	void handleClickedProduit(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Produits");
		this.setTitle("Produits");
	}

	@FXML
	void handleClickedRole(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Roles");
		this.setTitle("Roles");
	}

	@FXML
	void handleClickedService(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Services");
		this.setTitle("Services");
	}

	@FXML
	void handleClicledNotification(MouseEvent event) {}

	@FXML
	void handleClickedLogOut(MouseEvent event) {
		mainController.initAuthentication(primaryStage);
		Utilitaire.notification(NotificationType.INFO, "Deconnexion", "Aurevoir a la prochaine !");

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

	public EmployeController getEmployeController() {
		return employeController;
	}

	public void setEmployeController(EmployeController employeController) {
		this.employeController = employeController;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
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
	
	private  void initData() {
		this.userConnected = (Utilisateur) this.primaryStage.getUserData();
		Utilitaire.setLabel(labelProfil, userConnected.getEmployeProfil());
		Utilitaire.setLabel(labelUsername, userConnected.getFullName());
		this.setTitle(currentPage);
	}

	
}