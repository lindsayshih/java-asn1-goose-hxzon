package org.hxzon.netprotocol.parse;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolByteArrayField extends ProtocolField {
	public ProtocolByteArrayField(String name, String display, int offset, int len, Packet srcPacket) {
		setName(name);
		setDisplayString(display);
		setSaveOffsetAndLen(srcPacket, offset, len);
		value = srcPacket.getByteArray(getOffset(), getLen());
	}

	private byte[] value;

	public byte[] getValue() {
		return value;
	}

	@Override
	public String getValueAsString() {
		return String.valueOf(getValue());
	}
}
