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
	private String PhoneNumber;
	
	@Column(name = "\"PersonalOrWork\"")
	private String PersonalOrWork;
	
	@Column(name = "\"IsPreferred\"")
	private boolean IsPreferred;
	
	@Column(name = "\"IsPrimaryUser\"")
	private boolean IsPrimaryUser;
	
	@Column(name = "\"PrimaryUserId\"")
	private long PrimaryUserId;
	
	@Column(name = "\"HasInternetAccess\"")
	private boolean HasInternetAccess;
	
	@Column(name = "\"HasSMSAccess\"")
	private boolean HasSMSAccess;
	
	@Column(name = "\"HasWhatsAppAccess\"")
	private boolean HasWhatsAppAccess;
	
	@Column(name = "\"HasTelegramAccess\"")
	private boolean HasTelegramAccess;

	

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
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getPersonalOrWork() {
		return PersonalOrWork;
	}

	public void setPersonalOrWork(String personalOrWork) {
		PersonalOrWork = personalOrWork;
	}

	public boolean isIsPreferred() {
		return IsPreferred;
	}

	public void setIsPreferred(boolean isPreferred) {
		IsPreferred = isPreferred;
	}

	public boolean isIsPrimaryUser() {
		return IsPrimaryUser;
	}

	public void setIsPrimaryUser(boolean isPrimaryUser) {
		IsPrimaryUser = isPrimaryUser;
	}

	public long getPrimaryUserId() {
		return PrimaryUserId;
	}

	public void setPrimaryUserId(long primaryUserId) {
		PrimaryUserId = primaryUserId;
	}

	public boolean isHasInternetAccess() {
		return HasInternetAccess;
	}

	public void setHasInternetAccess(boolean hasInternetAccess) {
		HasInternetAccess = hasInternetAccess;
	}

	public boolean isHasSMSAccess() {
		return HasSMSAccess;
	}

	public void setHasSMSAccess(boolean hasSMSAccess) {
		HasSMSAccess = hasSMSAccess;
	}

	public boolean isHasWhatsAppAccess() {
		return HasWhatsAppAccess;
	}

	public void setHasWhatsAppAccess(boolean hasWhatsAppAccess) {
		HasWhatsAppAccess = hasWhatsAppAccess;
	}

	public boolean isHasTelegramAccess() {
		return HasTelegramAccess;
	}

	public void setHasTelegramAccess(boolean hasTelegramAccess) {
		HasTelegramAccess = hasTelegramAccess;
	}
	
	

}
