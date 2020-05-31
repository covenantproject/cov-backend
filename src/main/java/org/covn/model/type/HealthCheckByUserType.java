package org.covn.model.type;

public enum HealthCheckByUserType implements BaseEnum{
	healthcheckByAppSecUser("healthcheck_by_app_sec_user"),
	healthcheckByOther("healthcheck_by_other"),
	user("healthcheck_by_app_pri_user"),
	healthcheckByHealthPro("healthcheck_by_health_pro"),
	;
	private final String key;
	private HealthCheckByUserType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
