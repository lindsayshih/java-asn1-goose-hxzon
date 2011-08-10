package org.hxzon.netprotocol.parse;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolBitField extends ProtocolField {

	public ProtocolBitField(String name, String display, int offset, int bitOffset, int bitLen, Packet srcPacket) {
		setName(name);
		setDisplayString(display);
		int len = (bitLen + 7) / 8;
		setSaveOffsetAndLen(srcPacket, offset, len);
		if (isRight()) {
			value = srcPacket.getIntByBit(getOffset(), getLen(), bitOffset, bitLen);
		}
	}

	private int value;

	public int getValue() {
		return value;
	}

	@Override
	public String getValueAsString() {
		return String.valueOf(getValue());
	}
}
