package com.rekest.controllers.impl;


import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.entities.Demande;
import com.rekest.entities.Note;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;
import com.rekest.utils.PropertyManager;
import com.rekest.utils.Utilitaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class DetailsDemandesController implements Initializable {

	/**
	 * Loggers
	 */
	public final static Logger logger = LogManager.getLogger(DetailsDemandesController.class);
	
	@FXML
	private Label demandeID;

	@FXML
	private Label demandeState;

	@FXML
	private Button btnSoumettre;

	@FXML
	private Label labelNomProduit;

	@FXML
	private Label labelNomEmploye;

	@FXML
	private Label labelNomUtilisateur;

	@FXML
	private Label labelEtat;
	
	@FXML
	private ListView<Note> listViewNotes;

	/**
	 * ObservableList
	*/
	private ObservableList<Note> noteList =  FXCollections.observableArrayList();;

	public void setNoteList(ObservableList<Note> noteList) {
		this.noteList = noteList;
	}
	
	public ObservableList<Note> getNoteList() {
		return noteList;
	}
	
	private Stage dialogStage;
	private Demande demande;
	private Utilisateur auth;
	
	private boolean okClicked = false;

	public Stage primaryStage;
	
	private IFeature feature = Feature.getCurrentInstance();

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setAuth(Utilisateur auth) {
		this.auth = auth;
	}

	private NoteEditController noteEditController;

	/*
	 * Sets the stage of this dialog.
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}


	/*
	 * Sets the department to be edited in the dialog.
	 *
	 * @param department
	 */
	public void setDemande(Demande demande) {
		this.demande = demande;
		Utilitaire.setLabel(demandeID, String.valueOf(demande.getId()));
		Utilitaire.setLabel(labelNomProduit, demande.getProduit().getNom());
		Utilitaire.setLabel(labelNomEmploye, demande.getNomUtilisateur());
		Utilitaire.setLabel(labelNomUtilisateur, demande.getNomEmploye());
		Utilitaire.setLabel(labelEtat, demande.getEtat());
		Utilitaire.setLabel(demandeState, "[" + demande.getEtat() + "]");
	}

	/**
	 * Returns true if the department clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	void handleClickedRejecter(ActionEvent event) {}

	@FXML
	void handleClickedSoumettre(ActionEvent event) {
		Note tempNote = new Note();
		
		boolean okClicked = showNoteEditDialog(tempNote, "Creation d'une note ");
		if (okClicked) {
			//logger.info("Note created {}" , tempNote.getMessage());
			//logger.info("Note associe a la demande {} ", demande.getId());
			Boolean statut = feature.createNote(auth , tempNote , demande);
			if(statut) {
				//refreshCount();
				initListView();
				Utilitaire.displayMessage(Note.class.getSimpleName(), true, "creation");
			}
			
		}
	}


	private boolean showNoteEditDialog(Note note, String title) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = Utilitaire.initFXMLoader("NoteEditDialog");
			AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);

			// Create the dialog Stage.
			Stage dialogStage = Utilitaire.createDialog(root, primaryStage, title);

			// Set the demande into the controller.
			noteEditController = loader.getController();
			noteEditController.setDialogStage(dialogStage);
			noteEditController.setNote(note);
		
			// Show the dialog and wait until the user closes it
			Utilitaire.showDialog(dialogStage);

			return noteEditController.isOkClicked();
		} catch (Exception e) {
			e.printStackTrace();
			Utilitaire.alert(AlertType.WARNING, 
					null, 
					"REKEST ERROR","Echec ",e.getMessage());
		}

		return false;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initListView();
	}

	private void initListView() {
		ObservableList<Note> notes = FXCollections.observableArrayList(feature.loadNoteObservableList());
		listViewNotes = new ListView<Note>(notes);
		for (Note note : notes) {
			System.out.println(note);
		}
	}

	public void loadNotifications() {
		noteList.clear();
		feature.listNotes().forEach(note -> noteList.add(note));

		listViewNotes.setCellFactory(new Callback<ListView<Note>, ListCell<Note>>() {

			@Override
			public ListCell<Note> call(ListView<Note> param) {
				ListCell<Note> cell = new ListCell<Note>() {

					protected void updateItem(Note item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setGraphic(new ImageView(new Image(PropertyManager.getInstance().getApplicationIcon())));
							setText(item.getMessage() + "laissé par " + item.getDemande().getUtilisateur().getFullName());
						}
					};
				};
				return cell;
			}
		});
		listViewNotes.setItems(noteList);
	}

}