package com.rekest.controllers.impl;

import java.net.URL;
import java.util.ResourceBundle;

import com.rekest.entities.Demande;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefDepartement;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Directeur;
import com.rekest.entities.employes.DirecteurGeneral;
import com.rekest.entities.employes.Gestionnaire;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.enums.NotificationType;
import com.rekest.exeptions.DAOException;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;
import com.rekest.notificationmanager.impl.NotificationManager;
import com.rekest.utils.Utilitaire;

import javafx.collections.FXCollections;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DemandeController implements Initializable {

	/**
	 * Composant FXML
	 */
	@FXML private Button btnCloturer;
	@FXML private Button btnExporter;
	@FXML private Button btnImprimer;
	@FXML private Button btnRecherche;
	@FXML private Button btnRejeter;
	@FXML private Button btnSoumettre;
	@FXML private Button btnValider;
	@FXML private TableColumn<Demande, String> colomnProduitID;
	@FXML private TableColumn<Demande, String> columnEmploye;
	@FXML private TableColumn<Demande, String> columnEmployeID;
	@FXML private TableColumn<Demande, String> columnEtat;
	@FXML private TableColumn<Demande, String> columnReference;
	@FXML private TableColumn<Demande, String> columnUtilisateur;
	@FXML private TableColumn<Demande, String> columnUtilisateurID;
	@FXML private ComboBox<String> comboBoxFiltre;
	@FXML private Label countDemandes;
	@FXML private TableView<Demande> tableViewDemandes;
	@FXML private TextField textRecherche;

	/**
	 * Stage
	 */
	private Stage primaryStage;

	/**
	 * ATtributs
	 */
	private IFeature feature = Feature.getCurrentInstance();
	private Utilisateur auth;
	private DetailsDemandesController detailsDemandesController;

	private ObservableList<Demande> demandes = FXCollections.observableArrayList();

	private NotificationManager notificationManager = new NotificationManager();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initProperties();
		addDemandeObservableListToTheTable();
		refreshCount();
		addListeners();
	}

	private void addListeners() {}

	private void initProperties() {
		columnReference.setCellValueFactory(new PropertyValueFactory<>("id"));
		colomnProduitID.setCellValueFactory(new PropertyValueFactory<>("produitId"));
		columnEmployeID.setCellValueFactory(new PropertyValueFactory<>("employeId"));
		columnEmploye.setCellValueFactory(new PropertyValueFactory<>("nomEmploye"));
		columnUtilisateur.setCellValueFactory(new PropertyValueFactory<>("utilisateurId"));
		columnUtilisateurID.setCellValueFactory(new PropertyValueFactory<>("nomUtilisateur"));
		columnEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private void initHideField() {
		if(auth != null) {
			String profil = auth.getEmployeProfil();
			if (profil.equals(Administrateur.class.getSimpleName())) {
				Utilitaire.hideButton(btnCloturer , btnExporter , btnImprimer ,btnValider , btnRejeter);
			}
			if (profil.equals(Gestionnaire.class.getSimpleName())) {
				Utilitaire.hideButton(btnExporter , btnImprimer ,btnValider , btnRejeter);
			}
		}
	}

	public void setConnectedUser(Utilisateur auth) {
		this.auth = auth;
		initHideField();
	}


	private DemandeEditDialogController demandeEditDialogController;

	private void addDemandeObservableListToTheTable() {
		setDemandes(feature.loadDemandesObservableList());
		tableViewDemandes.setItems(getDemandes());

		if (getDemandes().size() > 0) 
			tableViewDemandes.getSelectionModel().select(0);

		refreshCount();	

	}

	public void refreshCount() {
		countDemandes.setText(String.valueOf(tableViewDemandes.getItems().size()));
	}

	@FXML
	void handleClickedCloturer(ActionEvent event) {}

	@FXML
	void handleClickedExporter(ActionEvent event) {}

	@FXML
	void handleClickedImprimer(ActionEvent event) {}

	@FXML
	void handleClickedRecherche(ActionEvent event) {}

	@FXML
	void handleClickedRejecter(ActionEvent event) {
		responseDemande("Rejeter");
	}

	private void responseDemande(String response) {
		Demande selectedDemande = tableViewDemandes.getSelectionModel().getSelectedItem();        

		if (selectedDemande != null) {
			String state  = selectedDemande.getEtat();
			if (state.equals("soumis")) {
				sendReponseDemand(auth.getEmployeProfil() , response , selectedDemande);
			} else {
				Utilitaire.notification(NotificationType.ERROR, 
						"Statut de la demande", 
						"La demande doit etre � l'etat soumis pour etre valider");
			}
		} else {
			Utilitaire.alert(AlertType.WARNING, primaryStage,
					"No Selection", 
					"No Demande Selected", 
					"Please select a Demand in the table.");
		}	
	}

	private void sendReponseDemand(String employeProfil , String response , Demande demand) {
		String changeStateText = "";
		
		if (response.equals("Rejeter"))
			changeStateText =  "Rejet�e";
		 
		else if (response.equals("Valider"))
			changeStateText  = "Approuv�e";
		
		else {
			Utilitaire.notification(NotificationType.ERROR, "Statut Invalid", 
					"Seule Approuver & Rejeter sont authoris�e");
			return ;
		}

		if(employeProfil.equals(ChefService.class.getSimpleName())) {
			feature.requestDemande(demand, changeStateText + "N1");

			try {
				notificationManager.createNotification(auth, demand, 
						"Une demand� a �t� valider par vous ");

				ChefDepartement chefDepartement = 
						auth.getService().getDepartement().getChefDepartement();

				notificationManager.createNotification(chefDepartement, demand, 
						"Une nouvelle demand� a �t� soumise a votre appreciation");

			} catch (DAOException e) {
				e.printStackTrace();
			}	
		}

		if(employeProfil.equals(ChefDepartement.class.getSimpleName())) {
			feature.requestDemande(demand,changeStateText+ "N2");
		} 

		if(employeProfil.equals(Directeur.class.getSimpleName())) {
			feature.requestDemande(demand,changeStateText+ "N3");
		} 

		if(employeProfil.equals(DirecteurGeneral.class.getSimpleName())) {
			feature.requestDemande(demand,changeStateText+ "N4");
			feature.creerNotification(null);
		}
	}

	@FXML
	void handleClickedSoumettre(ActionEvent event) {
		Demande tempDemande = new Demande();
		boolean okClicked = showDemandeEditDialog(tempDemande, "Creation d'une demande");
		if (okClicked) {
			Boolean statut = feature.createDemande(tempDemande.getUtilisateur(),  
					tempDemande , tempDemande.getEmploye());
			if(statut) {
				refreshCount();

			} else {
				Utilitaire.notification(NotificationType.ERROR, "Creation d'une demane", 
						"Une erreur est arriv� dans la creation de la demande .");
			}
		}

	}

	@FXML
	void handleClickedValider(ActionEvent event) {
		responseDemande("Valider");
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
			demandeEditDialogController.setAuth(auth);

			demandeEditDialogController.setEmployes();
			demandeEditDialogController.setProduits();

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
		Demande selectedDemande = 
				tableViewDemandes.getSelectionModel().getSelectedItem();        

		if (selectedDemande != null) {
			System.out.println(selectedDemande);

			showDetailsDemandeEditDialog(selectedDemande,"Details de la demande " + selectedDemande.getId());

		} else {
			// Nothing selected.
			Utilitaire.alert(AlertType.WARNING, primaryStage,
					"No Selection", 
					"No Demande Selected", 
					"Please select a Demand in the table.");
		}

	}


	private boolean showDetailsDemandeEditDialog(Demande demand, String title) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = Utilitaire.initFXMLoader("DetailsDemandes");
			AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);

			// Create the dialog Stage.
			Stage dialogStage = Utilitaire.createDialog(root, primaryStage, title);

			//System.out.println("DEMANDE "+ demande.getEtat() + " " + demande.getId());

			// Set the demande into the controller.
			detailsDemandesController = loader.getController();
			detailsDemandesController.setDialogStage(dialogStage);
			detailsDemandesController.setDemande(demand);
			//detailsDemandesController.setNotes();
			// Show the dialog and wait until the user closes it
			Utilitaire.showDialog(dialogStage);

			return detailsDemandesController.isOkClicked();
		} catch (Exception e) {
			e.printStackTrace();
			Utilitaire.alert(AlertType.WARNING, 
					null, 
					"REKEST ERROR","Echec ",e.getMessage());
		}

		return false;
	}


	public void setDemandes(ObservableList<Demande> demandes) {
		this.demandes = demandes;
	}


	public ObservableList<Demande> getDemandes() {
		return demandes;
	}



}

