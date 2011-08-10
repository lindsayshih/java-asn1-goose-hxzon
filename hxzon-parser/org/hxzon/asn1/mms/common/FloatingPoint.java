package org.hxzon.asn1.mms.common;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.chaosinmotion.asn1.BerOctetString;

public class FloatingPoint extends BerOctetString {
	public FloatingPoint() {
		setName("floatingPoint");
		setDisplayString("floatingPoint");
	}

	public String getValueAsString() {
		//FIXME how to do?
		ByteBuffer bb = ByteBuffer.wrap(getValue());
//        bb.order(ByteOrder.LITTLE_ENDIAN);
		bb.order(ByteOrder.BIG_ENDIAN);
		float f = bb.getFloat();
		return String.valueOf(f);
//		return new BigDecimal(String.valueOf(f)).toPlainString();
//		return String.valueOf(FloatByteArrayUtil.byteArrayToFloat(getValue()));
//		return String.valueOf(FloatByteArrayUtil.byteArrayToDouble(getValue()));
	}
}
