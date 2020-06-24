package org.covn.dto;

import org.covn.model.type.AddressType;

public class AddressDto {

	// address fields go into the address table
	private AddressType addressType; // Required - home, office. CHECK CONSTRAINT
	private String addressInCareOf; // optional
	private String addressCompanyName; // optional
	private String addressLine1; // required
	private String addressLine2; // optional 
	private String addressLine3; // optional
	private String addressCity; // required
	private String addressDistrict; // optional
	private String addressState; // required
	private String addressPostCode; // required
	private String addressCountry; // required
	
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	public String getAddressInCareOf() {
		return addressInCareOf;
	}
	public void setAddressInCareOf(String addressInCareOf) {
		this.addressInCareOf = addressInCareOf;
	}
	public String getAddressCompanyName() {
		return addressCompanyName;
	}
	public void setAddressCompanyName(String addressCompanyName) {
		this.addressCompanyName = addressCompanyName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressDistrict() {
		return addressDistrict;
	}
	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public String getAddressPostCode() {
		return addressPostCode;
	}
	public void setAddressPostCode(String addressPostCode) {
		this.addressPostCode = addressPostCode;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	
	
	
}
