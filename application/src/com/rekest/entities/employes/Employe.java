package com.rekest.entities.employes;

import java.util.ArrayList;
import java.util.List;

import com.rekest.entities.Demande;
import com.rekest.entities.Service;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

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
	
	@Column(unique = true)
	protected String telephone;
	
	@Column(unique = true)
	protected String email;
	
	protected String adresse;
	
	@Column(name="employe_profil", insertable=false, updatable=false)
	protected String employeProfil;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_employe")
	private List<Demande> demandes_soumises = new ArrayList<Demande>();
	
	@Transient
	private Service service;

	public Employe(String nom, String prenom, String telephone, String email, String adresse, String employeProfil) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
		this.employeProfil = employeProfil;
	}
	
	public Employe(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public void addDemandeSoumise (Demande demande) {
		this.demandes_soumises.add(demande);
	}

	public static void copy(Employe employe, Employe entity) {
		// TODO Auto-generated method stub
		
	}
	
}
