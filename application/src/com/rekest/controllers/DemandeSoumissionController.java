package com.rekest.controllers;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class DemandeSoumissionController implements Initializable {
	
	 @FXML
	    private Button btnAnnuler;

	    @FXML
	    private Button btnSoumettre;

	    @FXML
	    private ComboBox<?> comboBoxEmploye;

	    @FXML
	    private ComboBox<?> comboBoxProduit;

	    @FXML
	    private ComboBox<?> comboBoxRecepteur;

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
