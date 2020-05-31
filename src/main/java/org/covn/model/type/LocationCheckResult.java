package org.covn.model.type;

public enum LocationCheckResult implements BaseEnum{
	success("loccheck_result_success"),
	failed("loccheck_result_failed"),
	delayedresponse("loccheck_result_delayedresponse"),
	;
	private final String key;
	private LocationCheckResult(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
