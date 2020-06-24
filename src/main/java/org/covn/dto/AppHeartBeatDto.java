package org.covn.dto;

import org.covn.model.db.AppHeartbeat;

/** Heartbeat signal from the Covenant mobile app used by patients.
 * Used to determine whether a patient is online or offline.
 * Applicable only for patients who are primary users of a cellphone device. * 
 * 
 * @author Senthil N
 *
 */
public class AppHeartBeatDto {
	private AppHeartbeat appHeartbeat;

	public AppHeartbeat getAppHeartbeat() {
		return appHeartbeat;
	}

	public void setAppHeartbeat(AppHeartbeat appHeartbeat) {
		this.appHeartbeat = appHeartbeat;
	}
	
}
