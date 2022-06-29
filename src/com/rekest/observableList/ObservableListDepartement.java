package com.rekest.observableList;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.rekest.entities.Departement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObservableListDepartement {    
	
    private ObservableList<Departement> departementData = 
    		FXCollections.observableArrayList();

    /**
     * Returns the data as an observable list of departments.
     * @return
     */
    public ObservableList<Departement> getPersonData() {
        return departementData;
    }

    public void addPerson(Departement departement) {
    	departementData.add(departement);
    }
   
    public void deletePerson(Departement departement) {
    	departementData.remove(departement);
    }

    public void updatePerson(Departement newDepartment) {
        int index = departementData.lastIndexOf(newDepartment);
        if (index >= 0) {
            Departement.copy(departementData.get(index), newDepartment);            
        }
    }

    public void deletePerson(int id) {
        Predicate<Departement> predicate = departement -> (departement.getId() == id);
        Optional<Departement> departement = departementData.stream().filter(predicate).findFirst();
        if (departement != null) {
        	departementData.remove(departement.get());
        }
    }
   
    public void setDepartmentData (List<Departement> departments) {
        this.departementData.addAll(departments);
    }
   
    public void clear () {
        this.departementData.clear();
    }

    public void addAll(List<Object> entities) {
        for(Object obj : entities) {
            if (obj instanceof Departement) {
            	departementData.add((Departement)obj);
            }
        }
    }

	public void refresh() {}
	
}