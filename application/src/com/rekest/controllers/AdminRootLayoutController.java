package com.rekest.controllers;

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


	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Espace d'administration - Admin connect�");
	}

	@FXML
	void handleClickedAccueil(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "AdminOverview");
	}

	@FXML
	void handleClickedDemande(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Demandes");
	}

	@FXML
	void handleClickedDepartement(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Departement");

	}

	@FXML
	void handleClickedEmploye(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Employes");
//		employeController = new EmployeController();
//		try {
//			employeController.loadDataInTable();
//		} catch (DAOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}


	@FXML
	void handleClickedParametre(MouseEvent event) {

		Utilitaire.loadPageInRootLayout(rootLayout, "Parametres");

	}

	@FXML
	void handleClickedProduit(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Produits");
	}

	@FXML
	void handleClickedRole(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Roles");
	}

	@FXML
	void handleClickedService(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Services");
	}

	@FXML
	void handleClicledNotification(MouseEvent event) {}

	@FXML
	void handleClickedLogOut(MouseEvent event) {
		mainController.initAuthentication(primaryStage);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainController = new MainController();
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

	
}