package org.covn.model.type;

public enum PhotoType implements BaseEnum{
	selfie("phototype_selfie"),
	profile("phototype_profile"),
	officialid("phototype_officialid"),
	other("phototype_other"),
	;
	private final String key;
	private PhotoType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
