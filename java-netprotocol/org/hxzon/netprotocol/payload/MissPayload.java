package org.hxzon.netprotocol.payload;

public class MissPayload extends DataPayload {
    public String getProtocolTypeDesc() {
        return getSrcPacket().getProtocolTypeDesc();
    }

    public String getName() {
        return "miss";
    }
}
