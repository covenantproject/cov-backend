package com.covid.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import com.covid.model.BaseModel;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "health_pro", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"health_pro_id"})
})
public class HealthPro extends BaseModel<HealthPro, Integer> implements java.io.Serializable{

	@Id
	@Column(name = "health_pro_id", nullable = false, length = 10)
	private Integer healthProId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "health_pro_id")
	private Users users;

	@Column(name = "job_id", nullable = false, length = 10)
	private Integer jobId;

	@Column(name = "supervisor_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer supervisorId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supervisor_id")
	private HealthPro parent;

	@Column(name = "job_title", nullable = true, length = 32)
	private String jobTitle;

	@Column(name = "work_location_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer workLocationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_location_id")
	private LocationHierarchy locationHierarchy;

	@Column(name = "is_active", nullable = true)
	private Boolean isActive;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthPro")
	private Set<PatientProviderRel> patientProviderRelSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	private Set<HealthPro> children;


	public Integer getHealthProId(){
		return this.healthProId;
	}
	public HealthPro setHealthProId(Integer healthProId){
		this.healthProId = healthProId;
		
		return this;
	}

	public Users getUsers(){
		return this.users;
	}
	public HealthPro setUsers(Users users){
		this.users = users;
		this.healthProId = (this.users == null)? null: this.users.getUserId();
		return this;
	}

	public Integer getJobId(){
		return this.jobId;
	}
	public HealthPro setJobId(Integer jobId){
		this.jobId = jobId;
		
		return this;
	}

	public Integer getSupervisorId(){
		return this.supervisorId;
	}
	public HealthPro setSupervisorId(Integer supervisorId){
		this.supervisorId = supervisorId;
		
		return this;
	}

	public HealthPro getParent(){
		return this.parent;
	}
	public HealthPro setParent(HealthPro parent){
		this.parent = parent;
		this.supervisorId = (this.parent == null)? null: this.parent.getHealthProId();
		return this;
	}

	public String getJobTitle(){
		return this.jobTitle;
	}
	public HealthPro setJobTitle(String jobTitle){
		this.jobTitle = jobTitle;
		
		return this;
	}

	public Integer getWorkLocationId(){
		return this.workLocationId;
	}
	public HealthPro setWorkLocationId(Integer workLocationId){
		this.workLocationId = workLocationId;
		
		return this;
	}

	public LocationHierarchy getLocationHierarchy(){
		return this.locationHierarchy;
	}
	public HealthPro setLocationHierarchy(LocationHierarchy locationHierarchy){
		this.locationHierarchy = locationHierarchy;
		this.workLocationId = (this.locationHierarchy == null)? null: this.locationHierarchy.getLocationId();
		return this;
	}

	public Boolean getIsActive(){
		return this.isActive;
	}
	public HealthPro setIsActive(Boolean isActive){
		this.isActive = isActive;
		
		return this;
	}

	public Set<PatientProviderRel> getPatientProviderRelSet(){
		return this.patientProviderRelSet;
	}
	public HealthPro setPatientProviderRelSet(Set<PatientProviderRel> patientProviderRelSet){
		this.patientProviderRelSet = patientProviderRelSet;
		
		return this;
	}

	public Set<HealthPro> getChildren(){
		return this.children;
	}
	public HealthPro setChildren(Set<HealthPro> children){
		this.children = children;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.healthProId;
	}

	
	public static HealthPro of(){
		return new HealthPro();
	}
}