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
@Table(name = "external_identifier", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"identification_id"})
})
public class ExternalIdentifier extends BaseModel<ExternalIdentifier, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identification_id", nullable = false, length = 10)
	private Integer identificationId;

	@Column(name = "user_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users users;

	@Column(name = "id_type", nullable = true, length = 32)
	private String idType;

	@Column(name = "id_type_uri", nullable = true, length = 10)
	private String idTypeUri;

	@Column(name = "issuing_authority_name", nullable = true, length = 10)
	private String issuingAuthorityName;

	@Column(name = "issuing_authority_id", nullable = true, length = 10)
	private String issuingAuthorityId;

	@Column(name = "issuing_authority_uri", nullable = true, length = 10)
	private String issuingAuthorityUri;

	@Column(name = "id_number", nullable = true, length = 20)
	private String idNumber;

	@Column(name = "issue_date", nullable = true, length = 10)
	private String issueDate;

	@Column(name = "expiry_date", nullable = true, length = 10)
	private String expiryDate;


	public Integer getIdentificationId(){
		return this.identificationId;
	}
	public ExternalIdentifier setIdentificationId(Integer identificationId){
		this.identificationId = identificationId;
		
		return this;
	}

	public Integer getUserId(){
		return this.userId;
	}
	public ExternalIdentifier setUserId(Integer userId){
		this.userId = userId;
		
		return this;
	}

	public Users getUsers(){
		return this.users;
	}
	public ExternalIdentifier setUsers(Users users){
		this.users = users;
		this.userId = (this.users == null)? null: this.users.getUserId();
		return this;
	}

	public String getIdType(){
		return this.idType;
	}
	public ExternalIdentifier setIdType(String idType){
		this.idType = idType;
		
		return this;
	}

	public String getIdTypeUri(){
		return this.idTypeUri;
	}
	public ExternalIdentifier setIdTypeUri(String idTypeUri){
		this.idTypeUri = idTypeUri;
		
		return this;
	}

	public String getIssuingAuthorityName(){
		return this.issuingAuthorityName;
	}
	public ExternalIdentifier setIssuingAuthorityName(String issuingAuthorityName){
		this.issuingAuthorityName = issuingAuthorityName;
		
		return this;
	}

	public String getIssuingAuthorityId(){
		return this.issuingAuthorityId;
	}
	public ExternalIdentifier setIssuingAuthorityId(String issuingAuthorityId){
		this.issuingAuthorityId = issuingAuthorityId;
		
		return this;
	}

	public String getIssuingAuthorityUri(){
		return this.issuingAuthorityUri;
	}
	public ExternalIdentifier setIssuingAuthorityUri(String issuingAuthorityUri){
		this.issuingAuthorityUri = issuingAuthorityUri;
		
		return this;
	}

	public String getIdNumber(){
		return this.idNumber;
	}
	public ExternalIdentifier setIdNumber(String idNumber){
		this.idNumber = idNumber;
		
		return this;
	}

	public String getIssueDate(){
		return this.issueDate;
	}
	public ExternalIdentifier setIssueDate(String issueDate){
		this.issueDate = issueDate;
		
		return this;
	}

	public String getExpiryDate(){
		return this.expiryDate;
	}
	public ExternalIdentifier setExpiryDate(String expiryDate){
		this.expiryDate = expiryDate;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.identificationId;
	}

	
	public static ExternalIdentifier of(){
		return new ExternalIdentifier();
	}
	
	public static ExternalIdentifier copy(ExternalIdentifier src, int depth){
		ExternalIdentifier copy = null;
		if(depth > 0){
			copy = new ExternalIdentifier();
			copy.identificationId = src.getIdentificationId();
			copy.userId = src.getUserId();
			copy.users = (src.getUsers() == null)? null : Users.copy(src.getUsers(), --depth);
			copy.idType = src.getIdType();
			copy.idTypeUri = src.getIdTypeUri();
			copy.issuingAuthorityName = src.getIssuingAuthorityName();
			copy.issuingAuthorityId = src.getIssuingAuthorityId();
			copy.issuingAuthorityUri = src.getIssuingAuthorityUri();
			copy.idNumber = src.getIdNumber();
			copy.issueDate = src.getIssueDate();
			copy.expiryDate = src.getExpiryDate();
		}
		return copy;
	}

	@Override
	public ExternalIdentifier copy() {
		return copy(this, copyDepth);
	}	
}