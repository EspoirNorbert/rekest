package com.rekest.controllers.impl;

import java.net.URL;
import java.util.ResourceBundle;

import com.rekest.entities.Demande;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.Gestionnaire;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.feature.IFeature;
import com.rekest.utils.Utilitaire;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DemandeController implements Initializable {

	@FXML
	private Button btnCloturer;

	@FXML
	private Button btnExporter;

	@FXML
	private Button btnImprimer;

	@FXML
	private Button btnRecherche;

	@FXML
	private Button btnRejeter;

	@FXML
	private Button btnSoumettre;

	@FXML
	private Button btnValider;

	@FXML
	private TableColumn<Demande, String> colomnProduitID;

	@FXML
	private TableColumn<Demande, String> columnEmploye;

	@FXML
	private TableColumn<Demande, String> columnEmployeID;

	@FXML
	private TableColumn<Demande, String> columnEtat;

	@FXML
	private TableColumn<Demande, String> columnReference;

	@FXML
	private TableColumn<Demande, String> columnUtilisateur;

	@FXML
	private TableColumn<Demande, String> columnUtilisateurID;

	@FXML
	private ComboBox<String> comboBoxFiltre;

	@FXML
	private Label countDemandes;

	@FXML
	private TableView<Demande> tableViewDemandes;

	@FXML
	private TextField textRecherche;

	public Stage primaryStage;

	private IFeature service;

	private Utilisateur connectedUser;

	private Demande demande;

	private DetailsDemandesController detailsDemandesController;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;

	}

	private void initHideField() {
		if(connectedUser != null) {
			String profil = connectedUser.getEmployeProfil();
			if (profil.equals(Administrateur.class.getSimpleName())) {
				Utilitaire.hideButton(btnCloturer , btnExporter , btnImprimer ,btnValider , btnRejeter);
			}
			if (profil.equals(Gestionnaire.class.getSimpleName())) {
				Utilitaire.hideButton(btnExporter , btnImprimer ,btnValider , btnRejeter);
			}
		}
	}

	public void setConnectedUser(Utilisateur connectedUser) {
		this.connectedUser = connectedUser;
		initHideField();
	}


	private DemandeEditDialogController demandeEditDialogController;


	private void addDemandeObservableListToTheTable() {
		// Add observable list data to the table
		ObservableList<Demande> demandes = service.loadDemandesObservableList();
		tableViewDemandes.setItems(demandes);
		if (demandes.size() > 0)
			tableViewDemandes.getSelectionModel().select(0);	

	}

	public void refreshCount() {
		countDemandes.setText(String.valueOf(tableViewDemandes.getItems().size()));

	}

	@FXML
	void handleClickedCloturer(ActionEvent event) {

	}

	@FXML
	void handleClickedExporter(ActionEvent event) {

	}

	@FXML
	void handleClickedImprimer(ActionEvent event) {

	}

	@FXML
	void handleClickedRecherche(ActionEvent event) {

	}

	@FXML
	void handleClickedRejecter(ActionEvent event) {

	}

	@FXML
	void handleClickedSoumettre(ActionEvent event) {
		Demande tempDemande = new Demande();
		boolean okClicked = showDemandeEditDialog(tempDemande, "Creation d'une demande");
		if (okClicked) {
			Boolean statut = service.createDemande(tempDemande);
			if(statut) {
				refreshCount();

			}
		}

	}

	@FXML
	void handleClickedValider(ActionEvent event) {

	}

	/**
	 * Opens a dialog to edit details for the specified person. If the user
	 * clicks OK, the changes are saved into the provided person object and true
	 * is returned.
	 *
	 * @param person the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showDemandeEditDialog(Demande demande, String title) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = Utilitaire.initFXMLoader("DemandeEditDialog");
			AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);

			// Create the dialog Stage.
			Stage dialogStage = Utilitaire.createDialog(root, primaryStage, title);

			// Set the demande into the controller.
			demandeEditDialogController = loader.getController();
			demandeEditDialogController.setDialogStage(dialogStage);
			demandeEditDialogController.setDemande(demande);
			
			demandeEditDialogController.setEmployes();
			demandeEditDialogController.setProduits();
			//demandeEditDialogController.setUsers();

			// Show the dialog and wait until the user closes it
			Utilitaire.showDialog(dialogStage);

			return demandeEditDialogController.isOkClicked();
		} catch (Exception e) {
			e.printStackTrace();
			Utilitaire.alert(AlertType.WARNING, 
					null, 
					"REKEST ERROR","Echec ",e.getMessage());
		}

		return false;
	}

	@FXML
	void handleClickedDetails(ActionEvent event) {
		showDetailsDemandeEditDialog("Creation d'une demande");
	}


	private boolean showDetailsDemandeEditDialog(String title) {
		// TODO Auto-generated method stub
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = Utilitaire.initFXMLoader("DetailsDemandes");
			AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);

			// Create the dialog Stage.
			Stage dialogStage = Utilitaire.createDialog(root, primaryStage, title);

			// Set the demande into the controller.
			detailsDemandesController = loader.getController();
			detailsDemandesController.setDialogStage(dialogStage);
			// detailsDemandesController.setDemande(demande);

			// Show the dialog and wait until the user closes it
			Utilitaire.showDialog(dialogStage);

			return detailsDemandesController.isOkClicked();
		} catch (Exception e) {
			Utilitaire.alert(AlertType.WARNING, 
					null, 
					"REKEST ERROR","Echec ",e.getMessage());
		}

		return false;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}

