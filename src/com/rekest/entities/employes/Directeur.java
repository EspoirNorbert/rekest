package com.rekest.entities.employes;

import jakarta.persistence.Entity;

@Entity
public class Directeur extends Manager {
	
	
	public Directeur(String nom, String prenom, String telephone, String email, String adresse,
			String employeProfil, String login, String password) {
		super(nom, prenom, telephone, email, adresse, employeProfil, login, password);
	}

	public Directeur(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}
	
	
	
	
}
