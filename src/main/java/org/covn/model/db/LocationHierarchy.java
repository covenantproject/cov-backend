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
@Table(name = "location_hierarchy", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"location_id"})
})
public class LocationHierarchy extends BaseModel<LocationHierarchy, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id", nullable = false, length = 10)
	private Integer locationId;

	@Column(name = "location_name", nullable = true, length = 255)
	private String locationName;

	@Column(name = "location_abbr", nullable = true, length = 32)
	private String locationAbbr;

	@Column(name = "assign_patients", nullable = true)
	private Boolean assignPatients;

	@Column(name = "parent_location_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer parentLocationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_location_id")
	private LocationHierarchy parent;

	@Column(name = "country_code", nullable = true, length = 32)
	private String countryCode;

	@Column(name = "address_id", nullable = true, length = 10)
	private Integer addressId;

	@Column(name = "location_type", nullable = true, length = 32)
	private String locationType;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	private Set<LocationHierarchy> children;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "locationHierarchy")
	private Set<HealthPro> healthProSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "locationHierarchy")
	private Set<DeviceLocation> deviceLocationSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "locationHierarchy")
	private Set<PatientProviderRel> patientProviderRelSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "locationHierarchy")
	private Set<HealthCheckHistory> healthCheckHistorySet;


	public Integer getLocationId(){
		return this.locationId;
	}
	public LocationHierarchy setLocationId(Integer locationId){
		this.locationId = locationId;
		
		return this;
	}

	public String getLocationName(){
		return this.locationName;
	}
	public LocationHierarchy setLocationName(String locationName){
		this.locationName = locationName;
		
		return this;
	}

	public String getLocationAbbr(){
		return this.locationAbbr;
	}
	public LocationHierarchy setLocationAbbr(String locationAbbr){
		this.locationAbbr = locationAbbr;
		
		return this;
	}

	public Boolean getAssignPatients(){
		return this.assignPatients;
	}
	public LocationHierarchy setAssignPatients(Boolean assignPatients){
		this.assignPatients = assignPatients;
		
		return this;
	}

	public Integer getParentLocationId(){
		return this.parentLocationId;
	}
	public LocationHierarchy setParentLocationId(Integer parentLocationId){
		this.parentLocationId = parentLocationId;
		
		return this;
	}

	public LocationHierarchy getParent(){
		return this.parent;
	}
	public LocationHierarchy setParent(LocationHierarchy parent){
		this.parent = parent;
		this.parentLocationId = (this.parent == null)? null: this.parent.getLocationId();
		return this;
	}

	public String getCountryCode(){
		return this.countryCode;
	}
	public LocationHierarchy setCountryCode(String countryCode){
		this.countryCode = countryCode;
		
		return this;
	}

	public Integer getAddressId(){
		return this.addressId;
	}
	public LocationHierarchy setAddressId(Integer addressId){
		this.addressId = addressId;
		
		return this;
	}

	public String getLocationType(){
		return this.locationType;
	}
	public LocationHierarchy setLocationType(String locationType){
		this.locationType = locationType;
		
		return this;
	}

	public Set<LocationHierarchy> getChildren(){
		return this.children;
	}
	public LocationHierarchy setChildren(Set<LocationHierarchy> children){
		this.children = children;
		
		return this;
	}

	public Set<HealthPro> getHealthProSet(){
		return this.healthProSet;
	}
	public LocationHierarchy setHealthProSet(Set<HealthPro> healthProSet){
		this.healthProSet = healthProSet;
		
		return this;
	}

	public Set<DeviceLocation> getDeviceLocationSet(){
		return this.deviceLocationSet;
	}
	public LocationHierarchy setDeviceLocationSet(Set<DeviceLocation> deviceLocationSet){
		this.deviceLocationSet = deviceLocationSet;
		
		return this;
	}

	public Set<PatientProviderRel> getPatientProviderRelSet(){
		return this.patientProviderRelSet;
	}
	public LocationHierarchy setPatientProviderRelSet(Set<PatientProviderRel> patientProviderRelSet){
		this.patientProviderRelSet = patientProviderRelSet;
		
		return this;
	}

	public Set<HealthCheckHistory> getHealthCheckHistorySet(){
		return this.healthCheckHistorySet;
	}
	public LocationHierarchy setHealthCheckHistorySet(Set<HealthCheckHistory> healthCheckHistorySet){
		this.healthCheckHistorySet = healthCheckHistorySet;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.locationId;
	}

	
	public static LocationHierarchy of(){
		return new LocationHierarchy();
	}
	
	public static LocationHierarchy copy(LocationHierarchy src, int depth){
		LocationHierarchy copy = null;
		if(depth > 0){
			copy = new LocationHierarchy();
			copy.locationId = src.getLocationId();
			copy.locationName = src.getLocationName();
			copy.locationAbbr = src.getLocationAbbr();
			copy.assignPatients = src.getAssignPatients();
			copy.parentLocationId = src.getParentLocationId();
			copy.parent = (src.getParent() == null)? null : LocationHierarchy.copy(src.getParent(), --depth);
			copy.countryCode = src.getCountryCode();
			copy.addressId = src.getAddressId();
			copy.locationType = src.getLocationType();
		}
		return copy;
	}

	@Override
	public LocationHierarchy copy() {
		return copy(this, copyDepth);
	}	
}