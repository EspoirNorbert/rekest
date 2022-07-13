package com.rekest.utils;

import java.io.File;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.rekest.feature.impl.Feature;

import javafx.scene.control.Alert.AlertType;

public class FileDemandeManager {


	/**
     * Returns the demande file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     * 
     * @return
     */
    public static File getDemandeFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(FileDemandeManager.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }
    
	/**
     * Saves the current demand data to the specified file.
     * 
     * @param file
	 * @param  
     */
    public static void saveDemandeDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(DemandeListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our demande data.
            DemandeListWrapper wrapper = new DemandeListWrapper();
            wrapper.setDemandes(Feature.getCurrentInstance().getCurrentDemandesObservableList());

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setDemandeFilePath(file);
        } catch (Exception e) { // catches ANY exception
        	Utilitaire.alert(AlertType.WARNING, null,
    			"Error",
    			"Could not save data", 
    			"Could not save data to file:\n" + file.getPath());
        }
    }
    
    /**
     * Loads demande data from the specified file. The current demande data will
     * be replaced.
     * 
     * @param file
     */
    public static void loadDemandeDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(DemandeListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            DemandeListWrapper wrapper = (DemandeListWrapper) um.unmarshal(file);
            Feature.getCurrentInstance().setDemandeList(wrapper.getDemandes());

            // Save the file path to the registry.
            setDemandeFilePath(file);

        } catch (Exception e) { // catches ANY exception
        	Utilitaire.alert(AlertType.WARNING, null,
    			"Error", 
    			"Could not load data", 
    			"Could not load data from file:\n" + file.getPath());
    	}
    }
    
    public static void loadLastOpenedDemandeFile () {
    	// Try to load last opened demande file.
        File file = getDemandeFilePath();
        if (file != null) {
            loadDemandeDataFromFile(file);
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     * 
     * @param file the file or null to remove the path
     * @param primaryStage 
     */
    public static boolean setDemandeFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(FileDemandeManager.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());
            return false;
        } else {
            prefs.remove("filePath");            
            return true;
        }
    }
	
}