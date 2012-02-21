package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolInt63Field extends ProtocolField {
    public ProtocolInt63Field(String name, String display, int offset, int len, Packet srcPacket) {
        this(name, display, offset, len, false, srcPacket);
    }

    public ProtocolInt63Field(String name, String display, int offset, int len, boolean unsigned, Packet srcPacket) {
        setPacket(srcPacket);
        setId(name);
        setName(display);
        setSaveOffsetAndLen(srcPacket, offset, len);
//      this.unsigned = unsigned;
        if (isRight()) {
            if (unsigned) {
                _value = srcPacket.getUnsigned(getOffset(), getLen());
            } else {
                _value = srcPacket.getSigned(getOffset(), getLen());
            }
        }
    }

//  private boolean unsigned = false;
//  private int bitLen = 31;
    private long _value;

    public long getValue() {
        return _value;
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(getValue());
    }
}
