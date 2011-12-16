package org.hxzon.netprotocol.payload;

public class ErrorPayload extends DataPayload {
    private String _errorMessage;

    public ErrorPayload() {

    }

    public ErrorPayload(String error) {
        this._errorMessage = error;
    }

    public String getProtocolTypeDesc() {
        return getSrcPacket().getProtocolTypeDesc();
    }

    public String getDisplayString() {
        return "error payload(" + _errorMessage + ")";
    }

    public int getLength() {
        return 0;
    }
}
