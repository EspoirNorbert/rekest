package com.rekest.controllers;

import com.rekest.entities.Service;
import com.rekest.utils.Utilitaire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private TableView<Service> tableViewServices;

    @FXML
    private TextField textRecherche;
    
    private Stage primaryStage;
    
    private ServiceEditDialogController serviceEditDialogController;
    

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


    @FXML
    void handleClickedAjouter(ActionEvent event) {
    	  Service tempService = new Service();
	      boolean okClicked = showServiceEditDialog(tempService);
	        if (okClicked) {
	        	//Service.getInstance().createPerson(tempPerson); 	
	        }
    }

    @FXML
    void handleClickedModifier(ActionEvent event) {
    	 Service selectedDepartement = 
				  tableViewServices.getSelectionModel().getSelectedItem();        
         
	        if (selectedDepartement != null) {
	            boolean okClicked = this.showServiceEditDialog(selectedDepartement);
	            if (okClicked) {
	            
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
    void handleClickedRecherche(ActionEvent event) {

    }

    @FXML
    void handleClickedSupprimer(ActionEvent event) {
    	int selectedIndex = Utilitaire
    						.getCurrentIndexTableView(tableViewServices, primaryStage);
    	if (selectedIndex !=0) {
    		
    	}
    }
    
    public boolean showServiceEditDialog(Service service) {
        try {
            FXMLLoader loader = Utilitaire.initFXMLoader("ServiceEditDialog");
            AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);
            Stage dialogStage = Utilitaire.createDialog(root, 
            			this.primaryStage, "Creation d'un service");

            // Set the department into the controller.
            serviceEditDialogController = loader.getController();
            serviceEditDialogController.setDialogStage(dialogStage);
            serviceEditDialogController.setService(service);
            
            Utilitaire.showDialog(dialogStage);
            return serviceEditDialogController.isOkClicked();
        } catch (Exception e) {
        	Utilitaire.alert(AlertType.WARNING, 
					null, 
					"REKEST ERROR","Echec ",e.getMessage());
        }
        
        return false;
    }

}

