package org.covn.vo;

import java.util.Date;

/**
 * @author SunilAnand
 * @since 2020-04-14
 **/
public class Register {
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String preferredName;
    private String shortName;
    private String suffix;
    private Date dob;
    private String gender;
    private String idType;
    private String idProofNo;
    private String address;
    private Long mobileNo;
    private Long photoId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdProofNo() {
        return idProofNo;
    }

    public void setIdProofNo(String idProofNo) {
        this.idProofNo = idProofNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    @Override
    public String toString() {
        return "Register{" +
                "title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", preferredName='" + preferredName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", idType='" + idType + '\'' +
                ", idProofNo='" + idProofNo + '\'' +
                ", address='" + address + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
