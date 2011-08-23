package org.hxzon.netprotocol.quick.field;

public class QProtocolInt31Field extends QProtocolField {

	private int value;

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String getValueAsString() {
		return String.valueOf(getValue());
	}
}
