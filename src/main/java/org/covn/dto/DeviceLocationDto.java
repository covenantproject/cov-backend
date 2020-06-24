package org.covn.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.covn.model.db.DeviceLocation;
import org.covn.model.type.GeofenceStatus;
import org.covn.model.type.LocationCheckReason;
import org.covn.model.type.LocationCheckResult;
import org.covn.model.type.LocationServiceType;

/** Location of the device at a specific time.
 *  PatientId is the UserId of the primary user who owns the device.
 *  PatientId is obtained by first joining the device_app_id to the phone_number
 *  and then finding its primary_user_id
 *  
 */

public class DeviceLocationDto {

	private DeviceLocation deviceLocation;

	public DeviceLocation getDeviceLocation() {
		return deviceLocation;
	}

	public void setDeviceLocation(DeviceLocation deviceLocation) {
		this.deviceLocation = deviceLocation;
	}

}
