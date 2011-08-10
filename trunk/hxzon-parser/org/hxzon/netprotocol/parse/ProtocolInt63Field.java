package org.hxzon.netprotocol.parse;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolInt63Field extends ProtocolField {

	public ProtocolInt63Field(String name, String display, int offset, int len, Packet srcPacket) {
		setName(name);
		setDisplayString(display);
		setSaveOffsetAndLen(srcPacket, offset, len);
		value = srcPacket.getLong(getOffset(), getLen());
	}

	private long value;

	public long getValue() {
		return value;
	}

	@Override
	public String getValueAsString() {
		return String.valueOf(getValue());
	}
}
