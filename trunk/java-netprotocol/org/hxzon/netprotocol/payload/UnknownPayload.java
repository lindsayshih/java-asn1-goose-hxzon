package org.hxzon.netprotocol.payload;

public class UnknownPayload extends DataPayload {
    public String getProtocolTypeDesc() {
        return getSrcPacket().getProtocolTypeDesc() + "(unknow payload)";
    }

    public String getName() {
        return "unknow";
    }
}
