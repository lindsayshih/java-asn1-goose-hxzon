package org.hxzon.netprotocol.payload;

import org.hxzon.netprotocol.common.PayloadHelper;

public class MissPayload extends PayloadHelper {
    public String getProtocolTypeDesc() {
        return getSrcPacket().getProtocolTypeDesc() + "(miss payload)";
    }

    public String getName() {
        return "miss";
    }
}
