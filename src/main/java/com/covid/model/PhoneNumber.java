package com.covid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"PhoneNumber\"")
public class PhoneNumber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"PhoneNumberId\"")
	private long phoneNumberId;
	
	@Column(name = "\"UserId\"")
	private long userId;
	
	@Column(name = "\"PhoneType\"")
	private String PhoneType;
	
	@Column(name = "\"PhoneNumber\"")
	private String phoneNumber;
	
	@Column(name = "\"PersonalOrWork\"")
	private String PersonalOrWork;
	
	@Column(name = "\"IsPreferred\"")
	private Boolean IsPreferred;
	
	@Column(name = "\"IsPrimaryUser\"")
	private Boolean IsPrimaryUser;
	
	@Column(name = "\"PrimaryUserId\"")
	private Long PrimaryUserId;
	
	@Column(name = "\"HasInternetAccess\"")
	private Boolean HasInternetAccess;
	
	@Column(name = "\"HasSMSAccess\"")
	private Boolean HasSMSAccess;
	
	@Column(name = "\"HasWhatsAppAccess\"")
	private Boolean HasWhatsAppAccess;
	
	@Column(name = "\"HasTelegramAccess\"")
	private Boolean HasTelegramAccess;

	public long getPhoneNumberId() {
		return phoneNumberId;
	}

	public void setPhoneNumberId(long phoneNumberId) {
		this.phoneNumberId = phoneNumberId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPhoneType() {
		return PhoneType;
	}

	public void setPhoneType(String phoneType) {
		PhoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPersonalOrWork() {
		return PersonalOrWork;
	}

	public void setPersonalOrWork(String personalOrWork) {
		PersonalOrWork = personalOrWork;
	}

	public Boolean getPreferred() {
		return IsPreferred;
	}

	public void setPreferred(Boolean preferred) {
		IsPreferred = preferred;
	}

	public Boolean getPrimaryUser() {
		return IsPrimaryUser;
	}

	public void setPrimaryUser(Boolean primaryUser) {
		IsPrimaryUser = primaryUser;
	}

	public Long getPrimaryUserId() {
		return PrimaryUserId;
	}

	public void setPrimaryUserId(Long primaryUserId) {
		PrimaryUserId = primaryUserId;
	}

	public Boolean getHasInternetAccess() {
		return HasInternetAccess;
	}

	public void setHasInternetAccess(Boolean hasInternetAccess) {
		HasInternetAccess = hasInternetAccess;
	}

	public Boolean getHasSMSAccess() {
		return HasSMSAccess;
	}

	public void setHasSMSAccess(Boolean hasSMSAccess) {
		HasSMSAccess = hasSMSAccess;
	}

	public Boolean getHasWhatsAppAccess() {
		return HasWhatsAppAccess;
	}

	public void setHasWhatsAppAccess(Boolean hasWhatsAppAccess) {
		HasWhatsAppAccess = hasWhatsAppAccess;
	}

	public Boolean getHasTelegramAccess() {
		return HasTelegramAccess;
	}

	public void setHasTelegramAccess(Boolean hasTelegramAccess) {
		HasTelegramAccess = hasTelegramAccess;
	}
}
