package com.covid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Location\"")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"LocationId\"")
	private long locationId;
	
	@Column(name = "\"LocationName\"")
	private String LocationName;
	
	@Column(name = "\"ParentLocationId\"")
	private long ParentLocationId;

	

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return LocationName;
	}

	public void setLocationName(String locationName) {
		LocationName = locationName;
	}

	public long getParentLocationId() {
		return ParentLocationId;
	}

	public void setParentLocationId(long parentLocationId) {
		ParentLocationId = parentLocationId;
	}
	
	

}
