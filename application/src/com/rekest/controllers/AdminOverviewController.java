package com.rekest.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.Data;

@Data
public class AdminOverviewController implements Initializable {

	@FXML
	private Label countDemandes;

	@FXML
	private Label countDepartements;

	@FXML
	private Label countEmployes;

	@FXML
	private Label countProduits;

	@FXML
	private Label countRoles;

	@FXML
	private Label countServices;
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		countDemandes.setText("0");
		countDepartements.setText("0");
		countEmployes.setText("0");
		countProduits.setText("0");
		countRoles.setText("0");
		countServices.setText("0");
	}



}
