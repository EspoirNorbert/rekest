package com.rekest.entities.employes;

import java.util.ArrayList;
import java.util.List;

import com.rekest.entities.Demande;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Gestionnaire extends Utilisateur {
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_gestionnaire")
	private List<Demande> demandes_assignees = new ArrayList<>();
	
	public Gestionnaire(String nom, String prenom, String telephone, String email, String adresse) {
		super(nom, prenom, telephone, email, adresse);
	}
	
	public Gestionnaire(String nom, String prenom) {
		super(nom, prenom);		
	}

	public List<Demande> getDemandes_assignees() {
		return demandes_assignees;
	}

	public void setDemandes_assignees(List<Demande> demandes_assignees) {
		this.demandes_assignees = demandes_assignees;
	}
	
		
}
