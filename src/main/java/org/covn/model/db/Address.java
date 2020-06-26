package org.covn.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import org.covn.model.BaseModel;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "address", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"address_id"})
})
public class Address extends BaseModel<Address, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", nullable = false, length = 10)
	private Integer addressId;

	@Column(name = "user_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users users;

	@Column(name = "address_type", nullable = true, length = 10)
	private String addressType;

	@Column(name = "company_name", nullable = true, length = 10)
	private String companyName;

	@Column(name = "in_care_of", nullable = true, length = 10)
	private String inCareOf;

	@Column(name = "address_line_1", nullable = true, length = 10)
	private String addressLine1;

	@Column(name = "address_line_2", nullable = true, length = 10)
	private String addressLine2;

	@Column(name = "address_line_3", nullable = true, length = 10)
	private String addressLine3;

	@Column(name = "city", nullable = true, length = 10)
	private String city;

	@Column(name = "district_county", nullable = true, length = 10)
	private String districtCounty;

	@Column(name = "state_territory", nullable = true, length = 10)
	private String stateTerritory;

	@Column(name = "post_code", nullable = true, length = 10)
	private String postCode;

	@Column(name = "country", nullable = true, length = 10)
	private String country;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	private Set<PatientGeofencedLocation> patientGeofencedLocationSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	private Set<DeviceLocation> deviceLocationSet;


	public Integer getAddressId(){
		return this.addressId;
	}
	public Address setAddressId(Integer addressId){
		this.addressId = addressId;
		
		return this;
	}

	public Integer getUserId(){
		return this.userId;
	}
	public Address setUserId(Integer userId){
		this.userId = userId;
		
		return this;
	}

	public Users getUsers(){
		return this.users;
	}
	public Address setUsers(Users users){
		this.users = users;
		this.userId = (this.users == null)? null: this.users.getUserId();
		return this;
	}

	public String getAddressType(){
		return this.addressType;
	}
	public Address setAddressType(String addressType){
		this.addressType = addressType;
		
		return this;
	}

	public String getCompanyName(){
		return this.companyName;
	}
	public Address setCompanyName(String companyName){
		this.companyName = companyName;
		
		return this;
	}

	public String getInCareOf(){
		return this.inCareOf;
	}
	public Address setInCareOf(String inCareOf){
		this.inCareOf = inCareOf;
		
		return this;
	}

	public String getAddressLine1(){
		return this.addressLine1;
	}
	public Address setAddressLine1(String addressLine1){
		this.addressLine1 = addressLine1;
		
		return this;
	}

	public String getAddressLine2(){
		return this.addressLine2;
	}
	public Address setAddressLine2(String addressLine2){
		this.addressLine2 = addressLine2;
		
		return this;
	}

	public String getAddressLine3(){
		return this.addressLine3;
	}
	public Address setAddressLine3(String addressLine3){
		this.addressLine3 = addressLine3;
		
		return this;
	}

	public String getCity(){
		return this.city;
	}
	public Address setCity(String city){
		this.city = city;
		
		return this;
	}

	public String getDistrictCounty(){
		return this.districtCounty;
	}
	public Address setDistrictCounty(String districtCounty){
		this.districtCounty = districtCounty;
		
		return this;
	}

	public String getStateTerritory(){
		return this.stateTerritory;
	}
	public Address setStateTerritory(String stateTerritory){
		this.stateTerritory = stateTerritory;
		
		return this;
	}

	public String getPostCode(){
		return this.postCode;
	}
	public Address setPostCode(String postCode){
		this.postCode = postCode;
		
		return this;
	}

	public String getCountry(){
		return this.country;
	}
	public Address setCountry(String country){
		this.country = country;
		
		return this;
	}

	public Set<PatientGeofencedLocation> getPatientGeofencedLocationSet(){
		return this.patientGeofencedLocationSet;
	}
	public Address setPatientGeofencedLocationSet(Set<PatientGeofencedLocation> patientGeofencedLocationSet){
		this.patientGeofencedLocationSet = patientGeofencedLocationSet;
		
		return this;
	}

	public Set<DeviceLocation> getDeviceLocationSet(){
		return this.deviceLocationSet;
	}
	public Address setDeviceLocationSet(Set<DeviceLocation> deviceLocationSet){
		this.deviceLocationSet = deviceLocationSet;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.addressId;
	}

	
	public static Address of(){
		return new Address();
	}
	
	public static Address copy(Address src, int depth){
		Address copy = null;
		if(depth > 0){
			copy = new Address();
			copy.addressId = src.getAddressId();
			copy.userId = src.getUserId();
			copy.users = (src.getUsers() == null)? null : Users.copy(src.getUsers(), --depth);
			copy.addressType = src.getAddressType();
			copy.companyName = src.getCompanyName();
			copy.inCareOf = src.getInCareOf();
			copy.addressLine1 = src.getAddressLine1();
			copy.addressLine2 = src.getAddressLine2();
			copy.addressLine3 = src.getAddressLine3();
			copy.city = src.getCity();
			copy.districtCounty = src.getDistrictCounty();
			copy.stateTerritory = src.getStateTerritory();
			copy.postCode = src.getPostCode();
			copy.country = src.getCountry();
		}
		return copy;
	}

	@Override
	public Address copy() {
		return copy(this, copyDepth);
	}	
}