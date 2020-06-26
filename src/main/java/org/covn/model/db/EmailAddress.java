package org.covn.model.db;

import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.UniqueConstraint;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import org.covn.model.BaseModel;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "email_address", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"email_address_id"})
})
public class EmailAddress extends BaseModel<EmailAddress, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "email_address_id", nullable = false, length = 10)
	private Integer emailAddressId;

	@Column(name = "user_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users usersByUserId;

	@Column(name = "email_address", nullable = false, length = 64)
	private String emailAddress;

	@Column(name = "email_address_type", nullable = false, length = 32)
	private String emailAddressType;

	@Column(name = "is_preferred", nullable = true)
	private Boolean isPreferred;

	@Column(name = "is_primary_user", nullable = true)
	private Boolean isPrimaryUser;

	@Column(name = "primary_user_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer primaryUserId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "primary_user_id")
	private Users usersByPrimaryUserId;


	public Integer getEmailAddressId(){
		return this.emailAddressId;
	}
	public EmailAddress setEmailAddressId(Integer emailAddressId){
		this.emailAddressId = emailAddressId;
		
		return this;
	}

	public Integer getUserId(){
		return this.userId;
	}
	public EmailAddress setUserId(Integer userId){
		this.userId = userId;
		
		return this;
	}

	public Users getUsersByUserId(){
		return this.usersByUserId;
	}
	public EmailAddress setUsersByUserId(Users usersByUserId){
		this.usersByUserId = usersByUserId;
		this.userId = (this.usersByUserId == null)? null: this.usersByUserId.getUserId();
		return this;
	}

	public String getEmailAddress(){
		return this.emailAddress;
	}
	public EmailAddress setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
		
		return this;
	}

	public String getEmailAddressType(){
		return this.emailAddressType;
	}
	public EmailAddress setEmailAddressType(String emailAddressType){
		this.emailAddressType = emailAddressType;
		
		return this;
	}

	public Boolean getIsPreferred(){
		return this.isPreferred;
	}
	public EmailAddress setIsPreferred(Boolean isPreferred){
		this.isPreferred = isPreferred;
		
		return this;
	}

	public Boolean getIsPrimaryUser(){
		return this.isPrimaryUser;
	}
	public EmailAddress setIsPrimaryUser(Boolean isPrimaryUser){
		this.isPrimaryUser = isPrimaryUser;
		
		return this;
	}

	public Integer getPrimaryUserId(){
		return this.primaryUserId;
	}
	public EmailAddress setPrimaryUserId(Integer primaryUserId){
		this.primaryUserId = primaryUserId;
		
		return this;
	}

	public Users getUsersByPrimaryUserId(){
		return this.usersByPrimaryUserId;
	}
	public EmailAddress setUsersByPrimaryUserId(Users usersByPrimaryUserId){
		this.usersByPrimaryUserId = usersByPrimaryUserId;
		this.primaryUserId = (this.usersByPrimaryUserId == null)? null: this.usersByPrimaryUserId.getUserId();
		return this;
	}


	@Override
	public Integer getKey() {
		return this.emailAddressId;
	}

	
	public static EmailAddress of(){
		return new EmailAddress();
	}
	
	public static EmailAddress copy(EmailAddress src, int depth){
		EmailAddress copy = null;
		if(depth > 0){
			copy = new EmailAddress();
			copy.emailAddressId = src.getEmailAddressId();
			copy.userId = src.getUserId();
			copy.usersByUserId = (src.getUsersByUserId() == null)? null : Users.copy(src.getUsersByUserId(), --depth);
			copy.emailAddress = src.getEmailAddress();
			copy.emailAddressType = src.getEmailAddressType();
			copy.isPreferred = src.getIsPreferred();
			copy.isPrimaryUser = src.getIsPrimaryUser();
			copy.primaryUserId = src.getPrimaryUserId();
			copy.usersByPrimaryUserId = (src.getUsersByPrimaryUserId() == null)? null : Users.copy(src.getUsersByPrimaryUserId(), --depth);
		}
		return copy;
	}

	@Override
	public EmailAddress copy() {
		return copy(this, copyDepth);
	}	
}