package org.covn.model.type;

public enum AdminGender implements BaseEnum{
	thirdGender("admingender_third_gender"),
	female("admingender_female"),
	male("admingender_male"),
	;
	private final String key;
	private AdminGender(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
