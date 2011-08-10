package org.hxzon.netprotocol.payload;

public class UnknownPayload extends DataPayload {
	public String getType() {
		return getSrcPacket().getType() + "(unknow payload)";
	}

	public String getDisplayString() {
		return "unknow";
	}
}
