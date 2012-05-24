package org.hxzon.netprotocol.quick.packet;

import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.sv.SvPduParser;
import org.hxzon.netprotocol.quick.common.QPacketConstants;
import org.hxzon.netprotocol.quick.field.QProtocolInt31Field;
import org.hxzon.util.BytesUtil;

public class QSvPacket extends QPacket {
    public static QProtocolInt31Field fetchAppId(byte[] data, int headerOffset) {
        int fieldOffset = headerOffset + 0;
        int fieldLen = 2;
        int value = (int) BytesUtil.toSigned(data, fieldOffset, fieldLen);
        QProtocolInt31Field field = new QProtocolInt31Field();
        field.init(fieldOffset, fieldLen, "appId", "应用标识");
        field.setValue(value);
        return field;
    }

    public static QProtocolInt31Field fetchPduLen(byte[] data, int headerOffset) {
        int fieldOffset = headerOffset + 2;
        int fieldLen = 2;
        int value = (int) BytesUtil.toSigned(data, fieldOffset, fieldLen);
        QProtocolInt31Field field = new QProtocolInt31Field();
        field.init(fieldOffset, fieldLen, "pduLen", "PDU长度");
        field.setValue(value);
        return field;
    }

    public static QProtocolInt31Field fetchReserved1(byte[] data, int headerOffset) {
        int fieldOffset = headerOffset + 4;
        int fieldLen = 2;
        int value = (int) BytesUtil.toSigned(data, fieldOffset, fieldLen);
        QProtocolInt31Field field = new QProtocolInt31Field();
        field.init(fieldOffset, fieldLen, "reserved1", "保留1");
        field.setValue(value);
        return field;
    }

    public static QProtocolInt31Field fetchReserved2(byte[] data, int headerOffset) {
        int fieldOffset = headerOffset + 6;
        int fieldLen = 2;
        int value = (int) BytesUtil.toSigned(data, fieldOffset, fieldLen);
        QProtocolInt31Field field = new QProtocolInt31Field();
        field.init(fieldOffset, fieldLen, "reserved2", "保留2");
        field.setValue(value);
        return field;
    }

    public static BerNode fetchSmvpdu(byte[] data, int headerOffset) {
        return SvPduParser.parser.parseSv(data, headerOffset + 8);
    }

    public String defaultDesc() {
        return QPacketConstants.PacketTypeDesc_Sv;
    }
}
