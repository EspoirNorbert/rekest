package com.rekest.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.rekest.entities.employes.Employe;
import com.rekest.exeptions.DAOException;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;
import com.rekest.utils.Utilitaire;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EmployeController implements Initializable {

	@FXML
	private Button btnAjouter;

	@FXML
	private Button btnModifier;

	@FXML
	private Button btnRecherche;

	@FXML
	private Button btnSupprimer;

	@FXML
	private TableColumn<Employe, String> columnAdresse;

	@FXML
	private TableColumn<Employe, String> columnEmail;

	@FXML
	private TableColumn<Employe, String> columnLogin;

	@FXML
	private TableColumn<Employe, String> columnNom;

	@FXML
	private TableColumn<Employe, String> columnPrenom;

	@FXML
	private TableColumn<Employe, String> columnProfil;

	@FXML
	private TableColumn<Employe, String> columnService;

	@FXML
	private TableColumn<Employe, String> columnTelephone;

	@FXML
	private Label countEmployes;

	@FXML
	private TableView<Employe> tableViewEmployes;

	@FXML
	private TextField textRecherche;

	private EmployeEditDialogController employeEditDialogController;

	private Stage primaryStage;

	private IFeature feature = Feature.getCurrentInstance();

	@FXML
	void handleClickedAjouter(ActionEvent event) {
		Employe tempEmp = new Employe();
		boolean okClicked = showEmployeEditDialog(tempEmp);
		if (okClicked) {
			tempEmp = employeEditDialogController.getEmploye();
			Boolean statut =  feature.creerEmploye(tempEmp);
			if (statut) {
				
			}
		}
	}

	@FXML
	void handleClickedModifier(ActionEvent event) {

	}

	@FXML
	void handleClickedRecherche(ActionEvent event) {

	}

	@FXML
	void handleClickedSupprimer(ActionEvent event) {

	}

	public boolean showEmployeEditDialog(Employe employe) {
		try {
			FXMLLoader loader = Utilitaire.initFXMLoader("EmployeEditDialog");
			AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);
			Stage dialogStage = Utilitaire.createDialog(root, this.primaryStage, "Creation d'un employe");

			// Set the employe into the controller.
			employeEditDialogController = loader.getController();
			employeEditDialogController.setDialogStage(dialogStage);
			employeEditDialogController.setEmploye(employe);
			employeEditDialogController.setServices();

			Utilitaire.showDialog(dialogStage);
			return employeEditDialogController.isOkClicked();
		} catch (Exception e) {
			Utilitaire.alert(AlertType.WARNING, 
					null, 
					"REKEST ERROR","Echec ",e.getMessage());
		}

		return false;
	}

	public void loadDataInTable() {
		// Add observable list data to the table
		ObservableList<Employe> employes = feature.loadEmployesObservableList();
		tableViewEmployes.setItems(employes);

		if (employes.size() > 0) tableViewEmployes.getSelectionModel().select(0);
	}

	public void showServices() throws DAOException {
		System.out.println("EmployeController.showServices()" + feature.listerServices());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadDataInTable();
	}
}
