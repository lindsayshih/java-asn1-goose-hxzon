package org.hxzon.netprotocol.quick.packet;

import org.hxzon.netprotocol.quick.common.QPacketConstants;
import org.hxzon.netprotocol.quick.field.QProtocolBitField;
import org.hxzon.netprotocol.quick.field.QProtocolStringField;
import org.hxzon.util.BytesUtil;

public class QVlanPacket extends QPacket {
	public static QProtocolStringField fetchEthernetType(byte[] data, int headerOffset) {
		int fieldOffset = headerOffset + 2;
		int fieldLen = 2;
		String value = BytesUtil.toHexString(data, fieldOffset, fieldLen);
		QProtocolStringField field = new QProtocolStringField();
		field.init(fieldOffset, fieldLen, "type", "以太网类型");
		field.setValue(value);
		return field;
	}

	public static QProtocolBitField fetchPriority(byte[] data, int headerOffset) {
		int fieldOffset = headerOffset + 0;
		int fieldLen = 1;
		int value = BytesUtil.toInt(data, fieldOffset, fieldLen, 0, 3);
		QProtocolBitField field = new QProtocolBitField();
		field.init(fieldOffset, fieldLen, "priority", "优先级");
		field.setValue(value);
		return field;
	}

	public static QProtocolBitField fetchCfi(byte[] data, int headerOffset) {
		int fieldOffset = headerOffset + 0;
		int fieldLen = 1;
		int value = BytesUtil.toInt(data, fieldOffset, fieldLen, 3, 1);
		QProtocolBitField field = new QProtocolBitField() {
			public String getValueAsString() {
				return getValue() == 0 ? "规范格式" : "非规范格式";
			}
		};
		field.init(fieldOffset, fieldLen, "cfi", "格式");
		field.setValue(value);
		return field;
	}

	public static QProtocolBitField fetchVlanId(byte[] data, int headerOffset) {
		int fieldOffset = headerOffset + 0;
		int fieldLen = 2;
		int value = BytesUtil.toInt(data, fieldOffset, fieldLen, 4, 12);
		QProtocolBitField field = new QProtocolBitField();
		field.init(fieldOffset, fieldLen, "vlan id", "VLAN ID");
		field.setValue(value);
		return field;
	}

	public String defaultDesc() {
		return QPacketConstants.PacketTypeDesc_Vlan;
	}
}
