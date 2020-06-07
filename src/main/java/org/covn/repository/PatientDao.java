package org.covn.repository;

import org.apache.commons.lang3.StringUtils;
import org.covn.dto.PatientDto;
import org.covn.dto.PatientLocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class PatientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //TODO review sql
    public PatientLocationDto searchPatients(Long locationId, Long userId, String phoneNumber, int size, int from,
                                             String firstName, String lastName, String covid19Status, String quarantineStatus, String isolationStatus,
                                             String quarantineRequestStatus, String medicalRequestStatus, String suppliesRequestStatus,
                                             String geofenceStatus, String heartbeatStatus, String healthStatusAlert) {

        List<Object> queryParam = new ArrayList<>();

        String sql = "select p.\"PatientId\", pu.\"FirstName\", pu.\"LastName\", ps.\"COVID19Status\", ps.\"QuarantineStatus\", ps.\"IsolationStatus\", " +
                "ps.\"HealthStatusAlert\", ps.\"QuarantineRequestStatus\", ps.\"SuppliesRequestStatus\", ps.\"GeofenceStatus\", ps.\"HeartbeatStatus\", ps.\"Latitude\", ps.\"Longitude\" " +
                "from \"Patient\" p " +
                "LEFT JOIN \"PatientProviderRelationship\" ppr on ppr.\"PatientId\"=p.\"PatientId\" " +
                "LEFT JOIN \"User\" pu on p.\"UserId\"=pu.\"UserId\" " +
                "LEFT JOIN \"PatientStatus\" ps on p.\"PatientId\"=ps.\"PatientId\" " +
                "LEFT JOIN \"PhoneNumber\" pn on p.\"UserId\"=pn.\"UserId\" where 1=1 ";

        if (locationId != null && userId != null) {
            sql += " and ppr.\"RelationshipFacilityLocation\"=? and ppr.\"ProviderId\"=? ";
            queryParam.add(locationId);
            queryParam.add(userId);
        }

        if (StringUtils.isNotBlank(phoneNumber)) {
            sql += " and pn.\"PhoneNumber\"=?";
            queryParam.add(phoneNumber);
        }

        if (StringUtils.isNotBlank(firstName)) {
            sql += " and pu.\"FirstName\"=?";
            queryParam.add(firstName);
        }

        if (StringUtils.isNotBlank(lastName)) {
            sql += " and pu.\"LastName\"=?";
            queryParam.add(lastName);
        }

        if (StringUtils.isNotBlank(covid19Status)) {
            sql += " and ps.\"COVID19Status\"=?";
            queryParam.add(covid19Status);
        }

        if (StringUtils.isNotBlank(quarantineStatus)) {
            sql += " and ps.\"QuarantineStatus\"=?";
            queryParam.add(quarantineStatus);
        }

        if (StringUtils.isNotBlank(isolationStatus)) {
            sql += " and ps.\"IsolationStatus\"=?";
            queryParam.add(isolationStatus);
        }

        if (StringUtils.isNotBlank(quarantineRequestStatus)) {
            sql += " and ps.\"QuarantineRequestStatus\"=?";
            queryParam.add(quarantineRequestStatus);
        }

        if (StringUtils.isNotBlank(medicalRequestStatus)) {
            sql += " and ps.\"MedicalRequestStatus\"=?";
            queryParam.add(medicalRequestStatus);
        }

        if (StringUtils.isNotBlank(suppliesRequestStatus)) {
            sql += " and ps.\"SuppliesRequestStatus\"=?";
            queryParam.add(suppliesRequestStatus);
        }

        if (StringUtils.isNotBlank(geofenceStatus)) {
            sql += " and ps.\"GeofenceStatus\"=?";
            queryParam.add(geofenceStatus);
        }

        if (StringUtils.isNotBlank(heartbeatStatus)) {
            sql += " and ps.\"HeartbeatStatus\"=?";
            queryParam.add(heartbeatStatus);
        }

        if (StringUtils.isNotBlank(healthStatusAlert)) {
            sql += " and ps.\"HealthStatusAlert\"=?";
            queryParam.add(healthStatusAlert);
        }

        sql += " order by p.\"PatientId\" ";

        List<PatientDto> list = jdbcTemplate.query(sql, queryParam.toArray(), (rs, rowNum) -> {
            PatientDto dto = new PatientDto();
            //Commented to resolve compilation errors
           /* dto.setPatientID(rs.getLong("PatientId"));
            dto.setFirstName(rs.getString("FirstName"));
            dto.setLastName(rs.getString("LastName"));
            dto.setCovid19Status(rs.getString("COVID19Status"));
            dto.setQuarantineStatus(rs.getString("QuarantineStatus"));
            dto.setIsolationStatus(rs.getString("IsolationStatus"));
            dto.setHealthRequestStatus(rs.getString("HealthStatusAlert"));
            dto.setQuarantineRequestStatus(rs.getString("QuarantineRequestStatus"));
            dto.setSuppliesRequestStatus(rs.getString("SuppliesRequestStatus"));
            dto.setGeofenceStatus(rs.getString("GeofenceStatus"));
            dto.setHeartbeatStatus(rs.getString("HeartbeatStatus"));
            dto.setLatitude(rs.getDouble("Latitude"));
            dto.setLongitude(rs.getDouble("Longitude"));*/
            return dto;
        });

        int totalCount = list.size();
        List<PatientDto> subList = Collections.emptyList();
        if (totalCount > from) {
            int to = Math.min(totalCount, from + size);
            subList = list.subList(from, to);
        }

        PatientLocationDto patients = new PatientLocationDto();
        patients.setTotal(list.size());
        patients.setSize(size);
        patients.setFrom(from);
        patients.setPatients(subList);
        return patients;
    }

}
