package org.covn.model.db;

import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;
import java.util.Date;
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
import org.covn.model.BaseModel;
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

	@Column(name = "ls_title", nullable = true, length = 16)
	private String lsTitle;

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

	@Column(name = "ls_suffix", nullable = true, length = 16)
	private String lsSuffix;

	@Column(name = "ls_degree", nullable = true, length = 16)
	private String lsDegree;

	@Column(name = "ls_alias_name_1", nullable = true, length = 32)
	private String lsAliasName1;

	@Column(name = "ls_alias_name_2", nullable = true, length = 32)
	private String lsAliasName2;

	@Column(name = "ns_title", nullable = true, length = 16)
	private String nsTitle;

	@Column(name = "ns_first_name", nullable = true, length = 32)
	private String nsFirstName;

	@Column(name = "ns_middle_name", nullable = true, length = 32)
	private String nsMiddleName;

	@Column(name = "ns_last_name", nullable = true, length = 32)
	private String nsLastName;

	@Column(name = "ns_maiden_name", nullable = true, length = 32)
	private String nsMaidenName;

	@Column(name = "ns_display_name", nullable = true, length = 16)
	private String nsDisplayName;

	@Column(name = "ns_suffix", nullable = true, length = 16)
	private String nsSuffix;

	@Column(name = "ns_degree", nullable = true, length = 16)
	private String nsDegree;

	@Column(name = "ns_alias_name_1", nullable = true, length = 32)
	private String nsAliasName1;

	@Column(name = "ns_alias_name_2", nullable = true, length = 32)
	private String nsAliasName2;

	@Column(name = "standard_name", nullable = true, length = 30)
	private String standardName;

	@Column(name = "date_of_birth", nullable = true, length = 13)
	private Date dateOfBirth;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByPrimaryUserId")
	private Set<PhoneNumber> phoneNumberByPrimaryUserIdSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUserId")
	private Set<EmailAddress> emailAddressByUserIdSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<HealthCheckHistory> healthCheckHistorySet;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "users")
	private Patient patient;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<PatientRequestHistory> patientRequestHistorySet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUserId")
	private Set<PhoneNumber> phoneNumberByUserIdSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Address> addressSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByPrimaryUserId")
	private Set<EmailAddress> emailAddressByPrimaryUserIdSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<HealthPro> healthProSet;


	public Integer getUserId(){
		return this.userId;
	}
	public Users setUserId(Integer userId){
		this.userId = userId;
		
		return this;
	}

	public String getLsTitle(){
		return this.lsTitle;
	}
	public Users setLsTitle(String lsTitle){
		this.lsTitle = lsTitle;
		
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

	public String getLsSuffix(){
		return this.lsSuffix;
	}
	public Users setLsSuffix(String lsSuffix){
		this.lsSuffix = lsSuffix;
		
		return this;
	}

	public String getLsDegree(){
		return this.lsDegree;
	}
	public Users setLsDegree(String lsDegree){
		this.lsDegree = lsDegree;
		
		return this;
	}

	public String getLsAliasName1(){
		return this.lsAliasName1;
	}
	public Users setLsAliasName1(String lsAliasName1){
		this.lsAliasName1 = lsAliasName1;
		
		return this;
	}

	public String getLsAliasName2(){
		return this.lsAliasName2;
	}
	public Users setLsAliasName2(String lsAliasName2){
		this.lsAliasName2 = lsAliasName2;
		
		return this;
	}

	public String getNsTitle(){
		return this.nsTitle;
	}
	public Users setNsTitle(String nsTitle){
		this.nsTitle = nsTitle;
		
		return this;
	}

	public String getNsFirstName(){
		return this.nsFirstName;
	}
	public Users setNsFirstName(String nsFirstName){
		this.nsFirstName = nsFirstName;
		
		return this;
	}

	public String getNsMiddleName(){
		return this.nsMiddleName;
	}
	public Users setNsMiddleName(String nsMiddleName){
		this.nsMiddleName = nsMiddleName;
		
		return this;
	}

	public String getNsLastName(){
		return this.nsLastName;
	}
	public Users setNsLastName(String nsLastName){
		this.nsLastName = nsLastName;
		
		return this;
	}

	public String getNsMaidenName(){
		return this.nsMaidenName;
	}
	public Users setNsMaidenName(String nsMaidenName){
		this.nsMaidenName = nsMaidenName;
		
		return this;
	}

	public String getNsDisplayName(){
		return this.nsDisplayName;
	}
	public Users setNsDisplayName(String nsDisplayName){
		this.nsDisplayName = nsDisplayName;
		
		return this;
	}

	public String getNsSuffix(){
		return this.nsSuffix;
	}
	public Users setNsSuffix(String nsSuffix){
		this.nsSuffix = nsSuffix;
		
		return this;
	}

	public String getNsDegree(){
		return this.nsDegree;
	}
	public Users setNsDegree(String nsDegree){
		this.nsDegree = nsDegree;
		
		return this;
	}

	public String getNsAliasName1(){
		return this.nsAliasName1;
	}
	public Users setNsAliasName1(String nsAliasName1){
		this.nsAliasName1 = nsAliasName1;
		
		return this;
	}

	public String getNsAliasName2(){
		return this.nsAliasName2;
	}
	public Users setNsAliasName2(String nsAliasName2){
		this.nsAliasName2 = nsAliasName2;
		
		return this;
	}

	public String getStandardName(){
		return this.standardName;
	}
	public Users setStandardName(String standardName){
		this.standardName = standardName;
		
		return this;
	}

	public Date getDateOfBirth(){
		return this.dateOfBirth;
	}
	public Users setDateOfBirth(Date dateOfBirth){
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

	public Set<HealthPro> getHealthProSet(){
		return this.healthProSet;
	}
	public Users setHealthProSet(Set<HealthPro> healthProSet){
		this.healthProSet = healthProSet;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.userId;
	}

	
	public static Users of(){
		return new Users();
	}
	
	public static Users copy(Users src, int depth){
		Users copy = null;
		if(depth > 0){
			copy = new Users();
			copy.userId = src.getUserId();
			copy.lsTitle = src.getLsTitle();
			copy.lsFirstName = src.getLsFirstName();
			copy.lsMiddleName = src.getLsMiddleName();
			copy.lsLastName = src.getLsLastName();
			copy.lsMaidenName = src.getLsMaidenName();
			copy.lsDisplayName = src.getLsDisplayName();
			copy.lsSuffix = src.getLsSuffix();
			copy.lsDegree = src.getLsDegree();
			copy.lsAliasName1 = src.getLsAliasName1();
			copy.lsAliasName2 = src.getLsAliasName2();
			copy.nsTitle = src.getNsTitle();
			copy.nsFirstName = src.getNsFirstName();
			copy.nsMiddleName = src.getNsMiddleName();
			copy.nsLastName = src.getNsLastName();
			copy.nsMaidenName = src.getNsMaidenName();
			copy.nsDisplayName = src.getNsDisplayName();
			copy.nsSuffix = src.getNsSuffix();
			copy.nsDegree = src.getNsDegree();
			copy.nsAliasName1 = src.getNsAliasName1();
			copy.nsAliasName2 = src.getNsAliasName2();
			copy.standardName = src.getStandardName();
			copy.dateOfBirth = src.getDateOfBirth();
			copy.ageYrs = src.getAgeYrs();
			copy.adminGender = src.getAdminGender();
			copy.biologicalSex = src.getBiologicalSex();
			copy.username = src.getUsername();
			copy.comments = src.getComments();
			copy.demographics = (src.getDemographics() == null)? null : Demographics.copy(src.getDemographics(), --depth);
			copy.patient = (src.getPatient() == null)? null : Patient.copy(src.getPatient(), --depth);
		}
		return copy;
	}

	@Override
	public Users copy() {
		return copy(this, copyDepth);
	}	
}