package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolByteArrayField extends ProtocolField {
    public ProtocolByteArrayField(String id, String name, int offset, int len, Packet srcPacket) {
        setPacket(srcPacket);
        setId(id);
        setName(name);
        setSaveOffsetAndLen(srcPacket, offset, len);
//		if (isRight()) {
        _value = srcPacket.getByteArray(getOffset(), getLen());
//		}
    }

    private byte[] _value;

    public byte[] getValue() {
        return _value;
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(getValue());
    }
}
