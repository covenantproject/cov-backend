package org.covn.model.type;

public enum LocationServiceType implements BaseEnum{
	locserviceHighres("locservice_highres"),
	locserviceOther("locservice_other"),
	locserviceCellular("locservice_cellular"),
	gps("locservoce_gps"),
	;
	private final String key;
	private LocationServiceType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
