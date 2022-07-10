package com.rekest.entities.employes;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@ToString
public class Administrateur extends Utilisateur {
	
	public Administrateur(String nom, String prenom, String telephone, String email, String adresse) {
		super(nom, prenom, telephone, email, adresse);
	}
	
	public Administrateur(String nom, String prenom) {
		super(nom, prenom);
	}

	
		
}
