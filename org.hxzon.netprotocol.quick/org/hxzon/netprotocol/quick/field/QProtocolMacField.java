package org.hxzon.netprotocol.quick.field;

import org.hxzon.util.BytesUtil;

public class QProtocolMacField extends QProtocolByteArrayField {
	public String getValueAsString() {
		return BytesUtil.toDisplayHexString(getValue());
	}
}
