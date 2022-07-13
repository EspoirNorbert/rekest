package com.rekest.observableList.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.rekest.entities.Demande;
import com.rekest.observableList.IObservableList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObservableListDemande implements IObservableList<Demande> {    
	
    private ObservableList<Demande> roleData = FXCollections.observableArrayList();

	@Override
	public ObservableList<Demande> getData() {
		return roleData;
	}

	@Override
	public void add(Demande entity) {
		roleData.add(entity);
	}

	public void delete(Demande entity) {
		roleData.remove(entity);
	}

	@Override
	public void update(Demande entity) {
		 int index = roleData.lastIndexOf(entity);
	        if (index >= 0) {
	            Demande.copy(roleData.get(index), entity);            
	        }
	}

	@Override
	public void delete(int id) {
		Predicate<Demande> predicate = person -> (person.getId() == id);
        Optional<Demande> person = roleData.stream().filter(predicate).findFirst();
        if (person != null) {
            roleData.remove(person.get());
        }
	}

	@Override
	public void setData(List<Demande> entities) {
		this.roleData.setAll(entities);
	}

	@Override
	public void clear() {
		this.roleData.clear();
	}

	@Override
	public void addAll(List<Object> entities) {
		 for(Object obj : entities) {
	            if (obj instanceof Demande) {
	                roleData.add((Demande)obj);
	            }
	        }
	}

	@Override
	public void refresh() {}

}