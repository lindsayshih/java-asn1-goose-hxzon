package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolAsciiStringField extends ProtocolField {
    public ProtocolAsciiStringField(String name, String display, int offset, int len, Packet srcPacket) {
        setPacket(srcPacket);
        setName(name);
        setDisplayString(display);
        setSaveOffsetAndLen(srcPacket, offset, len);
        byte[] tmp = srcPacket.getByteArray(getOffset(), getLen());
        StringBuilder sb = new StringBuilder();
        for (byte b : tmp) {
            sb.append((char) b);
        }
        value = sb.toString();
    }

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public String getValueAsString() {
        return value;
    }
}
