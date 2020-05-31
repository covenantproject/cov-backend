package org.covn.model.type;

public enum AppHeartbeatStatus implements BaseEnum{
	online("appheartbeat_online"),
	offline("appheartbeat_offline"),
	;
	private final String key;
	private AppHeartbeatStatus(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
