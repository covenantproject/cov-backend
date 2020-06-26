package org.covn.model.db;

import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "demographics", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"user_id"})
})
public class Demographics extends BaseModel<Demographics, Integer> implements java.io.Serializable{

	@Id
	@Column(name = "user_id", nullable = false, length = 10)
	private Integer userId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users users;

	@Column(name = "nationality", nullable = true, length = 32)
	private String nationality;

	@Column(name = "residency_status", nullable = true, length = 32)
	private String residencyStatus;

	@Column(name = "occupation", nullable = true, length = 32)
	private String occupation;

	@Column(name = "emergency_contact_id_1", nullable = true, length = 10)
	private Integer emergencyContactId1;

	@Column(name = "emer_contact_1_rel_to_pat", nullable = true, length = 32)
	private String emerContact1RelToPat;

	@Column(name = "emergency_contact_id_2", nullable = true, length = 10)
	private Integer emergencyContactId2;

	@Column(name = "emer_contact_2_rel_to_pat", nullable = true, length = 32)
	private String emerContact2RelToPat;

	@Column(name = "next_of_kin_id_1", nullable = true, length = 10)
	private Integer nextOfKinId1;

	@Column(name = "next_of_kin_1_rel_to_pat", nullable = true, length = 32)
	private String nextOfKin1RelToPat;

	@Column(name = "next_of_kin_id_2", nullable = true, length = 10)
	private Integer nextOfKinId2;

	@Column(name = "next_of_kin_2_rel_to_pat", nullable = true, length = 32)
	private String nextOfKin2RelToPat;

	@Column(name = "comments", nullable = true, length = 2048)
	private String comments;


	public Integer getUserId(){
		return this.userId;
	}
	public Demographics setUserId(Integer userId){
		this.userId = userId;
		
		return this;
	}

	public Users getUsers(){
		return this.users;
	}
	public Demographics setUsers(Users users){
		this.users = users;
		this.userId = (this.users == null)? null: this.users.getUserId();
		return this;
	}

	public String getNationality(){
		return this.nationality;
	}
	public Demographics setNationality(String nationality){
		this.nationality = nationality;
		
		return this;
	}

	public String getResidencyStatus(){
		return this.residencyStatus;
	}
	public Demographics setResidencyStatus(String residencyStatus){
		this.residencyStatus = residencyStatus;
		
		return this;
	}

	public String getOccupation(){
		return this.occupation;
	}
	public Demographics setOccupation(String occupation){
		this.occupation = occupation;
		
		return this;
	}

	public Integer getEmergencyContactId1(){
		return this.emergencyContactId1;
	}
	public Demographics setEmergencyContactId1(Integer emergencyContactId1){
		this.emergencyContactId1 = emergencyContactId1;
		
		return this;
	}

	public String getEmerContact1RelToPat(){
		return this.emerContact1RelToPat;
	}
	public Demographics setEmerContact1RelToPat(String emerContact1RelToPat){
		this.emerContact1RelToPat = emerContact1RelToPat;
		
		return this;
	}

	public Integer getEmergencyContactId2(){
		return this.emergencyContactId2;
	}
	public Demographics setEmergencyContactId2(Integer emergencyContactId2){
		this.emergencyContactId2 = emergencyContactId2;
		
		return this;
	}

	public String getEmerContact2RelToPat(){
		return this.emerContact2RelToPat;
	}
	public Demographics setEmerContact2RelToPat(String emerContact2RelToPat){
		this.emerContact2RelToPat = emerContact2RelToPat;
		
		return this;
	}

	public Integer getNextOfKinId1(){
		return this.nextOfKinId1;
	}
	public Demographics setNextOfKinId1(Integer nextOfKinId1){
		this.nextOfKinId1 = nextOfKinId1;
		
		return this;
	}

	public String getNextOfKin1RelToPat(){
		return this.nextOfKin1RelToPat;
	}
	public Demographics setNextOfKin1RelToPat(String nextOfKin1RelToPat){
		this.nextOfKin1RelToPat = nextOfKin1RelToPat;
		
		return this;
	}

	public Integer getNextOfKinId2(){
		return this.nextOfKinId2;
	}
	public Demographics setNextOfKinId2(Integer nextOfKinId2){
		this.nextOfKinId2 = nextOfKinId2;
		
		return this;
	}

	public String getNextOfKin2RelToPat(){
		return this.nextOfKin2RelToPat;
	}
	public Demographics setNextOfKin2RelToPat(String nextOfKin2RelToPat){
		this.nextOfKin2RelToPat = nextOfKin2RelToPat;
		
		return this;
	}

	public String getComments(){
		return this.comments;
	}
	public Demographics setComments(String comments){
		this.comments = comments;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.userId;
	}

	
	public static Demographics of(){
		return new Demographics();
	}
	
	public static Demographics copy(Demographics src, int depth){
		Demographics copy = null;
		if(depth > 0){
			copy = new Demographics();
			copy.userId = src.getUserId();
			copy.users = (src.getUsers() == null)? null : Users.copy(src.getUsers(), --depth);
			copy.nationality = src.getNationality();
			copy.residencyStatus = src.getResidencyStatus();
			copy.occupation = src.getOccupation();
			copy.emergencyContactId1 = src.getEmergencyContactId1();
			copy.emerContact1RelToPat = src.getEmerContact1RelToPat();
			copy.emergencyContactId2 = src.getEmergencyContactId2();
			copy.emerContact2RelToPat = src.getEmerContact2RelToPat();
			copy.nextOfKinId1 = src.getNextOfKinId1();
			copy.nextOfKin1RelToPat = src.getNextOfKin1RelToPat();
			copy.nextOfKinId2 = src.getNextOfKinId2();
			copy.nextOfKin2RelToPat = src.getNextOfKin2RelToPat();
			copy.comments = src.getComments();
		}
		return copy;
	}

	@Override
	public Demographics copy() {
		return copy(this, copyDepth);
	}	
}