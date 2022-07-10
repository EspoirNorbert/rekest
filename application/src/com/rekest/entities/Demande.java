package com.rekest.entities;

import java.sql.Date;
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
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Demande {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_demande")
	private int id;
	private String etat;
	
	@OneToOne(targetEntity = Produit.class , cascade = CascadeType.ALL)
	@JoinColumn(name = "id_produit")
	private Produit produit;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_demande")
	private List<Note> notes = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_demande")
	private List<Notification> notifications = new ArrayList<>();
	
	@Column(name = "created_at")
	private Date  createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
}
