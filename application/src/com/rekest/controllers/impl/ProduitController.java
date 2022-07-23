package com.rekest.controllers.impl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProduitController {

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnRecherche;

    @FXML
    private Button btnSupprimer;

    @FXML
    private TableColumn<?, ?> columnDateCreation;

    @FXML
    private TableColumn<?, ?> columnDateMiseAJour;

    @FXML
    private TableColumn<?, ?> columnDescription;

    @FXML
    private TableColumn<?, ?> columnNom;

    @FXML
    private TableColumn<?, ?> columnPrix;

    @FXML
    private TableColumn<?, ?> columnQuantite;

    @FXML
    private TableColumn<?, ?> columnType;

    @FXML
    private Label countProduits;

    @FXML
    private TableView<?> tableViewProduits;

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

