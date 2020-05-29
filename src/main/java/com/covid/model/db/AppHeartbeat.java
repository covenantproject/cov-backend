package com.covid.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import com.covid.model.BaseModel;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "app_heartbeat", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"app_heartbeat_id"})
})
public class AppHeartbeat extends BaseModel<AppHeartbeat, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_heartbeat_id", nullable = false, length = 10)
	private Integer appHeartbeatId;

	@Column(name = "device_app_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer deviceAppId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_app_id")
	private PhoneDeviceApp phoneDeviceApp;

	@Column(name = "heartbeat_date_time", nullable = true, length = 29)
	private Timestamp heartbeatDateTime;

	@Column(name = "heart_beat_ip4_address", nullable = true, length = 16)
	private String heartBeatIp4Address;

	@Column(name = "heart_beat_ip6_address", nullable = true, length = 40)
	private String heartBeatIp6Address;

	@Column(name = "heartbeat_status", nullable = true, length = 10)
	private String heartbeatStatus;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appHeartbeat")
	private Set<HealthCheckHistory> healthCheckHistorySet;


	public Integer getAppHeartbeatId(){
		return this.appHeartbeatId;
	}
	public AppHeartbeat setAppHeartbeatId(Integer appHeartbeatId){
		this.appHeartbeatId = appHeartbeatId;
		
		return this;
	}

	public Integer getDeviceAppId(){
		return this.deviceAppId;
	}
	public AppHeartbeat setDeviceAppId(Integer deviceAppId){
		this.deviceAppId = deviceAppId;
		
		return this;
	}

	public PhoneDeviceApp getPhoneDeviceApp(){
		return this.phoneDeviceApp;
	}
	public AppHeartbeat setPhoneDeviceApp(PhoneDeviceApp phoneDeviceApp){
		this.phoneDeviceApp = phoneDeviceApp;
		this.deviceAppId = (this.phoneDeviceApp == null)? null: this.phoneDeviceApp.getDeviceAppId();
		return this;
	}

	public Timestamp getHeartbeatDateTime(){
		return this.heartbeatDateTime;
	}
	public AppHeartbeat setHeartbeatDateTime(Timestamp heartbeatDateTime){
		this.heartbeatDateTime = heartbeatDateTime;
		
		return this;
	}

	public String getHeartBeatIp4Address(){
		return this.heartBeatIp4Address;
	}
	public AppHeartbeat setHeartBeatIp4Address(String heartBeatIp4Address){
		this.heartBeatIp4Address = heartBeatIp4Address;
		
		return this;
	}

	public String getHeartBeatIp6Address(){
		return this.heartBeatIp6Address;
	}
	public AppHeartbeat setHeartBeatIp6Address(String heartBeatIp6Address){
		this.heartBeatIp6Address = heartBeatIp6Address;
		
		return this;
	}

	public String getHeartbeatStatus(){
		return this.heartbeatStatus;
	}
	public AppHeartbeat setHeartbeatStatus(String heartbeatStatus){
		this.heartbeatStatus = heartbeatStatus;
		
		return this;
	}

	public Set<HealthCheckHistory> getHealthCheckHistorySet(){
		return this.healthCheckHistorySet;
	}
	public AppHeartbeat setHealthCheckHistorySet(Set<HealthCheckHistory> healthCheckHistorySet){
		this.healthCheckHistorySet = healthCheckHistorySet;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.appHeartbeatId;
	}
	
	public static AppHeartbeat of(){
		return new AppHeartbeat();
	}
}