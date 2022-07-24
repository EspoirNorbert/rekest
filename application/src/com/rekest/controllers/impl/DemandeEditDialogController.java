package com.rekest.controllers.impl;


import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.rekest.entities.Demande;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class DemandeEditDialogController {

	@FXML
	private Button btnAnnuler;

	@FXML
	private Button btnSoumettre;

	@FXML
	private ComboBox<String> comboBoxEmploye;

	@FXML
	private ComboBox<String> comboBoxProduit;

	@FXML
	private ComboBox<String> comboBoxRecepteur;

	 @FXML
	 private Label labelNomFenetre;


	private Stage dialogStage;
	private Demande demande;
	private boolean okClicked = false;
	
	/**
	 * Sets the stage of this dialog.
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	/**
	 * Sets the department to be edited in the dialog.
	 *
	 * @param department
	 */
	public void setDemande(Demande demande) {
		this.demande = demande;
		//textFieldNom.setText(departement.getNom());
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}

	
	@FXML
	void handleClickedRejecter(ActionEvent event) {

	}

	@FXML
	void handleClickedSoumettre(ActionEvent event) {

	}

}
