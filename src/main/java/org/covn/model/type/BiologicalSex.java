package org.covn.model.type;

public enum BiologicalSex implements BaseEnum{
	male("biosex_male"),
	other("biosex_other"),
	female("biosex_female"),
	;
	private final String key;
	private BiologicalSex(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
