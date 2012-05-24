package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolHexStringField extends ProtocolField {
    public ProtocolHexStringField(String id, String name, int offset, int len, Packet srcPacket) {
        setPacket(srcPacket);
        setId(id);
        setName(name);
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
