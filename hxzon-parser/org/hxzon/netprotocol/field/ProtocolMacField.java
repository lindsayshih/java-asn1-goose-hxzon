package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.BytesUtil;

public class ProtocolMacField extends ProtocolByteArrayField {

    public ProtocolMacField(String name, String display, int offset, int len, Packet srcPacket) {
        super(name, display, offset, len, srcPacket);
    }

    public String getValueAsString() {
        return BytesUtil.toDisplayHexString(getValue());
    }
}
