package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolInt31Field extends ProtocolField {
    public ProtocolInt31Field(String name, String display, int offset, int len, Packet srcPacket) {
        this(name, display, offset, len, false, srcPacket);
    }

    public ProtocolInt31Field(String name, String display, int offset, int len, boolean unsigned, Packet srcPacket) {
        setPacket(srcPacket);
        setName(name);
        setDisplayString(display);
        setSaveOffsetAndLen(srcPacket, offset, len);
//        this.unsigned = unsigned;
        if (isRight()) {
            if (unsigned) {
                value = (int) srcPacket.getUnsigned(getOffset(), getLen());
            } else {
                value = (int) srcPacket.getSigned(getOffset(), getLen());
            }
        }
    }

//    private boolean unsigned = false;
//    private int bitLen = 31;
    private int value;

    public int getValue() {
        return value;
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(getValue());
    }
}
