package org.covn.model.type;

public enum LocationCheckReason implements BaseEnum{
	routine("loccheck_reason_routine"),
	locchecReasonDeviceIdle("locchec_reason_device_idle"),
	random("loccheck_reason_random"),
	other("loccheck_reason_other"),
	;
	private final String key;
	private LocationCheckReason(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
