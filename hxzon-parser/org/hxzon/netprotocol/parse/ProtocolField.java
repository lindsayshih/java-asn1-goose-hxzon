package org.hxzon.netprotocol.parse;

import org.hxzon.netprotocol.packet.Packet;

public abstract class ProtocolField {
	private int offset;
	private int len;
	private String name;
	private String displayString;

	public abstract String getValueAsString();

	public void setSaveOffsetAndLen(Packet packet, int offset, int len) {
		int headerLength = packet.getHeaderLength();
		if (offset < 0) {
			offset = 0;
		}
		if (offset > headerLength) {
			System.err.println("err offset(" + offset + ") when headerLength=" + headerLength);
			offset = headerLength;
		}
		setOffset(packet.getOffset() + offset);
		if (len < 0) {
			len = 0;
		}
		if (offset + len > headerLength) {
			System.err.println("err len(" + len + ") when offset=" + offset + ",and headerLength=" + headerLength);
			len = headerLength - offset;
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
}
