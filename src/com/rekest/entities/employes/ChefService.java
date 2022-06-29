package com.rekest.entities.employes;

import jakarta.persistence.Entity;

@Entity
public class ChefService extends Manager {
	
	public ChefService(String nom, String prenom, String telephone, String email, String adresse,
			String employeProfil, String login, String password) {
		super(nom, prenom, telephone, email, adresse, employeProfil, login, password);
	}
	
}
