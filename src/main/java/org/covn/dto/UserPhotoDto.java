package org.covn.dto;

public class UserPhotoDto {
	// photo fields go into the user_photo table. the photo image file is saved on the file system and it's path is saved in the table
	// If photoPath is provided, then photoType must be provided.
	private String photoType; // CHECK CONSTRAINT
	private String photoPath;
	
	public String getPhotoType() {
		return photoType;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	

}
