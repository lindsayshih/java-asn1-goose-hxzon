package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolInt31HexField extends ProtocolInt31Field {
    public ProtocolInt31HexField(String id, String name, int offset, int len, Packet srcPacket) {
        this(id, name, offset, len, false, srcPacket);
    }

    public ProtocolInt31HexField(String id, String name, int offset, int len, boolean unsigned, Packet srcPacket) {
        super(id, name, offset, len, unsigned, srcPacket);
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
