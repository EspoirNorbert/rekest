package com.rekest.controllers;

import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import com.rekest.entities.Departement;
import com.rekest.exeptions.DAOException;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.FeatureDepartement;
import com.rekest.utils.Utilitaire;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class DepartementController implements Initializable {

	@FXML
	private TableColumn<Departement, String> columnNom;
	
	@FXML
	private TableView<Departement> tableViewDepartement;

	@FXML
	private Label countDepartements;

	@FXML
	private TextField textRecherche;
	
	public Stage primaryStage;
	
	private IFeature service;
	
	private DepartementEditDialogController departementEditDialogController;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.service = FeatureDepartement.getInstance();
		// Initialize the department table.
        columnNom.setCellValueFactory(cellData -> cellData.getValue().getSpdNom());
        // add to ObservableList
        addDepartmentObservableListToTheTable();
     }
     
     private void addDepartmentObservableListToTheTable() {
     	// Add observable list data to the table
     	ObservableList<Departement> departements;
		try {
			departements = service.loadDepartementObservableList();
	     	tableViewDepartement.setItems(departements);
	         //Service.getInstance().refresh();
	 		if (departements.size() > 0)
	 			tableViewDepartement.getSelectionModel().select(0);	
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			Utilitaire.alert(AlertType.INFORMATION, primaryStage,
        			"Echec de recuperation de données ", 
        			"Data Error", 
        			e.getMessage());
		}
   					
 	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	void handleClickedAjouter(ActionEvent event) {
		  Departement tempDepartment = new Departement();
	      boolean okClicked = showDepartmentEditDialog(tempDepartment);
	        if (okClicked) {
	        	//Service.getInstance().createPerson(tempPerson);
	        	try {
					service.creerDepartement(tempDepartment);
				} catch (DAOException e) {
					Utilitaire.alert(AlertType.INFORMATION, primaryStage,
		        			"Echec de creation", 
		        			"Echec de creation d'un department", 
		        			e.getMessage());
				}
	        }
	}

	@FXML
	void handleClickedModifier(ActionEvent event) {
		  Departement selectedDepartement = 
				  tableViewDepartement.getSelectionModel().getSelectedItem();        
          
	        if (selectedDepartement != null) {
	            boolean okClicked = this.showDepartmentEditDialog(selectedDepartement);
	            if (okClicked) {
	            	try {
						service.modifierDepartement(selectedDepartement);
					} catch (DAOException e) {
						Utilitaire.alert(AlertType.INFORMATION, primaryStage,
			        			"Echec de modification", 
			        			"Echec de modification d'un department", 
			        			e.getMessage());
					}
	            }
	        } else {
	            // Nothing selected.
	        	Utilitaire.alert(AlertType.WARNING, primaryStage,
	        			"No Selection", 
	        			"No Person Selected", 
	        			"Please select a person in the table.");
	        }
	}
	
	@FXML
	void handleClickedSupprimer(ActionEvent event) {
		int selectedIndex = tableViewDepartement.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            // personTable.getItems().remove(selectedIndex);
            //Service.getInstance().deletePerson(personTable.getSelectionModel().getSelectedItem());
        	
        } else {
            // Nothing selected.
        	Utilitaire.alert(AlertType.WARNING, primaryStage,
        			"No Selection", 
        			"No Person Selected", 
        			"Please select a person in the table.");
        }
	}

	@FXML
	void handleClickedRecherche(ActionEvent event) {

	}

	

    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showDepartmentEditDialog(Departement department) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DepartementController.class.getResource("DepartementEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the department into the controller.
            departementEditDialogController = loader.getController();
            departementEditDialogController.setDialogStage(dialogStage);
            departementEditDialogController.setDepartement(department);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return departementEditDialogController.isOkClicked();
        } catch (Exception e) {
        	Utilitaire.alert(AlertType.WARNING, 
					null, 
					"REKEST ERROR","Echec ",e.getMessage());
        }
        
        return false;
    }

	
}