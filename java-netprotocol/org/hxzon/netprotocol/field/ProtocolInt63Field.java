package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolInt63Field extends ProtocolField {
    public ProtocolInt63Field(String name, String display, int offset, int len, Packet srcPacket) {
        this(name, display, offset, len, false, srcPacket);
    }

    public ProtocolInt63Field(String name, String display, int offset, int len, boolean unsigned, Packet srcPacket) {
        setPacket(srcPacket);
        setName(name);
        setDisplayString(display);
        setSaveOffsetAndLen(srcPacket, offset, len);
//      this.unsigned = unsigned;
        if (isRight()) {
            if (unsigned) {
                value = srcPacket.getUnsigned(getOffset(), getLen());
            } else {
                value = srcPacket.getSigned(getOffset(), getLen());
            }
        }
    }

//  private boolean unsigned = false;
//  private int bitLen = 31;
    private long value;

    public long getValue() {
        return value;
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(getValue());
    }
}
