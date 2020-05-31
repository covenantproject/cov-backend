package org.covn.model.type;

public enum AllergySeverity implements BaseEnum{
	mild("severity_mild"),
	severe("severity_severe"),
	moderate("severity_moderate"),
	;
	private final String key;
	private AllergySeverity(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
