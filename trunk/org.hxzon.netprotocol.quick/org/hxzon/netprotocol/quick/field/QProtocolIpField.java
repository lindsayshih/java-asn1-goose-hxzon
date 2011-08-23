package org.hxzon.netprotocol.quick.field;

import org.hxzon.util.BytesUtil;

public class QProtocolIpField extends QProtocolByteArrayField {
	public String getValueAsString() {
		String tmp = "";
		for (int i = 0; i < 4; i++) {
			tmp += BytesUtil.toUInt(getValue()[i]) + ".";
		}
		return tmp;
	}
}
