package org.covn.model.type;

public enum PhoneType implements BaseEnum{
	work("phone_work"),
	mobile("phone_mobile"),
	other("phone_other"),
	home("phone_home"),
	;
	private final String key;
	private PhoneType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
