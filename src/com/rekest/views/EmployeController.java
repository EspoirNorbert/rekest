package com.rekest.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployeController {

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnRecherche;

    @FXML
    private Button btnSupprimer;

    @FXML
    private TableColumn<?, ?> columnAdresse;

    @FXML
    private TableColumn<?, ?> columnEmail;

    @FXML
    private TableColumn<?, ?> columnLogin;

    @FXML
    private TableColumn<?, ?> columnNom;

    @FXML
    private TableColumn<?, ?> columnPrenom;

    @FXML
    private TableColumn<?, ?> columnProfil;

    @FXML
    private TableColumn<?, ?> columnService;

    @FXML
    private TableColumn<?, ?> columnTelephone;

    @FXML
    private Label countEmployes;

    @FXML
    private TableView<?> tableViewEmployes;

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
