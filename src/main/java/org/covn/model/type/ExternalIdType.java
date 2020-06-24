package org.covn.model.type;

public enum ExternalIdType implements BaseEnum{
	medicalLicenseNum("id_medical_license_num"),
	pancardNumIn("id_pancard_num_in"),
	drivingLicense("id_driving_license"),
	patientnum("id_patientid_num"),
	taxId("id_tax_id"),
	aadhaarNumIn("id_aadhaar_num_in"),
	ssnUs("id_ssn_us"),
	other("id_other"),
	passport("id_passport"),
	nationalId("id_national_id"),
	ociNumIn("id_oci_num_in"),
	mrn("id_mrn"),
	;
	private final String key;
	private ExternalIdType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
