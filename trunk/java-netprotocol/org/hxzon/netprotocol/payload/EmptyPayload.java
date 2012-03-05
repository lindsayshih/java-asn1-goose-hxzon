package org.hxzon.netprotocol.payload;

import org.hxzon.netprotocol.common.PayloadHelper;

public class EmptyPayload extends PayloadHelper {
    public String getProtocolTypeDesc() {
        return getSrcPacket().getProtocolTypeDesc();
    }

    public String getName() {
        return "empty";
    }
}
