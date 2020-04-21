package com.covid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "\"LocationHistory\"")
public class LocationHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"LocationHistoryId\"")
	private long LocationHistoryId;
	
	@Column(name = "\"UserId\"")
	private long userId;
	
	@Column(name = "\"Latitude\"")
	private double Latitude;
	
	@Column(name = "\"Longitude\"")
	private double Longitude;

	
	@Column(name = "\"Code\"")
	private String Code;

	public long getLocationHistoryId() {
		return LocationHistoryId;
	}

	public void setLocationHistoryId(long locationHistoryId) {
		LocationHistoryId = locationHistoryId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}
	
}
