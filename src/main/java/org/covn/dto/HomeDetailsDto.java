package org.covn.dto;

import java.util.Date;

public class HomeDetailsDto {
	
	private String healthofficername;
	private String healthofficerno;
	private String emergencyno;
	private Date lasthealthupdate;
	private double currentlatitude;
	private double currentlongitutude;
	public String getHealthofficername() {
		return healthofficername;
	}
	public void setHealthofficername(String healthofficername) {
		this.healthofficername = healthofficername;
	}
	public String getHealthofficerno() {
		return healthofficerno;
	}
	public void setHealthofficerno(String healthofficerno) {
		this.healthofficerno = healthofficerno;
	}
	public String getEmergencyno() {
		return emergencyno;
	}
	public void setEmergencyno(String emergencyno) {
		this.emergencyno = emergencyno;
	}
	public Date getLasthealthupdate() {
		return lasthealthupdate;
	}
	public void setLasthealthupdate(Date lasthealthupdate) {
		this.lasthealthupdate = lasthealthupdate;
	}
	public double getCurrentlatitude() {
		return currentlatitude;
	}
	public void setCurrentlatitude(double currentlatitude) {
		this.currentlatitude = currentlatitude;
	}
	public double getCurrentlongitutude() {
		return currentlongitutude;
	}
	public void setCurrentlongitutude(double currentlongitutude) {
		this.currentlongitutude = currentlongitutude;
	}
	
	

}
