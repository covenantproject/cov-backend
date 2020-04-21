package com.covid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"AppHeartbeatHistory\"")
public class AppHeartbeatHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"AppHeartbeatHistoryId\"")
	private long AppHeartbeatHistoryId;
	
	@Column(name = "\"PrimaryUserId\"")
	private long primaryUserId;
	
	@Column(name = "\"DeviceId\"")
	private long DeviceId;
	
	@Column(name = "\"HeartbeatDateTime\"")
	private Date HeartbeatDateTime;
	
	@Column(name = "\"HeartBeatStatus\"")
	private String HeartBeatStatus;

	public long getAppHeartbeatHistoryId() {
		return AppHeartbeatHistoryId;
	}

	public void setAppHeartbeatHistoryId(long appHeartbeatHistoryId) {
		AppHeartbeatHistoryId = appHeartbeatHistoryId;
	}

	

	public long getPrimaryUserId() {
		return primaryUserId;
	}

	public void setPrimaryUserId(long primaryUserId) {
		this.primaryUserId = primaryUserId;
	}

	public long getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(long deviceId) {
		DeviceId = deviceId;
	}

	public Date getHeartbeatDateTime() {
		return HeartbeatDateTime;
	}

	public void setHeartbeatDateTime(Date heartbeatDateTime) {
		HeartbeatDateTime = heartbeatDateTime;
	}

	public String getHeartBeatStatus() {
		return HeartBeatStatus;
	}

	public void setHeartBeatStatus(String heartBeatStatus) {
		HeartBeatStatus = heartBeatStatus;
	}
	
}
