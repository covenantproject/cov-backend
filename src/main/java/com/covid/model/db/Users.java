package com.covid.model.db;

import javax.persistence.Entity;
import com.covid.model.BaseModel;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;
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
@Table(name = "users", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"user_id"})
})
public class Users extends BaseModel<Users, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, length = 10)
	private Integer userId;

	@Column(name = "title", nullable = true, length = 16)
	private String title;

	@Column(name = "first_name", nullable = true, length = 32)
	private String firstName;

	@Column(name = "middle_name", nullable = true, length = 32)
	private String middleName;

	@Column(name = "last_name", nullable = true, length = 32)
	private String lastName;

	@Column(name = "maiden_name", nullable = true, length = 32)
	private String maidenName;

	@Column(name = "display_name", nullable = true, length = 16)
	private String displayName;

	@Column(name = "ls_first_name", nullable = true, length = 32)
	private String lsFirstName;

	@Column(name = "ls_middle_name", nullable = true, length = 32)
	private String lsMiddleName;

	@Column(name = "ls_last_name", nullable = true, length = 32)
	private String lsLastName;

	@Column(name = "ls_maiden_name", nullable = true, length = 32)
	private String lsMaidenName;

	@Column(name = "ls_display_name", nullable = true, length = 16)
	private String lsDisplayName;

	@Column(name = "standard_name", nullable = true, length = 30)
	private String standardName;

	@Column(name = "suffix", nullable = true, length = 16)
	private String suffix;

	@Column(name = "degree", nullable = true, length = 16)
	private String degree;

	@Column(name = "date_of_birth", nullable = true, length = 29)
	private Timestamp dateOfBirth;

	@Column(name = "age_yrs", nullable = true, length = 5)
	private Integer ageYrs;

	@Column(name = "admin_gender", nullable = true, length = 32)
	private String adminGender;

	@Column(name = "biological_sex", nullable = true, length = 32)
	private String biologicalSex;

	@Column(name = "username", nullable = true, length = 32)
	private String username;

	@Column(name = "comments", nullable = true, length = 255)
	private String comments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<ExternalIdentifier> externalIdentifierSet;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "users")
	private Demographics demographics;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<UserPhoto> userPhotoSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phoneNumberByPrimaryUserId")
	private Set<PhoneNumber> phoneNumberByPrimaryUserIdSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emailAddressByUserId")
	private Set<EmailAddress> emailAddressByUserIdSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<HealthCheckHistory> healthCheckHistorySet;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "users")
	private HealthPro healthPro;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "users")
	private Patient patient;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<PatientRequestHistory> patientRequestHistorySet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phoneNumberByUserId")
	private Set<PhoneNumber> phoneNumberByUserIdSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Address> addressSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emailAddressByPrimaryUserId")
	private Set<EmailAddress> emailAddressByPrimaryUserIdSet;


	public Integer getUserId(){
		return this.userId;
	}
	public Users setUserId(Integer userId){
		this.userId = userId;
		
		return this;
	}

	public String getTitle(){
		return this.title;
	}
	public Users setTitle(String title){
		this.title = title;
		
		return this;
	}

	public String getFirstName(){
		return this.firstName;
	}
	public Users setFirstName(String firstName){
		this.firstName = firstName;
		
		return this;
	}

	public String getMiddleName(){
		return this.middleName;
	}
	public Users setMiddleName(String middleName){
		this.middleName = middleName;
		
		return this;
	}

	public String getLastName(){
		return this.lastName;
	}
	public Users setLastName(String lastName){
		this.lastName = lastName;
		
		return this;
	}

	public String getMaidenName(){
		return this.maidenName;
	}
	public Users setMaidenName(String maidenName){
		this.maidenName = maidenName;
		
		return this;
	}

	public String getDisplayName(){
		return this.displayName;
	}
	public Users setDisplayName(String displayName){
		this.displayName = displayName;
		
		return this;
	}

	public String getLsFirstName(){
		return this.lsFirstName;
	}
	public Users setLsFirstName(String lsFirstName){
		this.lsFirstName = lsFirstName;
		
		return this;
	}

	public String getLsMiddleName(){
		return this.lsMiddleName;
	}
	public Users setLsMiddleName(String lsMiddleName){
		this.lsMiddleName = lsMiddleName;
		
		return this;
	}

	public String getLsLastName(){
		return this.lsLastName;
	}
	public Users setLsLastName(String lsLastName){
		this.lsLastName = lsLastName;
		
		return this;
	}

	public String getLsMaidenName(){
		return this.lsMaidenName;
	}
	public Users setLsMaidenName(String lsMaidenName){
		this.lsMaidenName = lsMaidenName;
		
		return this;
	}

	public String getLsDisplayName(){
		return this.lsDisplayName;
	}
	public Users setLsDisplayName(String lsDisplayName){
		this.lsDisplayName = lsDisplayName;
		
		return this;
	}

	public String getStandardName(){
		return this.standardName;
	}
	public Users setStandardName(String standardName){
		this.standardName = standardName;
		
		return this;
	}

	public String getSuffix(){
		return this.suffix;
	}
	public Users setSuffix(String suffix){
		this.suffix = suffix;
		
		return this;
	}

	public String getDegree(){
		return this.degree;
	}
	public Users setDegree(String degree){
		this.degree = degree;
		
		return this;
	}

	public Timestamp getDateOfBirth(){
		return this.dateOfBirth;
	}
	public Users setDateOfBirth(Timestamp dateOfBirth){
		this.dateOfBirth = dateOfBirth;
		
		return this;
	}

	public Integer getAgeYrs(){
		return this.ageYrs;
	}
	public Users setAgeYrs(Integer ageYrs){
		this.ageYrs = ageYrs;
		
		return this;
	}

	public String getAdminGender(){
		return this.adminGender;
	}
	public Users setAdminGender(String adminGender){
		this.adminGender = adminGender;
		
		return this;
	}

	public String getBiologicalSex(){
		return this.biologicalSex;
	}
	public Users setBiologicalSex(String biologicalSex){
		this.biologicalSex = biologicalSex;
		
		return this;
	}

	public String getUsername(){
		return this.username;
	}
	public Users setUsername(String username){
		this.username = username;
		
		return this;
	}

	public String getComments(){
		return this.comments;
	}
	public Users setComments(String comments){
		this.comments = comments;
		
		return this;
	}

	public Set<ExternalIdentifier> getExternalIdentifierSet(){
		return this.externalIdentifierSet;
	}
	public Users setExternalIdentifierSet(Set<ExternalIdentifier> externalIdentifierSet){
		this.externalIdentifierSet = externalIdentifierSet;
		
		return this;
	}

	public Demographics getDemographics(){
		return this.demographics;
	}
	public Users setDemographics(Demographics demographics){
		this.demographics = demographics;
		
		return this;
	}

	public Set<UserPhoto> getUserPhotoSet(){
		return this.userPhotoSet;
	}
	public Users setUserPhotoSet(Set<UserPhoto> userPhotoSet){
		this.userPhotoSet = userPhotoSet;
		
		return this;
	}

	public Set<PhoneNumber> getPhoneNumberByPrimaryUserIdSet(){
		return this.phoneNumberByPrimaryUserIdSet;
	}
	public Users setPhoneNumberByPrimaryUserIdSet(Set<PhoneNumber> phoneNumberByPrimaryUserIdSet){
		this.phoneNumberByPrimaryUserIdSet = phoneNumberByPrimaryUserIdSet;
		
		return this;
	}

	public Set<EmailAddress> getEmailAddressByUserIdSet(){
		return this.emailAddressByUserIdSet;
	}
	public Users setEmailAddressByUserIdSet(Set<EmailAddress> emailAddressByUserIdSet){
		this.emailAddressByUserIdSet = emailAddressByUserIdSet;
		
		return this;
	}

	public Set<HealthCheckHistory> getHealthCheckHistorySet(){
		return this.healthCheckHistorySet;
	}
	public Users setHealthCheckHistorySet(Set<HealthCheckHistory> healthCheckHistorySet){
		this.healthCheckHistorySet = healthCheckHistorySet;
		
		return this;
	}

	public HealthPro getHealthPro(){
		return this.healthPro;
	}
	public Users setHealthPro(HealthPro healthPro){
		this.healthPro = healthPro;
		
		return this;
	}

	public Patient getPatient(){
		return this.patient;
	}
	public Users setPatient(Patient patient){
		this.patient = patient;
		
		return this;
	}

	public Set<PatientRequestHistory> getPatientRequestHistorySet(){
		return this.patientRequestHistorySet;
	}
	public Users setPatientRequestHistorySet(Set<PatientRequestHistory> patientRequestHistorySet){
		this.patientRequestHistorySet = patientRequestHistorySet;
		
		return this;
	}

	public Set<PhoneNumber> getPhoneNumberByUserIdSet(){
		return this.phoneNumberByUserIdSet;
	}
	public Users setPhoneNumberByUserIdSet(Set<PhoneNumber> phoneNumberByUserIdSet){
		this.phoneNumberByUserIdSet = phoneNumberByUserIdSet;
		
		return this;
	}

	public Set<Address> getAddressSet(){
		return this.addressSet;
	}
	public Users setAddressSet(Set<Address> addressSet){
		this.addressSet = addressSet;
		
		return this;
	}

	public Set<EmailAddress> getEmailAddressByPrimaryUserIdSet(){
		return this.emailAddressByPrimaryUserIdSet;
	}
	public Users setEmailAddressByPrimaryUserIdSet(Set<EmailAddress> emailAddressByPrimaryUserIdSet){
		this.emailAddressByPrimaryUserIdSet = emailAddressByPrimaryUserIdSet;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.userId;
	}

	
	public static Users of(){
		return new Users();
	}
}