package org.covn.dto;

public class LocationAndRoleDto {
	
	private long locationId;
	private String locationName;
	private boolean assignPatients;
	private String userRole;
	private long parentLocationId;
	public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public boolean isAssignPatients() {
		return assignPatients;
	}
	public void setAssignPatients(boolean assignPatients) {
		this.assignPatients = assignPatients;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public long getParentLocationId() {
		return parentLocationId;
	}
	public void setParentLocationId(long parentLocationId) {
		this.parentLocationId = parentLocationId;
	}
	
	

}
