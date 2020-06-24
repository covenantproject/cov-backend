package org.covn.dto;

import org.covn.model.db.LocationHierarchy;

/** Hierarchy of locations - countries (with ISO codes), states, districts, cities and health care facilities.
 * Property assign_patients denotes whether patients can be assigned to a given location, this is true 
 * for health care facilities but false for geographical locations (countries, states, cities, etc.)
 *  
 * @author Senthil N
 *
 */
public class LocationHierarchyDto {
	
	private LocationHierarchy locationHierarchy;

	public LocationHierarchy getLocationHierarchy() {
		return locationHierarchy;
	}

	public void setLocationHierarchy(LocationHierarchy locationHierarchy) {
		this.locationHierarchy = locationHierarchy;
	}
	

}
