package org.covn.model.type;

public enum ProgressStatus implements BaseEnum{
	worse("healthprogress_getting_worse"),
	better("healthprogress_getting_better"),
	same("healthprogress_getting_same"),
	;
	private final String key;
	private ProgressStatus(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
