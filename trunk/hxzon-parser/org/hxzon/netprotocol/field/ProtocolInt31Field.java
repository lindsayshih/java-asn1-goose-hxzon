package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolInt31Field extends ProtocolField {
    public ProtocolInt31Field(String name, String display, int offset, int len, Packet srcPacket) {
        setPacket(srcPacket);
        setName(name);
        setDisplayString(display);
        setSaveOffsetAndLen(srcPacket, offset, len);
        if (isRight()) {
            value = (int) srcPacket.getSigned(getOffset(), getLen());
        }
    }

    private int value;

    public int getValue() {
        return value;
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(getValue());
    }
}
