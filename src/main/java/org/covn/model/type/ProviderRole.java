package org.covn.model.type;

public enum ProviderRole implements BaseEnum{
	patproreltypeQuarantineOfficer("patproreltype_quarantine_officer"),
	patproreltypePhysician("patproreltype_physician"),
	officer("patproreltype_screening_officer"),
	patproreltypeFieldWorker("patproreltype_field_worker"),
	patproreltypeOther("patproreltype_other"),
	patproreltypeNurse("patproreltype_nurse"),
	patproreltypeHomehealth("patproreltype_homehealth"),
	patproreltypeIsolationOfficer("patproreltype_isolation_officer"),
	patproreltypeLabtech("patproreltype_labtech"),
	;
	private final String key;
	private ProviderRole(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
