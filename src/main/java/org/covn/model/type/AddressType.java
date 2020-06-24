package org.covn.model.type;

public enum AddressType implements BaseEnum{
	addressTemporaryResidence("address_temporary_residence"),
	addressPermanentResidence("address_permanent_residence"),
	addressWork("address_work"),
	addressOther("address_other"),
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
