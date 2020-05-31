package org.covn.model.type;

public enum Covid19Status implements BaseEnum{
	deceased("seir_deceased"),
	exposed("seir_exposed"),
	susceptible("seir_susceptible"),
	infected("seir_infected"),
	recovered("seir_recovered"),
	;
	private final String key;
	private Covid19Status(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
