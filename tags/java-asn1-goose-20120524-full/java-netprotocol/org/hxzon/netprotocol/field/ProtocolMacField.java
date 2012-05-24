package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.BytesUtil;

public class ProtocolMacField extends ProtocolByteArrayField {

    public ProtocolMacField(String id, String name, int offset, int len, Packet srcPacket) {
        super(id, name, offset, len, srcPacket);
    }

    public String getValueAsString() {
        return BytesUtil.toDisplayHexString(getValue());
    }
}
