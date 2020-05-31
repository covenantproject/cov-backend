package org.covn.model.type;

public enum AllergenType implements BaseEnum{
	drug("allergy_drug"),
	food("allergy_food"),
	environmental("allergy_environmental"),
	;
	private final String key;
	private AllergenType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
