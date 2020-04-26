package com.covid.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author SunilAnand
 * @since 2020-04-14
 **/

@Entity
@Table(name = "`User`")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`UserId`")
    private long userId;

    @Column(name = "`Title`")
    private String title;

    @Column(name = "`FirstName`")
    private String firstName;

    @Column(name = "`MiddleName`")
    private String middleName;

    @Column(name = "`LastName`")
    private String lastName;

    @Column(name = "`PreferredName`")
    private String preferredName;

    @Column(name = "`ShortName`")
    private String shortName;

    @Column(name = "`Suffix`")
    private String suffix;

    @Column(name = "`DateOfBirth`")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "`Gender`")
    private String gender;

    @Column(name = "`OTPCode`")
    private String otpCode;

    @Column(name = "`ProfilePhotoId`")
    private Long photoId;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AddressEntity address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PhoneNumberEntity phoneNumber;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PatientEntity patient;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "`ProfilePhotoId`", referencedColumnName = "`PhotoId`")
//    private PhotoEntity photo;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public PhoneNumberEntity getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumberEntity phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", preferredName='" + preferredName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
