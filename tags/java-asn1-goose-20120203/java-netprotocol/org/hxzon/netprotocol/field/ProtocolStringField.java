package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolStringField extends ProtocolField {
    public ProtocolStringField(String name, String display, int offset, int len, Packet srcPacket) {
        setPacket(srcPacket);
        setName(name);
        setDisplayString(display);
        setSaveOffsetAndLen(srcPacket, offset, len);
        _value = srcPacket.getHexString(getOffset(), getLen());
    }

    private String _value;

    public String getValue() {
        return _value;
    }

    @Override
    public String getValueAsString() {
        return _value;
    }
}
