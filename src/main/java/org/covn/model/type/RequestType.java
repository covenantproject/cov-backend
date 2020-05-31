package org.covn.model.type;

public enum RequestType implements BaseEnum{
	medical("request_medical"),
	quarantine("request_quarantine"),
	supplies("request_supplies"),
	;
	private final String key;
	private RequestType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
