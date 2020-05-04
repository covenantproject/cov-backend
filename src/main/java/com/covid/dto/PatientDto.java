package com.covid.dto;

public class PatientDto {

    private long patientID;
    private String firstName;
    private String lastName;
    private String householdId;
    private String covid19Status;
    private String quarantineStatus;
    private String isolationStatus;
    private String healthRequestStatus;
    private String quarantineRequestStatus;
    private String suppliesRequestStatus;
    private String geofenceStatus;
    private Boolean geofenceCompliant;
    private String heartbeatStatus;
    private Double latitude;
    private Double longitude;
    private String healthAlertStatus;

    public long getPatientID() {
        return patientID;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public String getCovid19Status() {
        return covid19Status;
    }

    public void setCovid19Status(String covid19Status) {
        this.covid19Status = covid19Status;
    }

    public String getQuarantineStatus() {
        return quarantineStatus;
    }

    public void setQuarantineStatus(String quarantineStatus) {
        this.quarantineStatus = quarantineStatus;
    }

    public String getIsolationStatus() {
        return isolationStatus;
    }

    public void setIsolationStatus(String isolationStatus) {
        this.isolationStatus = isolationStatus;
    }

    public String getHealthRequestStatus() {
        return healthRequestStatus;
    }

    public void setHealthRequestStatus(String healthRequestStatus) {
        this.healthRequestStatus = healthRequestStatus;
    }

    public String getQuarantineRequestStatus() {
        return quarantineRequestStatus;
    }

    public void setQuarantineRequestStatus(String quarantineRequestStatus) {
        this.quarantineRequestStatus = quarantineRequestStatus;
    }

    public String getSuppliesRequestStatus() {
        return suppliesRequestStatus;
    }

    public void setSuppliesRequestStatus(String suppliesRequestStatus) {
        this.suppliesRequestStatus = suppliesRequestStatus;
    }

    public String getGeofenceStatus() {
        return geofenceStatus;
    }

    public void setGeofenceStatus(String geofenceStatus) {
        this.geofenceStatus = geofenceStatus;
    }

    public Boolean getGeofenceCompliant() {
        return geofenceCompliant;
    }

    public void setGeofenceCompliant(Boolean geofenceCompliant) {
        this.geofenceCompliant = geofenceCompliant;
    }

    public String getHeartbeatStatus() {
        return heartbeatStatus;
    }

    public void setHeartbeatStatus(String heartbeatStatus) {
        this.heartbeatStatus = heartbeatStatus;
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

    public String getHealthAlertStatus() {
        return healthAlertStatus;
    }

    public void setHealthAlertStatus(String healthAlertStatus) {
        this.healthAlertStatus = healthAlertStatus;
    }
}
