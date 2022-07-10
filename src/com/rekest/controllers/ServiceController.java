package com.rekest.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ServiceController {

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnRecherche;

    @FXML
    private Button btnSupprimer;

    @FXML
    private TableColumn<?, ?> columnChefService;

    @FXML
    private TableColumn<?, ?> columnDepartementAssocie;

    @FXML
    private TableColumn<?, ?> columnNom;

    @FXML
    private Label countServices;

    @FXML
    private TableView<?> tableViewServices;

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

