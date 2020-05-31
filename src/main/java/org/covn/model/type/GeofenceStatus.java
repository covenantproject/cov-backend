package org.covn.model.type;

public enum GeofenceStatus implements BaseEnum{
	outsideFar("geofence_outside_far"),
	inside("geofence_inside"),
	insideNear("geofence_inside_near"),
	unknown("geofence_unknown"),
	;
	private final String key;
	private GeofenceStatus(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
