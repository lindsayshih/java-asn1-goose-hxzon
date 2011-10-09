package org.hxzon.netprotocol.payload;

public class NullPayload extends DataPayload {
    public String getProtocolTypeDesc() {
        return getSrcPacket().getProtocolTypeDesc();
    }

    public String getDisplayString() {
        return "null";
    }
}
