package org.hxzon.netprotocol.field;

import java.math.BigInteger;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolIntBigField extends ProtocolField {
    public ProtocolIntBigField(String name, String display, int offset, int len, Packet srcPacket) {
        setPacket(srcPacket);
        setName(name);
        setDisplayString(display);
        setSaveOffsetAndLen(srcPacket, offset, len);
        value = new BigInteger(srcPacket.getHexString(getOffset(), getLen()), 16);
    }

    private BigInteger value;

    public BigInteger getValue() {
        return value;
    }

    @Override
    public String getValueAsString() {
        return value.toString();
    }
}
