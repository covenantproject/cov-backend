package org.covn.model.type;

public enum ResidencyStatus implements BaseEnum{
	other("residency_other"),
	permanent("residency_permanent"),
	asylee("residency_asylee"),
	refugee("residency_refugee"),
	temporary("residency_temporary"),
	visitor("residency_visitor"),
	citizen("residency_citizen"),
	;
	private final String key;
	private ResidencyStatus(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
