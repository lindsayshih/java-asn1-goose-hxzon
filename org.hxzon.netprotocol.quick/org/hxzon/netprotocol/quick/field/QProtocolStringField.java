package org.hxzon.netprotocol.quick.field;

public class QProtocolStringField extends QProtocolField {

	private String value;

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String getValueAsString() {
		return value;
	}
}
