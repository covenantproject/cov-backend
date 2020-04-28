package com.covid.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`ExternalIdentifier`")
public class ExternalIdentifierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdentificationId`")
    private Long identificationId;

    @Column(name = "`IDType`")
    private String idType;

    @Column(name = "`IssuingAuthorityName`")
    private String issuingAuthorityName;

    @Column(name = "`IDNumber`")
    private String idNumber;

    @OneToOne
    @JoinColumn(name = "`UserId`")
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getIDType() {
        return idType;
    }

    public void setIDType(String idType) {
        this.idType = idType;
    }

    public String getIDAuthority() {
        return issuingAuthorityName;
    }

    public void setIDAuthority(String issuingAuthorityName) {
        this.issuingAuthorityName = issuingAuthorityName;
    }

    public String getIDNumber() {
        return idNumber;
    }

    public void setIDNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
