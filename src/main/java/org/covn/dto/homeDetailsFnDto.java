package org.covn.dto;

import java.util.Date;

public class homeDetailsFnDto {
	
	private int patientid;
	private String firstname;
	private String lastname;
	private double latitude;
	private double longitude;
	private String emergencycontact1;
	private Date requestdatetime;
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getEmergencycontact1() {
		return emergencycontact1;
	}
	public void setEmergencycontact1(String emergencycontact1) {
		this.emergencycontact1 = emergencycontact1;
	}
	public Date getRequestdatetime() {
		return requestdatetime;
	}
	public void setRequestdatetime(Date requestdatetime) {
		this.requestdatetime = requestdatetime;
	}
	
	

}
