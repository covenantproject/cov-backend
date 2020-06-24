package org.covn.dto;

public class PhoneNumberDto {
	// phone number fields go into the phone_number table
	private boolean isPreferredPhone;
	private String phoneType; // required, CHECK CONSTRAINT
	private String phoneNumFormatted; // validate input format. Allowed characters: {"0-9", " ", "-", "+", "x", "(", ")", ","}
	private String phoneNumber;
	private String phoneNumberExtension; // typically used for office phones
	private boolean isPhonePrimaryUser; // is this user the primary user of the phone (false in some cases, e.g. when a child is added to a parent's phone number as a secondary user)
	private String phonePrimaryUserId; // optional, used for secondary users only.
	private boolean phoneHasInternet; // optional
	private boolean phoneHasSMS; // optional
	private boolean phoneHasWhatsApp; // optional
	private boolean phoneHasTelegram; // optional
	private boolean phoneHasLocationService; // optional
	
	public boolean isPreferredPhone() {
		return isPreferredPhone;
	}
	public void setPreferredPhone(boolean isPreferredPhone) {
		this.isPreferredPhone = isPreferredPhone;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getPhoneNumFormatted() {
		return phoneNumFormatted;
	}
	public void setPhoneNumFormatted(String phoneNumFormatted) {
		this.phoneNumFormatted = phoneNumFormatted;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumberExtension() {
		return phoneNumberExtension;
	}
	public void setPhoneNumberExtension(String phoneNumberExtension) {
		this.phoneNumberExtension = phoneNumberExtension;
	}
	public boolean isPhonePrimaryUser() {
		return isPhonePrimaryUser;
	}
	public void setPhonePrimaryUser(boolean isPhonePrimaryUser) {
		this.isPhonePrimaryUser = isPhonePrimaryUser;
	}
	public String getPhonePrimaryUserId() {
		return phonePrimaryUserId;
	}
	public void setPhonePrimaryUserId(String phonePrimaryUserId) {
		this.phonePrimaryUserId = phonePrimaryUserId;
	}
	public boolean isPhoneHasInternet() {
		return phoneHasInternet;
	}
	public void setPhoneHasInternet(boolean phoneHasInternet) {
		this.phoneHasInternet = phoneHasInternet;
	}
	public boolean isPhoneHasSMS() {
		return phoneHasSMS;
	}
	public void setPhoneHasSMS(boolean phoneHasSMS) {
		this.phoneHasSMS = phoneHasSMS;
	}
	public boolean isPhoneHasWhatsApp() {
		return phoneHasWhatsApp;
	}
	public void setPhoneHasWhatsApp(boolean phoneHasWhatsApp) {
		this.phoneHasWhatsApp = phoneHasWhatsApp;
	}
	public boolean isPhoneHasTelegram() {
		return phoneHasTelegram;
	}
	public void setPhoneHasTelegram(boolean phoneHasTelegram) {
		this.phoneHasTelegram = phoneHasTelegram;
	}
	public boolean isPhoneHasLocationService() {
		return phoneHasLocationService;
	}
	public void setPhoneHasLocationService(boolean phoneHasLocationService) {
		this.phoneHasLocationService = phoneHasLocationService;
	}
	

}
