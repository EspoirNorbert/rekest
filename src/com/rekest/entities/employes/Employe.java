package com.rekest.entities.employes;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="employe_profil", discriminatorType=DiscriminatorType.STRING, length=64)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="id_employe")
	protected int id;
	
	protected String nom;
	protected String prenom;
	protected String telephone;
	protected String email;
	protected String adresse;
	
	@Column(name="employe_profil", insertable=false, updatable=false)
	protected String employeProfil;

	public Employe(String nom, String prenom, String telephone, String email, String adresse, String employeProfil) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
		this.employeProfil = employeProfil;
	}
	
}
