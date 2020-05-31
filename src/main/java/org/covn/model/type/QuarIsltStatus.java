package org.covn.model.type;

public enum QuarIsltStatus implements BaseEnum{
	isltEnded("quarislt_islt_ended"),
	isolated("quarislt_isolated"),
	quarSelf("quarislt_quar_self"),
	quarTempLeave("quarislt_quar_temp_leave"),
	quarEnded("quarislt_quar_ended"),
	stayhome("quarislt_stayhome"),
	none("quarislt_none"),
	quarMed("quarislt_quar_med"),
	hospitalized("quarislt_hospitalized"),
	;
	private final String key;
	private QuarIsltStatus(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
