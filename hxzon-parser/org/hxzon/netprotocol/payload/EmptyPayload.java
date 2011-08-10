package org.hxzon.netprotocol.payload;

public class EmptyPayload extends DataPayload {
	public String getType() {
		return getSrcPacket().getType();
	}
}
