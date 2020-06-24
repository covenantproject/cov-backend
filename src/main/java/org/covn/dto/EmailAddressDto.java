package org.covn.dto;

import org.covn.model.type.EmailAddressType;

public class EmailAddressDto {
	// email fields go into the email_address table
	private String emailType; // optional for patients, required for health professionals, CHECK CONSTRAINT
	private EmailAddressType emailAddress; // validate input format. 
	private boolean isEmailPrimaryUser; // is this user the primary user of the email (false in some cases, e.g. when a child is added to a parent's or for office email address)
	private String emailPrimaryUserId; // optional, used for secondary users only
	
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public EmailAddressType getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(EmailAddressType emailAddress) {
		this.emailAddress = emailAddress;
	}
	public boolean isEmailPrimaryUser() {
		return isEmailPrimaryUser;
	}
	public void setEmailPrimaryUser(boolean isEmailPrimaryUser) {
		this.isEmailPrimaryUser = isEmailPrimaryUser;
	}
	public String getEmailPrimaryUserId() {
		return emailPrimaryUserId;
	}
	public void setEmailPrimaryUserId(String emailPrimaryUserId) {
		this.emailPrimaryUserId = emailPrimaryUserId;
	}
	
	
	
}
