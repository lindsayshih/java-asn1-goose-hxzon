package org.hxzon.netprotocol.quick.field;

public class QProtocolByteArrayField extends QProtocolField {

	private byte[] value;

	public void setValue(byte[] value) {
		this.value = value;
	}

	public byte[] getValue() {
		return value;
	}

	@Override
	public String getValueAsString() {
		return String.valueOf(getValue());
	}
}
