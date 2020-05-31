package org.covn.model.type;

public enum HealthStatus implements BaseEnum{
	symptomatic("health_symptomatic"),
	severe("health_severe"),
	asymptomatic("health_asymptomatic"),
	;
	private final String key;
	private HealthStatus(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
