package com.rekest.views;

import javafx.stage.Stage;
import lombok.Data;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.rekest.utils.Utilitaire;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

/**
 * RootLayout des windows Admins
 * @author hp
 */
@Data
public class AdminRootLayoutController implements Initializable {

	private DepartementController departementController; // MainController de UI Department
	private ServiceController serviceController;         // MainController de UI Servicr
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
		this.primaryStage.setTitle("Espace d'administration - Admin connecté");
	}
	
	@FXML
	void handleClickedAccueil(MouseEvent event) {
	     try {
			Utilitaire.loadPageInRootLayout(rootLayout, "Acceuil", this.getClass());
		} catch (Exception e) {
			Utilitaire.alert(AlertType.WARNING, 
					null, 
					"REKEST ERROR","Echec ",e.getMessage());
		}
	}

	@FXML
	void handleClickedDemande(MouseEvent event) {
		 try {
				Utilitaire.loadPageInRootLayout(rootLayout, "Demandes", this.getClass());
			} catch (IOException e) {
				Utilitaire.alert(AlertType.ERROR, 
						null, 
						"REKEST ERROR","Echec ",e.getMessage());
			}
	}

	@FXML
	void handleClickedDepartement(MouseEvent event) {
		 try {
				Utilitaire.loadPageInRootLayout(rootLayout, "Departement", this.getClass());
			} catch (IOException e) {
				Utilitaire.alert(AlertType.ERROR, 
						null, 
						"REKEST ERROR","Echec ",e.getMessage());
			}
	}

	@FXML
	void handleClickedEmploye(MouseEvent event) {
		 try {
				Utilitaire.loadPageInRootLayout(rootLayout, "Employes", this.getClass());
			} catch (IOException e) {
				Utilitaire.alert(AlertType.ERROR, 
						null, 
						"REKEST ERROR","Echec ",e.getMessage());
			}
	}

	@FXML
	void handleClickedParametre(MouseEvent event) {
		 try {
				Utilitaire.loadPageInRootLayout(rootLayout, "Parametres", this.getClass());
			} catch (IOException e) {
				Utilitaire.alert(AlertType.ERROR, 
						null, 
						"REKEST ERROR","Echec ",e.getMessage());
			}
	}

	@FXML
	void handleClickedProduit(MouseEvent event) {
		 try {
				Utilitaire.loadPageInRootLayout(rootLayout, "Produits", this.getClass());
			} catch (IOException e) {
				Utilitaire.alert(AlertType.ERROR, 
						null, 
						"REKEST ERROR","Echec ",e.getMessage());
			}
	}

	@FXML
	void handleClickedRole(MouseEvent event) {
		 try {
				Utilitaire.loadPageInRootLayout(rootLayout, "Roles", this.getClass());
			} catch (IOException e) {
				Utilitaire.alert(AlertType.ERROR, 
						null, 
						"REKEST ERROR","Echec ",e.getMessage());
			}
	}

	@FXML
	void handleClickedService(MouseEvent event) {
		 try {
				Utilitaire.loadPageInRootLayout(rootLayout, "Services", this.getClass());
			} catch (IOException e) {
				Utilitaire.alert(AlertType.ERROR, 
						null, 
						"REKEST ERROR","Echec ",e.getMessage());
			}
	}

	@FXML
	void handleClicledNotification(MouseEvent event) {
		
	}
	
	@FXML
	void handleClickedLogOut(MouseEvent event) {
		mainController.initAuthentication(primaryStage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainController = new MainController();
	}

}