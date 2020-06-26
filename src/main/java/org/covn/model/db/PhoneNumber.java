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
@Table(name = "phone_number", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"phone_number_id"})
})
public class PhoneNumber extends BaseModel<PhoneNumber, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_number_id", nullable = false, length = 10)
	private Integer phoneNumberId;

	@Column(name = "user_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users usersByUserId;

	@Column(name = "phone_type", nullable = false, length = 32)
	private String phoneType;

	@Column(name = "phone_number", nullable = true, length = 20)
	private String phoneNumber;

	@Column(name = "phone_number_extn", nullable = true, length = 8)
	private String phoneNumberExtn;

	@Column(name = "phone_number_formatted", nullable = true, length = 32)
	private String phoneNumberFormatted;

	@Column(name = "is_preferred", nullable = true)
	private Boolean isPreferred;

	@Column(name = "is_primary_user", nullable = true)
	private Boolean isPrimaryUser;

	@Column(name = "primary_user_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer primaryUserId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "primary_user_id")
	private Users usersByPrimaryUserId;

	@Column(name = "has_internet", nullable = true)
	private Boolean hasInternet;

	@Column(name = "has_sms", nullable = true)
	private Boolean hasSms;

	@Column(name = "has_whatsapp", nullable = true)
	private Boolean hasWhatsapp;

	@Column(name = "has_telegram", nullable = true)
	private Boolean hasTelegram;

	@Column(name = "provides_location", nullable = true)
	private Boolean providesLocation;

	@Column(name = "otp_code", nullable = true, length = 8)
	private String otpCode;

	@Column(name = "phone_hash", nullable = true, length = 1024)
	private String phoneHash;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phoneNumber")
	private Set<PhoneDeviceApp> phoneDeviceAppSet;


	public Integer getPhoneNumberId(){
		return this.phoneNumberId;
	}
	public PhoneNumber setPhoneNumberId(Integer phoneNumberId){
		this.phoneNumberId = phoneNumberId;
		
		return this;
	}

	public Integer getUserId(){
		return this.userId;
	}
	public PhoneNumber setUserId(Integer userId){
		this.userId = userId;
		
		return this;
	}

	public Users getUsersByUserId(){
		return this.usersByUserId;
	}
	public PhoneNumber setUsersByUserId(Users usersByUserId){
		this.usersByUserId = usersByUserId;
		this.userId = (this.usersByUserId == null)? null: this.usersByUserId.getUserId();
		return this;
	}

	public String getPhoneType(){
		return this.phoneType;
	}
	public PhoneNumber setPhoneType(String phoneType){
		this.phoneType = phoneType;
		
		return this;
	}

	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	public PhoneNumber setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
		
		return this;
	}

	public String getPhoneNumberExtn(){
		return this.phoneNumberExtn;
	}
	public PhoneNumber setPhoneNumberExtn(String phoneNumberExtn){
		this.phoneNumberExtn = phoneNumberExtn;
		
		return this;
	}

	public String getPhoneNumberFormatted(){
		return this.phoneNumberFormatted;
	}
	public PhoneNumber setPhoneNumberFormatted(String phoneNumberFormatted){
		this.phoneNumberFormatted = phoneNumberFormatted;
		
		return this;
	}

	public Boolean getIsPreferred(){
		return this.isPreferred;
	}
	public PhoneNumber setIsPreferred(Boolean isPreferred){
		this.isPreferred = isPreferred;
		
		return this;
	}

	public Boolean getIsPrimaryUser(){
		return this.isPrimaryUser;
	}
	public PhoneNumber setIsPrimaryUser(Boolean isPrimaryUser){
		this.isPrimaryUser = isPrimaryUser;
		
		return this;
	}

	public Integer getPrimaryUserId(){
		return this.primaryUserId;
	}
	public PhoneNumber setPrimaryUserId(Integer primaryUserId){
		this.primaryUserId = primaryUserId;
		
		return this;
	}

	public Users getUsersByPrimaryUserId(){
		return this.usersByPrimaryUserId;
	}
	public PhoneNumber setUsersByPrimaryUserId(Users usersByPrimaryUserId){
		this.usersByPrimaryUserId = usersByPrimaryUserId;
		this.primaryUserId = (this.usersByPrimaryUserId == null)? null: this.usersByPrimaryUserId.getUserId();
		return this;
	}

	public Boolean getHasInternet(){
		return this.hasInternet;
	}
	public PhoneNumber setHasInternet(Boolean hasInternet){
		this.hasInternet = hasInternet;
		
		return this;
	}

	public Boolean getHasSms(){
		return this.hasSms;
	}
	public PhoneNumber setHasSms(Boolean hasSms){
		this.hasSms = hasSms;
		
		return this;
	}

	public Boolean getHasWhatsapp(){
		return this.hasWhatsapp;
	}
	public PhoneNumber setHasWhatsapp(Boolean hasWhatsapp){
		this.hasWhatsapp = hasWhatsapp;
		
		return this;
	}

	public Boolean getHasTelegram(){
		return this.hasTelegram;
	}
	public PhoneNumber setHasTelegram(Boolean hasTelegram){
		this.hasTelegram = hasTelegram;
		
		return this;
	}

	public Boolean getProvidesLocation(){
		return this.providesLocation;
	}
	public PhoneNumber setProvidesLocation(Boolean providesLocation){
		this.providesLocation = providesLocation;
		
		return this;
	}

	public String getOtpCode(){
		return this.otpCode;
	}
	public PhoneNumber setOtpCode(String otpCode){
		this.otpCode = otpCode;
		
		return this;
	}

	public String getPhoneHash(){
		return this.phoneHash;
	}
	public PhoneNumber setPhoneHash(String phoneHash){
		this.phoneHash = phoneHash;
		
		return this;
	}

	public Set<PhoneDeviceApp> getPhoneDeviceAppSet(){
		return this.phoneDeviceAppSet;
	}
	public PhoneNumber setPhoneDeviceAppSet(Set<PhoneDeviceApp> phoneDeviceAppSet){
		this.phoneDeviceAppSet = phoneDeviceAppSet;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.phoneNumberId;
	}

	
	public static PhoneNumber of(){
		return new PhoneNumber();
	}
	
	public static PhoneNumber copy(PhoneNumber src, int depth){
		PhoneNumber copy = null;
		if(depth > 0){
			copy = new PhoneNumber();
			copy.phoneNumberId = src.getPhoneNumberId();
			copy.userId = src.getUserId();
			copy.usersByUserId = (src.getUsersByUserId() == null)? null : Users.copy(src.getUsersByUserId(), --depth);
			copy.phoneType = src.getPhoneType();
			copy.phoneNumber = src.getPhoneNumber();
			copy.phoneNumberExtn = src.getPhoneNumberExtn();
			copy.phoneNumberFormatted = src.getPhoneNumberFormatted();
			copy.isPreferred = src.getIsPreferred();
			copy.isPrimaryUser = src.getIsPrimaryUser();
			copy.primaryUserId = src.getPrimaryUserId();
			copy.usersByPrimaryUserId = (src.getUsersByPrimaryUserId() == null)? null : Users.copy(src.getUsersByPrimaryUserId(), --depth);
			copy.hasInternet = src.getHasInternet();
			copy.hasSms = src.getHasSms();
			copy.hasWhatsapp = src.getHasWhatsapp();
			copy.hasTelegram = src.getHasTelegram();
			copy.providesLocation = src.getProvidesLocation();
			copy.otpCode = src.getOtpCode();
			copy.phoneHash = src.getPhoneHash();
		}
		return copy;
	}

	@Override
	public PhoneNumber copy() {
		return copy(this, copyDepth);
	}	
}