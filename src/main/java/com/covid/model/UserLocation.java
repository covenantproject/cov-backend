package com.covid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"UserLocation\"")
public class UserLocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="\"UserLocationId\"")
	private long UserLocationId;
	
	@Column(name="\"UserId\"")
	private long userId;
	
	@Column(name="\"RoleId\"")
	private long roleId;
	
	@Column(name="\"LocationId\"")
	private long locationId;

	public long getUserLocationId() {
		return UserLocationId;
	}

	public void setUserLocationId(long userLocationId) {
		UserLocationId = userLocationId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	
	

}
