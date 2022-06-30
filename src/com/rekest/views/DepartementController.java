package com.rekest.views;

import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DepartementController {

	public Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	private Button btnAjouter;

	@FXML
	private Button btnModifier;

	@FXML
	private Button btnRechercher;

	@FXML
	private Button btnSupprimer;

	@FXML
	private TableColumn<?, ?> columnNom;

	@FXML
	private Label countDepartements;

	@FXML
	private TableView<?> tableViewDepartement;

	@FXML
	private TextField textRecherche;

	@FXML
	void handleClickedAjouter(ActionEvent event) {

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


}