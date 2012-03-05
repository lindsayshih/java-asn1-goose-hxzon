package org.hxzon.netprotocol.payload;

import org.hxzon.netprotocol.common.PayloadHelper;

public class ErrorPayload extends PayloadHelper {
    private String _errorMessage;

    public ErrorPayload() {

    }

    public ErrorPayload(String error) {
        this._errorMessage = error;
    }

    public String getProtocolTypeDesc() {
        return getSrcPacket().getProtocolTypeDesc();
    }

    public String getName() {
        return "error payload(" + _errorMessage + ")";
    }

    public int getLength() {
        return 0;
    }
}
