package com.covid.vo;

import java.util.Date;

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
    private String proofType;
    private String proofNumber;
    private String proofAuthority;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String district;
    private String state;
    private String pinCode;
    private String addressType;
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

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getProofNumber() {
        return proofNumber;
    }

    public void setProofNumber(String proofNumber) {
        this.proofNumber = proofNumber;
    }

    public String getProofAuthority() {
        return proofAuthority;
    }

    public void setProofAuthority(String proofAuthority) {
        this.proofAuthority = proofAuthority;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
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

    // @Override
    // public String toString() {
    //     return "Register{" +
    //             "title='" + title + '\'' +
    //             ", firstName='" + firstName + '\'' +
    //             ", middleName='" + middleName + '\'' +
    //             ", lastName='" + lastName + '\'' +
    //             ", preferredName='" + preferredName + '\'' +
    //             ", shortName='" + shortName + '\'' +
    //             ", suffix='" + suffix + '\'' +
    //             ", dob=" + dob +
    //             ", gender='" + gender + '\'' +
    //             ", idType='" + proofType + '\'' +
    //             ", idProofNo='" + proofNumber + '\'' +
    //             ", address='" + address + '\'' +
    //             ", mobileNo=" + mobileNo +
    //             '}';
    // }
}
