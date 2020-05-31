package org.covn.model.type;

public enum Title implements BaseEnum{
	mr("title_mr"),
	ms("title_ms"),
	miss("title_miss"),
	prof("title_prof"),
	mrs("title_mrs"),
	dr("title_dr"),
	;
	private final String key;
	private Title(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
