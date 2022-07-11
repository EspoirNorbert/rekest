package com.rekest.entities.employes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.rekest.entities.Demande;
import com.rekest.entities.Notification;
import com.rekest.entities.Role;
import com.rekest.utils.Utilitaire;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateur extends Employe {
	
	protected String login;
	protected String password;
	protected boolean isEnable = true;
	protected Date createdAt;
	
	public Utilisateur(String nom, String prenom) {
		super(nom, prenom);
		Utilitaire.generateLoginAndPassword(this);
	}
	
	public Utilisateur(String nom, String prenom, String telephone, String email, String adresse) {
		super(nom, prenom, telephone, email, adresse, null);
		Utilitaire.generateLoginAndPassword(this);
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_utilisateur")
	private List<Notification> notifications = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_utilisateur")
	private List<Demande> demandesCreees = new ArrayList<>();
	
	@ManyToMany(targetEntity =Role.class , cascade = CascadeType.ALL)
	@JoinTable(
			joinColumns = 		 { @JoinColumn(name = "id_utilisateur") }, 
			inverseJoinColumns = { @JoinColumn(name = "id_role") }
			)
	protected List<Role> roles = new ArrayList<>();
	
	public void addRole (Role role) {
		this.roles.add(role);
	}
	
	public void addDemandeCreee (Demande demande) {
		demandesCreees.add(demande);
	}
	
	public void addNotification (Notification notification) {
		notifications.add(notification);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Demande> getDemandesCreees() {
		return demandesCreees;
	}

	public void setDemandesCreees(List<Demande> demandesCreees) {
		this.demandesCreees = demandesCreees;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


}
