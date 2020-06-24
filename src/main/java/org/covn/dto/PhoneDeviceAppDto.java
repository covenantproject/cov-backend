package org.covn.dto;

import org.covn.model.db.PhoneDeviceApp;

/** Info about the phone device used by the patient, including its manufacturer/model,
 * IMEI, MAC ID and other information.
 * 
 * @author Senthil N
 *
 */
public class PhoneDeviceAppDto {

	private PhoneDeviceApp phoneDeviceApp;

	public PhoneDeviceApp getPhoneDeviceApp() {
		return phoneDeviceApp;
	}

	public void setPhoneDeviceApp(PhoneDeviceApp phoneDeviceApp) {
		this.phoneDeviceApp = phoneDeviceApp;
	}
	
	
}
