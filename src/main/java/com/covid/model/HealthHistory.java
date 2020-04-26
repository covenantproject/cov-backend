package com.covid.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"HealthHistory\"")
public class HealthHistory {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"HealthHistoryId\"")
	private long HealthHistoryId;
	
	@Column(name = "\"UserId\"")
	private long UserId;
	
	@Column(name = "\"HealthDateTime\"")
	private Date HealthDateTime;
	
	@Column(name = "\"HasCough\"")
	private boolean HasCough;
	
	@Column(name = "\"HasFever\"")
	private boolean HasFever;
	
	@Column(name = "\"HasBreathDifficulty\"")
	private boolean HasBreathDifficulty;
	
	@Column(name = "\"Progress\"")
	private String Progress;
	
	@Column(name = "\"Temperature\"")
	private double Temperature;
	
	@Column(name = "\"HeartRate\"")
	private long HeartRate;
	
	@Column(name = "\"RespiratoryRate\"")
	private long RespiratoryRate;
	
	@Column(name = "\"Spo2\"")
	private long Spo2;
	
	@Column(name = "\"SystolicBp\"")
	private long SystolicBp;
	
	@Column(name = "\"DiastolicBp\"")
	private long DiastolicBp;
	
	@Column(name = "\"Comments\"")
	private String Comments;

	public long getHealthHistoryId() {
		return HealthHistoryId;
	}

	public long getUserId() {
		return UserId;
	}

	public Date getHealthDateTime() {
		return HealthDateTime;
	}

	public boolean isHasCough() {
		return HasCough;
	}

	public boolean isHasFever() {
		return HasFever;
	}

	public boolean isHasBreathDifficulty() {
		return HasBreathDifficulty;
	}

	

	public double getTemperature() {
		return Temperature;
	}

	public long getHeartRate() {
		return HeartRate;
	}

	public long getRespiratoryRate() {
		return RespiratoryRate;
	}

	public long getSpo2() {
		return Spo2;
	}

	public long getSystolicBp() {
		return SystolicBp;
	}

	public long getDiastolicBp() {
		return DiastolicBp;
	}

	public String getComments() {
		return Comments;
	}

	public void setHealthHistoryId(long healthHistoryId) {
		HealthHistoryId = healthHistoryId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public void setHealthDateTime(Date healthDateTime) {
		HealthDateTime = healthDateTime;
	}

	public void setHasCough(boolean hasCough) {
		HasCough = hasCough;
	}

	public void setHasFever(boolean hasFever) {
		HasFever = hasFever;
	}

	public void setHasBreathDifficulty(boolean hasBreathDifficulty) {
		HasBreathDifficulty = hasBreathDifficulty;
	}

	

	public void setTemperature(double temperature) {
		Temperature = temperature;
	}

	public void setHeartRate(long heartRate) {
		HeartRate = heartRate;
	}

	public void setRespiratoryRate(long respiratoryRate) {
		RespiratoryRate = respiratoryRate;
	}

	public void setSpo2(long spo2) {
		Spo2 = spo2;
	}

	public void setSystolicBp(long systolicBp) {
		SystolicBp = systolicBp;
	}

	public void setDiastolicBp(long diastolicBp) {
		DiastolicBp = diastolicBp;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public String getProgress() {
		return Progress;
	}

	public void setProgress(String progress) {
		Progress = progress;
	}
	
	
	
	
}
