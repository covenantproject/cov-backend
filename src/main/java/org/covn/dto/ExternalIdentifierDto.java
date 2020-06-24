package org.covn.dto;

import org.covn.model.type.ExternalIdType;

public class ExternalIdentifierDto {
	// id document fields go into the external_identifier table
	private ExternalIdType idDocType; // Identification document type, e.g. passport, driving license, etc. CHECK CONSTRAINT
	private String idDocNum; // Identification document number
	private String idDocIssuingAuthority; // e.g. Country for pasport, state for driving license. 
	
	// note: we are not capturing issue and expiration date of identification document for release1 though db fields are present
	
	public ExternalIdType getIdDocType() {
		return idDocType;
	}
	public void setIdDocType(String ExternalIdType) {
		this.idDocType = idDocType;
	}
	public String getIdDocNum() {
		return idDocNum;
	}
	public void setIdDocNum(String idDocNum) {
		this.idDocNum = idDocNum;
	}
	public String getIdDocIssuingAuthority() {
		return idDocIssuingAuthority;
	}
	public void setIdDocIssuingAuthority(String idDocIssuingAuthority) {
		this.idDocIssuingAuthority = idDocIssuingAuthority;
	}
	
	
}
