package org.hxzon.netprotocol.payload;

public class ErrorPayload extends DataPayload {
	private String errorMessage;

	public ErrorPayload() {

	}

	public ErrorPayload(String error) {
		this.errorMessage = error;
	}

	public String getType() {
		return getSrcPacket().getType();
	}

	public String getDisplayString() {
		return "error payload(" + errorMessage + ")";
	}

	public int getLength() {
		return 0;
	}
}
