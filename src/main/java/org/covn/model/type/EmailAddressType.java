package org.covn.model.type;

public enum EmailAddressType implements BaseEnum {
	emailPersonal("email_personal"),
	emailHome("email_home"),
	emailWork("email_work"),
	emailOther("email_other"),
	;
	
	private final String key;
	
	private EmailAddressType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
