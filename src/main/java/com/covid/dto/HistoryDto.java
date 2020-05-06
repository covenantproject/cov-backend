package com.covid.dto;

public class HistoryDto {
	
	private Boolean ishealthupdated;
	private Boolean ishelpupdated;
	private Boolean hascough;
	private Boolean hasfever;
	private Boolean haschills;
	private Boolean hasbreathingissue;
	private String currenthealthstatus;
	private String temperature;
	private String heartrate;
	private String respiratoryrate;
	private String spo2;	
	private String requesttype;
	private String comments;
	private String timestamp;

	public Boolean getIshealthupdated() {
		return ishealthupdated;
	}
	public void setIshealthupdated(Boolean ishealthupdated) {
		this.ishealthupdated = ishealthupdated;
	}

	public Boolean getIshelpupdated() {
		return ishelpupdated;
	}
	public void setIshelpupdated(Boolean ishelpupdated) {
		this.ishelpupdated = ishelpupdated;
	}

	public Boolean getHascough() {
		return hascough;
	}
	public void setHascough(Boolean hascough) {
		this.hascough = hascough;
	}

	public Boolean getHasfever() {
		return hasfever;
	}
	public void setHasfever(Boolean hasfever) {
		this.hasfever = hasfever;
	}

	public Boolean getHaschills() {
		return haschills;
	}
	public void setHaschills(Boolean haschills) {
		this.haschills = haschills;
	}

	public Boolean getHasbreathingissue() {
		return hasbreathingissue;
	}
	public void setHasbreathingissue(Boolean hasbreathingissue) {
		this.hasbreathingissue = hasbreathingissue;
	}

	public String getCurrenthealthstatus() {
		return currenthealthstatus;
	}
	public void setCurrenthealthstatus(String currenthealthstatus) {
		this.currenthealthstatus = currenthealthstatus;
	}

	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHeartrate() {
		return heartrate;
	}
	public void setHeartrate(String heartrate) {
		this.heartrate = heartrate;
	}

	public String getRespiratoryrate() {
		return respiratoryrate;
	}
	public void setRespiratoryrate(String respiratoryrate) {
		this.respiratoryrate = respiratoryrate;
	}

	public String getSpo2() {
		return spo2;
	}
	public void setSpo2(String spo2) {
		this.spo2 = spo2;
	}

	public String getRequesttype() {
		return requesttype;
	}
	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}

	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
