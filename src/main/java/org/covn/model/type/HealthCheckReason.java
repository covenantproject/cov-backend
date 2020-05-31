package org.covn.model.type;

public enum HealthCheckReason implements BaseEnum{
	other("healthcheck_reason_other"),
	deviceIdle("healthcheck_reason_device_idle"),
	userInit("healthcheck_reason_user_init"),
	routine("healthcheck_reason_routine"),
	proInit("healthcheck_reason_pro_init"),
	;
	private final String key;
	private HealthCheckReason(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
