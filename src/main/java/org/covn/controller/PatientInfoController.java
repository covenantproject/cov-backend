package org.covn.controller;

import org.apache.commons.lang3.StringUtils;
import org.covn.dto.PatientSearchResultsDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/api")
public class PatientInfoController {



    @GetMapping("/getPatientInfo")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Object getPatientForLocation(@RequestParam int patientId) {
        return null;
    }

    @GetMapping("/searchPatient")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public PatientSearchResultsDto searchPatient(@RequestParam(required = false) Long locationId,
            @RequestParam(required = false) Long healthProId, @RequestParam(required = false) String phoneNumber,
            @RequestParam(defaultValue = "100") int size, @RequestParam(defaultValue = "0") int from,
            @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String covid19Status,
            @RequestParam(required = false) String quarantineStatus,
            @RequestParam(required = false) String isolationStatus,
            @RequestParam(required = false) String quarantineRequestStatus,
            @RequestParam(required = false) String medicalRequestStatus,
            @RequestParam(required = false) String suppliesRequestStatus,
            @RequestParam(required = false) String geofenceStatus,
            @RequestParam(required = false) String heartbeatStatus,
            @RequestParam(required = false) String healthStatusAlert) {

        if ((locationId == null || healthProId == null) && StringUtils.isBlank(phoneNumber)) {
            throw new RuntimeException("PHONE_NUMBER_MANDATORY");
        }
        return null;
    }
}
