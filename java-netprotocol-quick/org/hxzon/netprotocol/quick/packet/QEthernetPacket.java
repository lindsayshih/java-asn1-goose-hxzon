package org.hxzon.netprotocol.quick.packet;

import org.hxzon.netprotocol.quick.common.QPacketConstants;
import org.hxzon.netprotocol.quick.field.QProtocolByteArrayField;
import org.hxzon.netprotocol.quick.field.QProtocolStringField;
import org.hxzon.util.BytesUtil;

public class QEthernetPacket extends QPacket {

    public static QProtocolByteArrayField fetchSrcMac(byte[] data, int headerOffset) {
        int fieldOffset = headerOffset + 6;
        int fieldLen = 6;
        byte[] value = BytesUtil.copyBytes(data, fieldOffset, fieldLen);
        QProtocolByteArrayField field = new QProtocolByteArrayField();
        field.init(fieldOffset, fieldLen, "srcMac", "源网卡地址");
        field.setValue(value);
        return field;
    }

    public static QProtocolByteArrayField fetchDestMac(byte[] data, int headerOffset) {
        int fieldOffset = headerOffset + 0;
        int fieldLen = 6;
        byte[] value = BytesUtil.copyBytes(data, fieldOffset, fieldLen);
        QProtocolByteArrayField field = new QProtocolByteArrayField();
        field.init(fieldOffset, fieldLen, "destMac", "目的网卡地址");
        field.setValue(value);
        return field;
    }

    public static QProtocolStringField fetchEthernetType(byte[] data, int headerOffset) {
        int fieldOffset = headerOffset + 12;
        int fieldLen = 2;
        String value = BytesUtil.toHexString(data, fieldOffset, fieldLen);
        QProtocolStringField field = new QProtocolStringField();
        field.init(fieldOffset, fieldLen, "type", "以太网类型");
        field.setValue(value);
        return field;
    }

    public String defaultDesc() {
        return QPacketConstants.PacketTypeDesc_Ethernet;
    }
}
