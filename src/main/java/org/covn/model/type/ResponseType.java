package org.covn.model.type;

public enum ResponseType implements BaseEnum{
	covenant("response_covenant"),
	phone("response_phone"),
	video("response_video"),
	sms("response_sms"),
	telehealth("response_telehealth"),
	whatsapp("response_whatsapp"),
	telegram("response_telegram"),
	inperson("response_inperson"),
	other("response_other"),
	;
	private final String key;
	private ResponseType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
