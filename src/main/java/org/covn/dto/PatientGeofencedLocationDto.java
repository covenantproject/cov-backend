package org.covn.dto;

import org.covn.model.db.PatientGeofencedLocation;

/** Location where the patient is geofenced while under quarantine or isolation
 *  The geofenced location may (optionally) correspond to a street address denoted by the addressId
 *  Radius is set to 30 metres (100 feet) by default but it can be changed by the quarantine officer
 */
public class PatientGeofencedLocationDto {


	private PatientGeofencedLocation patGeofenceLoc;

	public PatientGeofencedLocation getPatGeofenceLoc() {
		return patGeofenceLoc;
	}

	public void setPatGeofenceLoc(PatientGeofencedLocation patGeofenceLoc) {
		this.patGeofenceLoc = patGeofenceLoc;
	}

	
}	

