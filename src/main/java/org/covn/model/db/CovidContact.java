package org.covn.model.db;

import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.UniqueConstraint;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;
import javax.persistence.FetchType;
import org.covn.model.BaseModel;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "covid_contact", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"contact_id"})
})
public class CovidContact extends BaseModel<CovidContact, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id", nullable = false, length = 10)
	private Integer contactId;

	@Column(name = "contact_user_id_1", nullable = false, length = 10)
	private Integer contactUserId1;

	@Column(name = "contact_user_id_2", nullable = false, length = 10)
	private Integer contactUserId2;

	@Column(name = "contact_time_start", nullable = true, length = 29)
	private Timestamp contactTimeStart;

	@Column(name = "contact_time_end", nullable = true, length = 29)
	private Timestamp contactTimeEnd;

	@Column(name = "contact_location_id", nullable = true, length = 10)
	private Integer contactLocationId;

	@Column(name = "contact_relationship", nullable = true, length = 10)
	private String contactRelationship;

	@Column(name = "contact_exposure", nullable = true, length = 10)
	private String contactExposure;


	public Integer getContactId(){
		return this.contactId;
	}
	public CovidContact setContactId(Integer contactId){
		this.contactId = contactId;
		
		return this;
	}

	public Integer getContactUserId1(){
		return this.contactUserId1;
	}
	public CovidContact setContactUserId1(Integer contactUserId1){
		this.contactUserId1 = contactUserId1;
		
		return this;
	}

	public Integer getContactUserId2(){
		return this.contactUserId2;
	}
	public CovidContact setContactUserId2(Integer contactUserId2){
		this.contactUserId2 = contactUserId2;
		
		return this;
	}

	public Timestamp getContactTimeStart(){
		return this.contactTimeStart;
	}
	public CovidContact setContactTimeStart(Timestamp contactTimeStart){
		this.contactTimeStart = contactTimeStart;
		
		return this;
	}

	public Timestamp getContactTimeEnd(){
		return this.contactTimeEnd;
	}
	public CovidContact setContactTimeEnd(Timestamp contactTimeEnd){
		this.contactTimeEnd = contactTimeEnd;
		
		return this;
	}

	public Integer getContactLocationId(){
		return this.contactLocationId;
	}
	public CovidContact setContactLocationId(Integer contactLocationId){
		this.contactLocationId = contactLocationId;
		
		return this;
	}

	public String getContactRelationship(){
		return this.contactRelationship;
	}
	public CovidContact setContactRelationship(String contactRelationship){
		this.contactRelationship = contactRelationship;
		
		return this;
	}

	public String getContactExposure(){
		return this.contactExposure;
	}
	public CovidContact setContactExposure(String contactExposure){
		this.contactExposure = contactExposure;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.contactId;
	}

	
	public static CovidContact of(){
		return new CovidContact();
	}
	
	public static CovidContact copy(CovidContact src, int depth){
		CovidContact copy = null;
		if(depth > 0){
			copy = new CovidContact();
			copy.contactId = src.getContactId();
			copy.contactUserId1 = src.getContactUserId1();
			copy.contactUserId2 = src.getContactUserId2();
			copy.contactTimeStart = src.getContactTimeStart();
			copy.contactTimeEnd = src.getContactTimeEnd();
			copy.contactLocationId = src.getContactLocationId();
			copy.contactRelationship = src.getContactRelationship();
			copy.contactExposure = src.getContactExposure();
		}
		return copy;
	}

	@Override
	public CovidContact copy() {
		return copy(this, copyDepth);
	}	
}