package org.hxzon.asn1;

import java.util.BitSet;

public class BitStringPresentation {
	private BitSet value;//final = new BitSet();
	private int bitLen = 0;
	private int bitPadLen = 0;

	public BitSet getValue() {
		return value;
	}

	public int getBitLen() {
		return bitLen;
	}

	public int getBitPadLen() {
		return bitPadLen;
	}

	public void init(int bitPadLen, int byteLen) {
		this.bitPadLen = bitPadLen;
		this.bitLen = byteLen * 8 - bitPadLen;
		value = new BitSet(bitLen);
	}

	public String toString() {
		return "bitPadLen=" + bitPadLen + ",bitLen=" + bitLen + "," + getBitString();
	}

	public String getBitString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bitLen; i++) {
			sb.append(value.get(i) ? '1' : '0');
			if (i % 8 == 7) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
