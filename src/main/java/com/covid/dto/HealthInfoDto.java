package com.covid.dto;

public class HealthInfoDto {
	
	private int userid;
	private boolean coughpresent;
	private boolean feverpresent;
	private boolean breathingdifficultypresent;
	private String progressstatus;
	private double temperature;
	private int heartrate;
	private int respiratoryrate;
	private int spo2;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public boolean isCoughpresent() {
		return coughpresent;
	}
	public void setCoughpresent(boolean coughpresent) {
		this.coughpresent = coughpresent;
	}
	public boolean isFeverpresent() {
		return feverpresent;
	}
	public void setFeverpresent(boolean feverpresent) {
		this.feverpresent = feverpresent;
	}
	public boolean isBreathingdifficultypresent() {
		return breathingdifficultypresent;
	}
	public void setBreathingdifficultypresent(boolean breathingdifficultypresent) {
		this.breathingdifficultypresent = breathingdifficultypresent;
	}
	public String getProgressstatus() {
		return progressstatus;
	}
	public void setProgressstatus(String progressstatus) {
		this.progressstatus = progressstatus;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public int getHeartrate() {
		return heartrate;
	}
	public void setHeartrate(int heartrate) {
		this.heartrate = heartrate;
	}
	public int getRespiratoryrate() {
		return respiratoryrate;
	}
	public void setRespiratoryrate(int respiratoryrate) {
		this.respiratoryrate = respiratoryrate;
	}
	public int getSpo2() {
		return spo2;
	}
	public void setSpo2(int spo2) {
		this.spo2 = spo2;
	}
	
	

}
