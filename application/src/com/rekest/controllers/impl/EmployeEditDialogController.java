package com.rekest.controllers.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rekest.entities.Service;
import com.rekest.entities.employes.Employe;
import com.rekest.exeptions.DAOException;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EmployeEditDialogController {

	@FXML
	private Button btnAnnuler;

	@FXML
	private Button btnOk;

	@FXML
	private Circle circlePhoto;

	@FXML
	private ComboBox<?> comboBoxProfil;

	@FXML
	private ComboBox<String> comboBoxService;

	@FXML
	private Label labelFenetre;

	@FXML
	private TextField textFieldAdresse;

	@FXML
	private TextField textFieldEmail;

	@FXML
	private TextField textFieldNom;

	@FXML
	private TextField textFieldPrenom;

	@FXML
	private TextField textFieldTelephone;

	private List<Service> servicesList ;

	private Stage dialogStage;

	private IFeature feature = Feature.getCurrentInstance();

	private Employe employe;

	private boolean okClicked = false;


	/**
	 * Sets the stage of this dialog.
	 * @param dialogStage
	 */
	 public void setDialogStage(Stage dialogStage) {
		 this.dialogStage = dialogStage;
	 }

	 /**
	  * Sets the employe to be edited in the dialog.
	  *
	  * @param employe
	  */
	 public void setEmploye(Employe employe) {
		 this.employe = employe;
		 textFieldNom.setText(employe.getNom());
		 textFieldPrenom.setText(employe.getPrenom());
		 textFieldAdresse.setText(employe.getAdresse());
		 textFieldEmail.setText(employe.getEmail());
		 textFieldTelephone.setText(employe.getTelephone());
		 //		comboBoxService.setItems(feature.OLService.getData());
	 }

	 public Employe getEmploye() {
		return employe;
	}

	/**
	  * Initialize the value of combox box service
	  * 
	  */
	 public void setServices() throws DAOException{

		 this.setServicesList(feature.listerServices());

		 comboBoxService.setItems(FXCollections.observableArrayList(serialize(getServicesList())));

	 }

	 /**
	  * Returns true if the employe clicked OK, false otherwise.
	  *
	  * @return
	  */
	 public boolean isOkClicked() {
		 return okClicked;
	 }

	 /**
	  * Called when the employe clicks ok.
	  */
	 @FXML
	 private void handleClickedOk() {
		 if (isInputValid()) {
			 employe.setNom(textFieldNom.getText());
			 employe.setPrenom(textFieldPrenom.getText());
			 employe.setAdresse(textFieldAdresse.getText());
			 employe.setEmail(textFieldEmail.getText());
			 employe.setTelephone(textFieldTelephone.getText());
			 
			 okClicked = true;
			 dialogStage.close();
		 }
	 }

	 /**
	  * Called when the user clicks cancel.
	  */
	 @FXML
	 private void handleClickedAnnuler() {
		 dialogStage.close();
		 reset();
	 }

	 /**
	  * Validates the user input in the text fields.
	  *
	  * @return true if the input is valid
	  */
	 private boolean isInputValid() {
		 String errorMessage = "";

		 if (textFieldNom.getText() == null || textFieldNom.getText().length() == 0) {
			 errorMessage += "Le nom de l'employe est invalide!\n";
		 }

		 if (textFieldPrenom.getText() == null || textFieldPrenom.getText().length() == 0) {
			 errorMessage += "Le prenom de l'employe est invalide!\n";
		 }

		 if (textFieldEmail.getText() == null || textFieldEmail.getText().length() == 0) {
			 errorMessage += "L'email de l'employe est invalide!\n";
		 }

		 if (textFieldAdresse.getText() == null || textFieldAdresse.getText().length() == 0) {
			 errorMessage += "L'adresse de l'employe est invalide!\n";
		 }

		 if (textFieldTelephone.getText() == null || textFieldTelephone.getText().length() == 0) {
			 errorMessage += "Le telephone de l'employe est invalide!\n";
		 }


		 if (errorMessage.length() == 0) {
			 return true;
		 } else {
			 // Show the error message.
			 com.rekest.utils.Utilitaire.alert(AlertType.WARNING, 
					 dialogStage, 
					 "Invalid Fields", 
					 "Please correct invalid fields", 
					 errorMessage);

			 return false;
		 }
	 }

	 public List<Service> getServicesList() {
		 return servicesList;
	 }

	 public void setServicesList(List<Service> servicesList) {
		 this.servicesList = servicesList;
	 }

	 /**
	  * Serialize a list of services 
	  * @param service list
	  * @return list of strings with service id and name only
	  */
	 public List<String> serialize(List<Service> serviceList){
		 
		 List<String> strings = new ArrayList<>();

		 for (Iterator<Service> iterator = serviceList.iterator(); iterator.hasNext();) {
			 Service service = (Service) iterator.next();
			 strings.add(service.getId() + " - " + service.getNom());
		 }
		 
		 return strings;
	 }

	 public void reset() {
		 this.servicesList = null;
		 comboBoxService.setItems(null);
	 }
}

