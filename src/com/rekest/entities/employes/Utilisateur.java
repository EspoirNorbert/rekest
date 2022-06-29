package com.rekest.entities.employes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.rekest.entities.Demande;
import com.rekest.entities.Notification;
import com.rekest.entities.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur extends Employe {
	
	protected String login;
	protected String password;
	protected boolean isEnable = true;
	protected Date createdAt;
	
	public Utilisateur (String login , String password) {
		this.login = login;
		this.password = password;
	}
	
	public Utilisateur(String nom, String prenom, String telephone, 
			String email, String adresse,String employeProfil , String login , 
			String password) {
		super(nom, prenom, telephone, email, adresse, employeProfil);
		this.login = login;
		this.password = password;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_utilisateur")
	private List<Notification> notifications = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_utilisateur")
	private List<Demande> demandesCreees = new ArrayList<>();
	
	@ManyToMany(targetEntity=Role.class, cascade=CascadeType.ALL)
	protected List<Role> roles = new ArrayList<>();
	
	public void addDemandeCreee (Demande demande) {
		demandesCreees.add(demande);
	}
	
	public void addNotification (Notification notification) {
		notifications.add(notification);
	}


}
