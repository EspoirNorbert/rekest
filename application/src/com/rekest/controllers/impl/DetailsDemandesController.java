package com.rekest.controllers.impl;


import java.net.URL;
import java.util.ResourceBundle;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.rekest.entities.Demande;
import com.rekest.entities.Departement;
import com.rekest.feature.IFeature;
import com.rekest.utils.Utilitaire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DetailsDemandesController {

	@FXML
	private Button btnAjouterNote;

	@FXML
	private Button btnEnvoyerNotifications;

	@FXML
	private Button btnFermer;

	@FXML
	private ComboBox<String> comboBoxEtatDemande;

	@FXML
	private Label labelFenetre;

	@FXML
	private TextField textFieldDescription;

	@FXML
	private TextField textFieldEmploye;

	@FXML
	private TextField textFieldNom;

	@FXML
	private TextField textFieldType;

	@FXML
	private TextField textFieldUtilisateur;

	private Stage dialogStage;
	private Demande demande;
	private boolean okClicked = false;

	public Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private NoteEditController noteEditController;

	/*
	 * Sets the stage of this dialog.
	 * @param dialogStage
	 */
	 public void setDialogStage(Stage dialogStage) {
		 this.dialogStage = dialogStage;
	 }


	 /*
	  * Sets the department to be edited in the dialog.
	  *
	  * @param department
	  */
	 public void setDemande(Demande demande) {
	 }

	 /**
	  * Returns true if the department clicked OK, false otherwise.
	  *
	  * @return
	  */
	 public boolean isOkClicked() {
		 return okClicked;
	 }

	 @FXML
	 void handleClickedRejecter(ActionEvent event) {

	 }

	 @FXML
	 void handleClickedSoumettre(ActionEvent event) {

	 }

	 @FXML
	 void handleClickedAjoutNote(ActionEvent event) {
		 showAjoutNoteEditDialog("Creation d'une note");
	 }

	 private boolean showAjoutNoteEditDialog(String title) {
		 // TODO Auto-generated method stub
		 try {
			 // Load the fxml file and create a new stage for the popup dialog.
			 FXMLLoader loader = Utilitaire.initFXMLoader("NoteEditDialog");
			 AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);

			 // Create the dialog Stage.
			 Stage dialogStage = Utilitaire.createDialog(root, primaryStage, title);

			 // Set the demande into the controller.
			 noteEditController = loader.getController();
			 noteEditController.setDialogStage(dialogStage);
			 // detailsDemandesController.setDemande(demande);

			 // Show the dialog and wait until the user closes it
			 Utilitaire.showDialog(dialogStage);

			 return noteEditController.isOkClicked();
		 } catch (Exception e) {
			 Utilitaire.alert(AlertType.WARNING, 
					 null, 
					 "REKEST ERROR","Echec ",e.getMessage());
		 }

		 return false;

	 }

}