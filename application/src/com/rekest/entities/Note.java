package com.rekest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Note {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_note")
	private int id;
	
	@Transient
	private Demande demande;
	
	private String message;
	
	public Note() {}
	
	public Note(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Demande getDemande() {
		return demande;
	}

	@Override
	public String toString() {
		return "Note " +
				this.getDemande().getUtilisateur().getFullName() + " - " + this.getMessage()
				+ "]";
	}
	
	
}
