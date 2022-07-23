package com.rekest.controllers.impl;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class NoteEditController implements Initializable {
	
	@FXML
    private Button btnAnnuler;

    @FXML
    private Button btnEmettre;

    @FXML
    private Button btnFermer;

    @FXML
    private TextArea textArea;

    @FXML
    void handleClickedCloturer(ActionEvent event) {

    }

    @FXML
    void handleClickedSoumettre(ActionEvent event) {

    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
