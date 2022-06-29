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
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_departement")
	private List<Service> services = new ArrayList<>();
	
	public Departement(String nom) {
		this.nom = nom;
	}

	public static void copy(Departement departement, Departement newPerson) {
		
	}
	
}
