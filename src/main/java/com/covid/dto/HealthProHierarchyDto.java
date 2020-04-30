package com.covid.dto;

public class HealthProHierarchyDto {
	
	private int healthProId;
	private String title;
	private String firstName;
	private String lastName;
	private String suffix;	
	private String healthProType;
	private String healthProJobTitle;
	private String healthProOfficeAddress;
	private int healthProLocationId;
	private int supervisorId;
	public int gethealthProId() {
		return healthProId;
	}
	public void sethealthProId(int healthProId) {
		this.healthProId = healthProId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getHealthProType() {
		return healthProType;
	}
	public void setHealthProType(String healthProType) {
		this.healthProType = healthProType;
	}
	public String getHealthProJobTitle() {
		return healthProJobTitle;
	}
	public void setHealthProJobTitle(String healthProJobTitle) {
		this.healthProJobTitle = healthProJobTitle;
	}
	public String getHealthProOfficeAddress() {
		return healthProOfficeAddress;
	}
	public void setHealthProOfficeAddress(String healthProOfficeAddress) {
		this.healthProOfficeAddress = healthProOfficeAddress;
	}
	public int getHealthProLocationId() {
		return healthProLocationId;
	}
	public void setHealthProLocationId(int healthProLocationId) {
		this.healthProLocationId = healthProLocationId;
	}
	public int getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}
}
