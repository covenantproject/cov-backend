package com.covid.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author SunilAnand
 * @since 2020-04-14
 **/
@Entity
@Table(name = "`PhoneNumber`")
public class PhoneNumberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`PhoneNumberId`")
    private Long phoneNumberId;

    @Column(name = "`PhoneNumber`")
    private Long phoneNumber;

    @OneToOne
    @JoinColumn(name = "`UserId`")
    private UserEntity user;

    public Long getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(Long phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
