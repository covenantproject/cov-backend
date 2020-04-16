package com.covid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"HealthProfessional\"")
public class HealthProfessional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"HealthProfessionalId\"")
	private long healthProfessionalId;
	
	@Column(name = "\"UserId\"")
	private long userId;

	

	public long getHealthProfessionalId() {
		return healthProfessionalId;
	}

	public void setHealthProfessionalId(long healthProfessionalId) {
		this.healthProfessionalId = healthProfessionalId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	
}
