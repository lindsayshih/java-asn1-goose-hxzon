package org.hxzon.netprotocol.parse;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolStringField extends ProtocolField {
	public ProtocolStringField(String name, String display, int offset, int len, Packet srcPacket) {
		setPacket(srcPacket);
		setName(name);
		setDisplayString(display);
		setSaveOffsetAndLen(srcPacket, offset, len);
		value = srcPacket.getHexString(getOffset(), getLen());
	}

	private String value;

	public String getValue() {
		return value;
	}

	@Override
	public String getValueAsString() {
		return value;
	}
}
