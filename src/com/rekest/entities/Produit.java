package com.rekest.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produit {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_produit")
	private int id;
	private String nom;
	private double prix;
	private int quantite;
	private String type;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	public static void copy(Produit produit, Produit entity) {}
	
}
