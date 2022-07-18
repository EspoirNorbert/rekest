package com.rekest.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
public class Departement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_departement")
	private int id;
	
	@Column(unique = true)
	private String nom;
	
	@Transient
	private StringProperty stringPropertyNom;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_departement")
	private List<Service> services = new ArrayList<>();
	
	public Departement() {}
	
	public Departement(String nom) {
		this.nom = nom;
		this.stringPropertyNom = new SimpleStringProperty(nom);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public List<Service> getServices() {
		return services;
	}
	
	public void addService(Service service) {
		if(service != null) 
			this.services.add(service);
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public static void copy(Departement oldDepartement, Departement newDepartment) {
		oldDepartement.setNom(newDepartment.getNom());
	}

	public StringProperty getStringPropertyNom() {
		return stringPropertyNom;
	}
	
	public void setStringPropertyNom(StringProperty stringPropertyNom) {
		this.stringPropertyNom = stringPropertyNom;
	}
}
