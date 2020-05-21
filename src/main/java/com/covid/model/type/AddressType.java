package com.covid.model.type;

public enum AddressType implements BaseEnum{
	residence("address_temporary_residence"),
	addressPermanentResidence("address_permanent_residence"),
	addressOther("address_other"),
	addressWork("address_work"),
	;
	private final String key;
	private AddressType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
