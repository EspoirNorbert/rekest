package com.rekest.entities;

import java.sql.Date;

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
public class Notification {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_notification")
	private int id;
	
	private String message;
	
	@Column(name = "is_read")
	private boolean isRead = false;
	
	@Column(name = "created_at")
	private Date createAt;
	
	public Notification(String message) {
		this.message = message;
	}

}
