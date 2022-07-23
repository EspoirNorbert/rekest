package com.rekest.controllers.impl;

import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionnaireOverviewController implements Initializable {

	private Stage primaryStage;

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
	private TableColumn<?, ?> colomnProduitID;

	@FXML
	private TableColumn<?, ?> columnEmploye;

	@FXML
	private TableColumn<?, ?> columnEmployeID;

	@FXML
	private TableColumn<?, ?> columnEtat;

	@FXML
	private TableColumn<?, ?> columnReference;

	@FXML
	private TableColumn<?, ?> columnUtilisateur;

	@FXML
	private TableColumn<?, ?> columnUtilisateurID;

	@FXML
	private ComboBox<?> comboBoxFiltre;

	@FXML
	private Label countDemandes;

	@FXML
	private TableView<?> tableViewDemandes;

	@FXML
	private TextField textRecherche;

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

	}

	@FXML
	void handleClickedValider(ActionEvent event) {

	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
}
