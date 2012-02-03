package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolInt31HexField extends ProtocolInt31Field {
    public ProtocolInt31HexField(String name, String display, int offset, int len, Packet srcPacket) {
        this(name, display, offset, len, false, srcPacket);
    }

    public ProtocolInt31HexField(String name, String display, int offset, int len, boolean unsigned, Packet srcPacket) {
        super(name, display, offset, len, unsigned, srcPacket);
    }

    @Override
    public String getValueAsString() {
        return Integer.toHexString(getValue());
    }
}
