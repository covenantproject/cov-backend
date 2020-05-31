package org.covn.model.type;

public enum DeviceOs implements BaseEnum{
	android("device_os_android"),
	other("device_os_other"),
	ios("device_os_ios"),
	;
	private final String key;
	private DeviceOs(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
