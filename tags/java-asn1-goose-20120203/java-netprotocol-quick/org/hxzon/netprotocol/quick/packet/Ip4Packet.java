package org.hxzon.netprotocol.quick.packet;

import org.hxzon.netprotocol.quick.common.QPacketConstants;
import org.hxzon.netprotocol.quick.field.QProtocolStringField;
import org.hxzon.util.BytesUtil;

public class Ip4Packet extends QPacket {
    public static QProtocolStringField fetchProtocolCode(byte[] data, int headerOffset) {
        int fieldOffset = headerOffset + 9;
        int fieldLen = 1;
        String value = BytesUtil.toHexString(data, fieldOffset, fieldLen);
        QProtocolStringField field = new QProtocolStringField();
        field.init(fieldOffset, fieldLen, "protocol", "协议类型");
        field.setValue(value);
        return field;
    }

    public String defaultDesc() {
        return QPacketConstants.PacketTypeDesc_Ip4;
    }
}
