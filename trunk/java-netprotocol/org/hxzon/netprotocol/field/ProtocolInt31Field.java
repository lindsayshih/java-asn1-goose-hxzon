package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolInt31Field extends ProtocolField {
    public ProtocolInt31Field(String id, String name, int offset, int len, Packet srcPacket) {
        this(id, name, offset, len, false, srcPacket);
    }

    public ProtocolInt31Field(String id, String name, int offset, int len, boolean unsigned, Packet srcPacket) {
        setPacket(srcPacket);
        setId(id);
        setName(name);
        setSaveOffsetAndLen(srcPacket, offset, len);
//        this.unsigned = unsigned;
        if (isRight()) {
            if (unsigned) {
                _value = (int) srcPacket.getUnsigned(getOffset(), getLen());
            } else {
                _value = (int) srcPacket.getSigned(getOffset(), getLen());
            }
        }
    }

//    private boolean unsigned = false;
//    private int bitLen = 31;
    private int _value;

    public int getValue() {
        return _value;
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(getValue());
    }
}
