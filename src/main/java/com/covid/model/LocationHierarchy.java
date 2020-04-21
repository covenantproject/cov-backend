package com.covid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"LocationHierarchy\"")
public class LocationHierarchy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"LocationId\"")
	private int LocationId;
	
	@Column(name = "\"LocationName\"")
	private String LocationName;
	
	@Column(name = "\"LocationAbbreviation\"")
	private String LocationAbbreviation;
	
	@Column(name = "\"AssignPatients\"")
	private boolean AssignPatients;
	
	@Column(name = "\"ParentLocationId\"")
	private int ParentLocationId;
	
	@Column(name = "\"CountryCode\"")
	private String CountryCode;

	public int getLocationId() {
		return LocationId;
	}

	public void setLocationId(int locationId) {
		LocationId = locationId;
	}

	public String getLocationName() {
		return LocationName;
	}

	public void setLocationName(String locationName) {
		LocationName = locationName;
	}

	public String getLocationAbbreviation() {
		return LocationAbbreviation;
	}

	public void setLocationAbbreviation(String locationAbbreviation) {
		LocationAbbreviation = locationAbbreviation;
	}

	public boolean isAssignPatients() {
		return AssignPatients;
	}

	public void setAssignPatients(boolean assignPatients) {
		AssignPatients = assignPatients;
	}

	public int getParentLocationId() {
		return ParentLocationId;
	}

	public void setParentLocationId(int parentLocationId) {
		ParentLocationId = parentLocationId;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	
	
	
	
	

}
