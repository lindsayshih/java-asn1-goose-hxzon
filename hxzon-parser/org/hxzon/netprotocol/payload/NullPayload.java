package org.hxzon.netprotocol.payload;

public class NullPayload extends DataPayload {
	public String getType() {
		return getSrcPacket().getType();
	}

	public String getDisplayString() {
		return "null";
	}
}
