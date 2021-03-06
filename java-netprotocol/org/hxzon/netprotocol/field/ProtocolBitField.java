package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolBitField extends ProtocolField {

    public ProtocolBitField(String id, String name, int offset, int bitOffset, int bitLen, Packet srcPacket) {
        setPacket(srcPacket);
        setId(id);
        setName(name);
        int len = (bitLen + 7) / 8;
        setSaveOffsetAndLen(srcPacket, offset, len);
        if (isRight()) {
            _value = srcPacket.getIntByBit(getOffset(), getLen(), bitOffset, bitLen);
        }
    }

    private int _value;

    public int getValue() {
        return _value;
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(getValue());
    }
}
