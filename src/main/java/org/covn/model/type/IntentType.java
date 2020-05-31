package org.covn.model.type;

public enum IntentType implements BaseEnum{
	treatment("rxintent_treatment"),
	trial("rxintent_trial"),
	other("rxintent_other"),
	prophylaxis("rxintent_prophylaxis"),
	adjuant("rxintent_adjuant"),
	;
	private final String key;
	private IntentType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
