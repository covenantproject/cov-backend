package org.covn.model.type;

public enum ClinicalTrialStatus implements BaseEnum{
	notinterested("clintrial_notinterested"),
	enrolled("clintrial_enrolled"),
	interested("clintrial_interested"),
	;
	private final String key;
	private ClinicalTrialStatus(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
