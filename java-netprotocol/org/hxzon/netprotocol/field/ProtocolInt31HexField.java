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
        String tmp = Integer.toHexString(getValue());
        while (tmp.length() < this.getLen() * 2) {
            tmp = "0" + tmp;
        }
        return tmp;
    }
}
