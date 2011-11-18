package org.hxzon.asn1.core.type.ext;

import java.util.BitSet;

public class BitStringPresentation {
    private BitSet _value;//final = new BitSet();
    private int _bitLen = 0;
    private int _bitPadLen = 0;

    public BitSet getValue() {
        return _value;
    }

    public int getBitLen() {
        return _bitLen;
    }

    public int getBitPadLen() {
        return _bitPadLen;
    }

    public void init(int bitPadLen, int byteLen) {
        this._bitPadLen = bitPadLen;
        this._bitLen = byteLen * 8 - bitPadLen;
        _value = new BitSet(_bitLen);
    }

    public String toString() {
        return "bitPadLen=" + _bitPadLen + ",bitLen=" + _bitLen + "," + getBitString();
    }

    public String getBitString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _bitLen; i++) {
            sb.append(_value.get(i) ? '1' : '0');
            if (i % 8 == 7) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
