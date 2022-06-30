package com.rekest.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProduitEditDialogController {

    @FXML
    private Button btnAnnuler;

    @FXML
    private Button btnOk;

    @FXML
    private ComboBox<?> comboBoxType;

    @FXML
    private Label labelNomFenetre;

    @FXML
    private TextArea textAreaDescription;

    @FXML
    private TextField textFieldNom;

    @FXML
    private TextField textFieldPrix;

    @FXML
    private TextField textFieldQuantite;

    @FXML
    void handleClickedAnnuler(ActionEvent event) {

    }

    @FXML
    void handleClickedOk(ActionEvent event) {

    }

}

