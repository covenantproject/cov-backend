package org.covn.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;
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
@Table(name = "user_photo", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"photo_id"})
})
public class UserPhoto extends BaseModel<UserPhoto, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photo_id", nullable = false, length = 10)
	private Integer photoId;

	@Column(name = "user_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users users;

	@Column(name = "photo_type", nullable = true, length = 32)
	private String photoType;

	@Column(name = "photo_path", nullable = true, length = 255)
	private String photoPath;

	@Column(name = "file_saved_datetime", nullable = true, length = 29)
	private Timestamp fileSavedDatetime;


	public Integer getPhotoId(){
		return this.photoId;
	}
	public UserPhoto setPhotoId(Integer photoId){
		this.photoId = photoId;
		
		return this;
	}

	public Integer getUserId(){
		return this.userId;
	}
	public UserPhoto setUserId(Integer userId){
		this.userId = userId;
		
		return this;
	}

	public Users getUsers(){
		return this.users;
	}
	public UserPhoto setUsers(Users users){
		this.users = users;
		this.userId = (this.users == null)? null: this.users.getUserId();
		return this;
	}

	public String getPhotoType(){
		return this.photoType;
	}
	public UserPhoto setPhotoType(String photoType){
		this.photoType = photoType;
		
		return this;
	}

	public String getPhotoPath(){
		return this.photoPath;
	}
	public UserPhoto setPhotoPath(String photoPath){
		this.photoPath = photoPath;
		
		return this;
	}

	public Timestamp getFileSavedDatetime(){
		return this.fileSavedDatetime;
	}
	public UserPhoto setFileSavedDatetime(Timestamp fileSavedDatetime){
		this.fileSavedDatetime = fileSavedDatetime;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.photoId;
	}

	
	public static UserPhoto of(){
		return new UserPhoto();
	}
	
	public static UserPhoto copy(UserPhoto src, int depth){
		UserPhoto copy = null;
		if(depth > 0){
			copy = new UserPhoto();
			copy.photoId = src.getPhotoId();
			copy.userId = src.getUserId();
			copy.users = (src.getUsers() == null)? null : Users.copy(src.getUsers(), --depth);
			copy.photoType = src.getPhotoType();
			copy.photoPath = src.getPhotoPath();
			copy.fileSavedDatetime = src.getFileSavedDatetime();
		}
		return copy;
	}

	@Override
	public UserPhoto copy() {
		return copy(this, copyDepth);
	}	
}