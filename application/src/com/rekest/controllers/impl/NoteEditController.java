package com.rekest.controllers.impl;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class NoteEditController implements Initializable {

	@FXML
	private Button btnAnnuler;

	@FXML
	private Button btnEmettre;

	@FXML
	private Button btnFermer;

	@FXML
	private Button btnAjoutNote;

	@FXML
	private TextArea textArea;

	private Stage dialogStage;

	private boolean okClicked = false;

	/**
	 * Sets the stage of this dialog.
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	void handleClickedCloturer(ActionEvent event) {
		dialogStage.close();
	}

	@FXML
	void handleClickedSoumettre(ActionEvent event) {

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}