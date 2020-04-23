package com.covid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "\"UserRequestHistory\"")
public class UserRequestHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"UserRequestHistoryId\"")
	private long UserRequestHistoryId;
	
	@Column(name = "\"UserId\"")
	private int userId;
	
	@Column(name = "\"RequestType\"")
	private String RequestType;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "\"RequestDateTime\"")
	private Date RequestDateTime;
	
	@Column(name = "\"RequestStatus\"")
	private String RequestStatus;
	
	@Column(name = "\"RequestComments\"")
	private String RequestComments;
	
	@Column(name = "\"ResponseType\"")
	private String ResponseType;
	
	@Column(name = "\"ResponseUserId\"")
	private Long ResponseUserId;
	
	@Column(name = "\"ResponseDateTime\"")
	private Date ResponseDateTime;
	
	@Column(name = "\"ResponseComments\"")
	private String ResponseComments;

	public long getUserRequestHistoryId() {
		return UserRequestHistoryId;
	}

	public void setUserRequestHistoryId(long userRequestHistoryId) {
		UserRequestHistoryId = userRequestHistoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRequestType() {
		return RequestType;
	}

	public void setRequestType(String requestType) {
		RequestType = requestType;
	}

	public Date getRequestDateTime() {
		return RequestDateTime;
	}

	public void setRequestDateTime(Date requestDateTime) {
		RequestDateTime = requestDateTime;
	}

	public String getRequestStatus() {
		return RequestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		RequestStatus = requestStatus;
	}

	public String getRequestComments() {
		return RequestComments;
	}

	public void setRequestComments(String requestComments) {
		RequestComments = requestComments;
	}

	public String getResponseType() {
		return ResponseType;
	}

	public void setResponseType(String responseType) {
		ResponseType = responseType;
	}

	public Long getResponseUserId() {
		return ResponseUserId;
	}

	public void setResponseUserId(Long responseUserId) {
		ResponseUserId = responseUserId;
	}

	public Date getResponseDateTime() {
		return ResponseDateTime;
	}

	public void setResponseDateTime(Date responseDateTime) {
		ResponseDateTime = responseDateTime;
	}

	public String getResponseComments() {
		return ResponseComments;
	}

	public void setResponseComments(String responseComments) {
		ResponseComments = responseComments;
	}
	
	

}
