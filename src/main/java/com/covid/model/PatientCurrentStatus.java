package com.covid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"PatientStatus\"")
public class PatientCurrentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"PatientStatusId\"")
    private long PatientStatusId;

    @Column(name = "\"PatientId\"")
    private long patientId;

    @Column(name = "\"COVID19Status\"")
    private String COVID19Status;

    @Column(name = "\"PatientType\"")
    private String PatientType;

    @Column(name = "\"QuarantineStatus\"")
    private String QuarantineStatus;

    @Column(name = "\"QuarantineStartDateTime\"")
    private Date QuarantineStartDateTime;

    @Column(name = "\"QuarantineEndDateTime\"")
    private Date QuarantineEndDateTime;

    @Column(name = "\"QuarIsltRequestStatus\"")
    private String QuarantineRequestStatus;

    @Column(name = "\"MedicalRequestStatus\"")
    private String MedicalRequestStatus;

    @Column(name = "\"SuppliesRequestStatus\"")
    private String SuppliesRequestStatus;

    @Column(name = "\"GeofenceStatus\"")
    private String geofenceStatus;

    @Column(name = "\"HealthStatusAlert\"")
    private String healthStatusAlert;

    @Column(name = "\"Latitude\"")
    private Double latitude;

    @Column(name = "\"Longitude\"")
    private Double longitude;

    public long getPatientStatusId() {
        return PatientStatusId;
    }

    public void setPatientStatusId(long patientStatusId) {
        PatientStatusId = patientStatusId;
    }


    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getCOVID19Status() {
        return COVID19Status;
    }

    public void setCOVID19Status(String cOVID19Status) {
        COVID19Status = cOVID19Status;
    }

    public String getPatientType() {
        return PatientType;
    }

    public void setPatientType(String patientType) {
        PatientType = patientType;
    }

    public String getQuarantineStatus() {
        return QuarantineStatus;
    }

    public void setQuarantineStatus(String quarantineStatus) {
        QuarantineStatus = quarantineStatus;
    }

    public Date getQuarantineStartDateTime() {
        return QuarantineStartDateTime;
    }

    public void setQuarantineStartDateTime(Date quarantineStartDateTime) {
        QuarantineStartDateTime = quarantineStartDateTime;
    }

    public Date getQuarantineEndDateTime() {
        return QuarantineEndDateTime;
    }

    public void setQuarantineEndDateTime(Date quarantineEndDateTime) {
        QuarantineEndDateTime = quarantineEndDateTime;
    }

    public String getQuarantineRequestStatus() {
        return QuarantineRequestStatus;
    }

    public void setQuarantineRequestStatus(String quarantineRequestStatus) {
        QuarantineRequestStatus = quarantineRequestStatus;
    }

    public String getMedicalRequestStatus() {
        return MedicalRequestStatus;
    }

    public void setMedicalRequestStatus(String medicalRequestStatus) {
        MedicalRequestStatus = medicalRequestStatus;
    }

    public String getSuppliesRequestStatus() {
        return SuppliesRequestStatus;
    }

    public void setSuppliesRequestStatus(String suppliesRequestStatus) {
        SuppliesRequestStatus = suppliesRequestStatus;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getGeofenceStatus() {
        return geofenceStatus;
    }

    public void setGeofenceStatus(String geofenceStatus) {
        this.geofenceStatus = geofenceStatus;
    }

    public String getHealthStatusAlert() {
        return healthStatusAlert;
    }

    public void setHealthStatusAlert(String healthStatusAlert) {
        this.healthStatusAlert = healthStatusAlert;
    }
}
