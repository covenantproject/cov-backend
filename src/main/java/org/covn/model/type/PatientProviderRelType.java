package org.covn.model.type;

public enum PatientProviderRelType implements BaseEnum{
	screeningOfficer("patproreltype_screening_officer"),
	quarantineOfficer("patproreltype_quarantine_officer"),
	isolationOfficer("patproreltype_isolation_officer"),
	physician("patproreltype_physician"),
	nurse("patproreltype_nurse"),
	labTechnician("patproreltype_labtech"),
	fieldWorker("patproreltype_field_worker"),
	homeHealthProvider("patproreltype_homehealth"),
	other("patproreltype_other"),
	;
	private final String key;
	private PatientProviderRelType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
