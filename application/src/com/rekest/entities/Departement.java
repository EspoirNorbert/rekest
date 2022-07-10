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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor()
@NoArgsConstructor
public class Departement {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_departement")
	
	private int id;
	private String nom;
	
	@Transient
	private StringProperty spdNom;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_departement")
	private List<Service> services = new ArrayList<>();
	
	public Departement(String nom) {
		this.nom = nom;
		this.spdNom = new SimpleStringProperty(nom);
	}

	public Departement() {
		// TODO Auto-generated constructor stub
	}

	public static void copy(Departement oldDepartement, Departement newDepartment) {
		oldDepartement.setNom(newDepartment.getNom());
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

	public StringProperty getSpdNom() {
		return spdNom;
	}

	public void setSpdNom(StringProperty spdNom) {
		this.spdNom = spdNom;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	
}
