package com.rekest.controllers;


import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class DemandeSoumissionController implements Initializable {

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

	@FXML
	void handleClickedRejecter(ActionEvent event) {

	}

	@FXML
	void handleClickedSoumettre(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
