package org.covn.model.type;

public enum DurationUnits implements BaseEnum{
	days("duration_days"),
	weeks("duration_weeks"),
	years("duration_years"),
	months("duration_months"),
	;
	private final String key;
	private DurationUnits(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
