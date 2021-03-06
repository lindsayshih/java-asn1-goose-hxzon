package org.hxzon.asn1.mms.common;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;

import org.hxzon.asn1.core.type.BerOctetString;
import org.hxzon.util.BytesUtil;

public class FloatingPoint extends BerOctetString {
    public static final DecimalFormat decimalFormat = new DecimalFormat();
    static {
        decimalFormat.applyPattern("0.000000");
    }

    public FloatingPoint() {
        setId("floatingPoint");
        setName("floatingPoint");
    }

    public byte[] getValue() {
        return BytesUtil.copyBytes(super.getValue(), 1);
    }

    public String getValueAsString() {
        //FIXME how to do?
        ByteBuffer bb = ByteBuffer.wrap(getValue());
//        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.order(ByteOrder.BIG_ENDIAN);
        float f = bb.getFloat();
        return decimalFormat.format(f);
//		return String.valueOf(f);
//		return new BigDecimal(String.valueOf(f)).toPlainString();
//		return String.valueOf(FloatByteArrayUtil.byteArrayToFloat(getValue()));
//		return String.valueOf(FloatByteArrayUtil.byteArrayToDouble(getValue()));
    }
}
