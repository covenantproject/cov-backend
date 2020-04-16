package com.covid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Address\"")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"AddressId\"")
	private long AddressId;
	
	@Column(name = "\"UserId\"")
	private long userId;
	
	@Column(name = "\"AddressType\"")
	private String AddressType;
	
	@Column(name = "\"CompanyName\"")
	private String CompanyName;
	
	@Column(name = "\"InCareOf\"")
	private String InCareOf;
	
	@Column(name = "\"AddressLine1\"")
	private String AddressLine1;
	
	@Column(name = "\"AddressLine2\"")
	private String AddressLine2;
	
	@Column(name = "\"AddressLine3\"")
	private String AddressLine3;
	
	@Column(name = "\"City\"")
	private String City;
	
	@Column(name = "\"DistrictCounty\"")
	private String  DistrictCounty;
	
	@Column(name = "\"State\"")
	private String State;
	
	@Column(name = "\"PostCode\"")
	private String PostCode;
	
	@Column(name = "\"Country\"")
	private String Country;

	public long getAddressId() {
		return AddressId;
	}

	public void setAddressId(long addressId) {
		AddressId = addressId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAddressType() {
		return AddressType;
	}

	public void setAddressType(String addressType) {
		AddressType = addressType;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getInCareOf() {
		return InCareOf;
	}

	public void setInCareOf(String inCareOf) {
		InCareOf = inCareOf;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return AddressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		AddressLine3 = addressLine3;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getDistrictCounty() {
		return DistrictCounty;
	}

	public void setDistrictCounty(String districtCounty) {
		DistrictCounty = districtCounty;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPostCode() {
		return PostCode;
	}

	public void setPostCode(String postCode) {
		PostCode = postCode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}
	
	

}
