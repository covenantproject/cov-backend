package org.covn.model.type;

public enum RequestStatus implements BaseEnum{
	inprogress("request_inprogress"),
	completed("request_completed"),
	none("request_none"),
	open("request_open"),
	;
	private final String key;
	private RequestStatus(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
