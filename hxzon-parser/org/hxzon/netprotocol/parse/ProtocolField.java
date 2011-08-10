package org.hxzon.netprotocol.parse;

import org.hxzon.netprotocol.packet.Packet;

public abstract class ProtocolField {
	private Packet packet;
	private int offset;
	private int len;
	private String name;
	private String displayString;
	private int miss = State_Rigth;
	public static final int State_Rigth = 0;
	public static final int State_WrongOffset = 1;
	public static final int State_WrongLen = 2;

	public abstract String getValueAsString();

	public String getValueAsDisplay() {
		if (miss == State_WrongOffset) {
			return "wrong offset";
		} else if (miss == State_WrongLen) {
			return "miss";
		} else {
			return getValueAsString();
		}
	}

	public boolean isRight() {
		return miss == State_Rigth;
	}

	public void setSaveOffsetAndLen(Packet packet, int offset, int len) {
		int headerLength = packet.getHeaderLength();
		if (offset < 0) {
			offset = 0;
		}
		if (offset > headerLength) {
			System.err.println("err offset(" + offset + ") when headerLength=" + headerLength);
			offset = headerLength;
			miss = State_WrongOffset;
		}
		setOffset(packet.getOffset() + offset);
		if (len < 0) {
			len = 0;
		}
		if (offset + len > headerLength) {
			System.err.println("err len(" + len + ") when offset=" + offset + ",and headerLength=" + headerLength);
			len = headerLength - offset;
			miss = State_WrongLen;
		}
		setLen(len);
	}

	public int getOffset() {
		return offset;
	}

	private void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLen() {
		return len;
	}

	private void setLen(int len) {
		this.len = len;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayString() {
		return displayString;
	}

	public void setDisplayString(String display) {
		this.displayString = display;
	}

	public String toString() {
		return name;
	}

	public Packet getPacket() {
		return packet;
	}

	public void setPacket(Packet packet) {
		this.packet = packet;
	}
}
