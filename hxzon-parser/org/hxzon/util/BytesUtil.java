package org.hxzon.util;

public class BytesUtil {
	//2<<0=1;2<<1=2;2<<2=4;2<<3=8;2<<4=16;2<<5=32;
	//2<<6=64;2<<7=128;2<<8=256;2<<9=512
//	public static final int[] bitMasks = { 1, 3, 7, 15, 31, 63, 127, 255 };

	public static int toIntByBitLen(byte orig, int bitLen) {
//		int bitMask = bitMasks[len];
//		return data & bitMask;
		return orig & ((2 << (bitLen - 1)) - 1);
	}

	public static int toInt(byte orig, int bitOffset) {
		return toIntByBitLen(orig, 8 - bitOffset);
	}

	public static int toInt(byte orig, int bitOffset, int bitLen) {
//		int tmp = toUInt(orig);//must uint
//		int mark = ((2 << (bitLen - 1)) - 1);
//		tmp = tmp >> (8 - bitOffset - bitLen);
//		tmp = tmp & mark;
//		return tmp;
		return (toUInt(orig) >> (8 - bitOffset - bitLen)) & ((2 << (bitLen - 1)) - 1);
	}

	//	public static int toInt(byte[] orig, int offset, int len, int bitOffset) {
//		int bitLen = len * 8 - bitOffset;
//		int byteLen = bitLen / 8;
//		int result = 0;
//		int[] ints = new int[byteLen];
////		byte[] tmp=getBytes(bytes,offset,len);
//		for (int i = 0; i < byteLen; i++) {
////			byte tmp2=bytes[offset+len-1-i];
//			ints[i] = toUInt(orig[offset + len - 1 - i]) << (8 * i);//*(2^8)
//			result += ints[i];
//		}
//		int first = toInt(orig[offset + bitOffset / 8], bitOffset);
////		int first=toIntByBitLen(orig[offset+bitOffset/8],8-bitOffset);
//		first <<= (8 * byteLen);//*(2^8)
//		result += first;
//		return result;
//	}
	public static int toInt(byte[] orig, int offset, int len, int bitOffset, int bitLen) {
		String tmp = toBitString(orig, offset, len, bitOffset, bitLen);
		return Integer.valueOf(tmp, 2);
	}

	public static int toInt(byte[] orig, int offset, int len, int bitOffset) {
		return toInt(orig, offset, len, bitOffset, len * 8 - bitOffset);
	}

	public static int toUInt(byte orig) {
		return (orig & 0xff);//right
	}

	public static int[] toUInt(byte[] orig) {
		int[] result = new int[orig.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = (orig[i] & 0xff);
		}
		return result;
	}

//	public static int toInt2(byte[] orig, int offset, int len) {
//		if (len > 4) {
//			throw new IllegalArgumentException(len + " > 4 for signed int,will overflow");
//		}
//		int result = 0;
//		int[] ints = toUIntArray(orig, offset, len);
//		for (int i = 0; i < len; i++) {
//			result |= ((long) ints[i] << ((len - 1 - i) * 8));
//		}
//		return result;
//	}

//	public static int toInt(byte[] orig, int offset, int len) {
//		if (len <= 0) {
//			return 0;
//		}
//		if (len > 4) {
//			throw new IllegalArgumentException(len + " > 4 for signed int,will overflow");
//		}
//		int result = orig[offset];//fixbug:lost sign
//		for (int i = 1; i < len; i++) {
//			result = (result << 8) | (orig[offset + i] & 0xff);
//		}
//		return result;
//	}

	public static long toSigned(byte[] orig, int offset, int len) {
		if (len <= 0) {
			return 0;
		}
		if (len > 8) {
			throw new IllegalArgumentException(len + " > 8 for singed long,will overflow");
		}
		long result = orig[offset];//fixbug:lost sign
		for (int i = 1; i < len; i++) {
			result = (result << 8) | (orig[offset + i] & 0xff);
		}
		return result;
	}
	
	public static long toUnsigned(byte[] orig, int offset, int len) {
		if (len <= 0) {
			return 0;
		}
		if (len >= 8) {
			throw new IllegalArgumentException(len + " >= 8 for unsinged long,will overflow");
		}
		long result = 0;
		for (int i = 0; i < len; i++) {
			result = (result << 8) | (orig[offset + i] & 0xff);
		}
		return result;
	}

	public static int[] toUIntArray(byte[] orig, int offset, int len) {
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			result[i] = toUInt(orig[offset + i]);
		}
		return result;
	}

//--------------------------------------------------------------------------
	public static String toBitString(byte orig, int bitOffset, int bitLen) {
		StringBuilder sb = new StringBuilder();
		int set = 0;
		for (int i = 0; i < bitLen; i++) {
			set = (orig & (0x80 >> (bitOffset + i)));
			sb.append(set == 0 ? 0 : 1);
		}
		return sb.toString();
	}

	public static String toBitString(byte[] orig, int offset, int len) {
		StringBuilder sb = new StringBuilder();
		int set = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < 8; j++) {
				set = (orig[offset + i] & (0x80 >> j));
				sb.append(set == 0 ? 0 : 1);
			}
		}
		return sb.toString();
	}

	public static String toBitString(byte[] orig, int offset, int len, int bitOffset, int bitLen) {
		String all = toBitString(orig, offset, len);
		return all.substring(bitOffset, bitOffset + bitLen);
	}

//--------------------------------------------------------------------------
	public static String toDisplayHexString(byte[] orig) {
		return toDisplayHexString(orig, 0, orig.length);
	}

	public static String toDisplayHexString(byte[] orig, int offset, int len) {
		return implToDisplayHexString(orig, offset, len, 16, " ");
	}

	private static String implToDisplayHexString(byte[] orig, int offset, int len, int lineLen, String split) {

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < len; i++) {
			buffer.append(toHexCharArray(orig[offset + i]));
			buffer.append(split);
			if (i % lineLen == lineLen - 1) {
				buffer.append("\n");
			}
		}
		return buffer.toString();
	}

	public static String toDisplayHexString(byte[]... orig) {
		return toDisplayHexString(orig, 0, -1);
	}

	public static String toDisplayHexString(byte[][] orig, int offset, int len) {
		return implToDisplayHexString(orig, offset, len);
	}

	public static String implToDisplayHexString(byte[][] orig, int offset, int len) {
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (byte[] bytes : orig) {
			for (int i = 0; i < bytes.length; i++, j++) {
				sb.append(toHexCharArray(bytes[i]));
				sb.append(" ");
				if (j % 16 == 15) {
					sb.append("\n");
				}
			}
		}
		return sb.toString();
	}

	//--------------------------------------------------------------------------
	public static String toHexString(byte[] orig) {
		return String.valueOf(toHexCharArray(orig));
	}

	public static String toHexString(byte[] orig, int offset, int len) {
		return String.valueOf(implToHexCharArray(orig, offset, len));
	}

	public static String toHexString(byte orig) {
		return String.valueOf(toHexCharArray(orig));
	}

	public static String toIndex(byte[] orig) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < orig.length; i++) {
			if (i != 0 && i % 16 == 0) {
				buffer.append("\n");
			}
			if (i % 16 == 0) {
				String row = Integer.toHexString(i);
				if (row.length() == 1) {
					row = "0x000" + row;
				} else if (row.length() == 2) {
					row = "0x00" + row;
				} else if (row.length() == 3) {
					row = "0x0" + row;
				}
				buffer.append(row);
			}
		}
		return buffer.toString();
	}

	public static String toIndex(byte[]... orig) {
		StringBuffer buffer = new StringBuffer();
		int j = 0;
		for (byte[] bytes : orig) {
			for (int i = 0; i < bytes.length; i++, j++) {
				if (j % 16 == 0) {
					String row = Integer.toHexString(j);
					if (row.length() == 1) {
						row = "0x000" + row;
					} else if (row.length() == 2) {
						row = "0x00" + row;
					} else if (row.length() == 3) {
						row = "0x0" + row;
					}
					buffer.append(row);
				}
				if (j % 16 == 15) {
					buffer.append("\n");
				}
			}
		}
		return buffer.toString();
	}

	//--------------------------------------------------------------------------
	public static char toHexChar(int orig) {
		if (orig > 16 || orig < 0) {
			throw new IllegalArgumentException(orig + ">16 or < 0");
		} else if (orig < 10) {
			return (char) (orig + '0');
		} else {
			return (char) (orig + 'a' - 10);
		}
	}

	public static char getHighHexChar(byte orig) {
		return toHexChar((orig & 0xf0) >> 4);//high4bit/(2^4)
	}

	public static char getLowHexChar(byte orig) {
		return toHexChar(orig & 0x0f);
	}

	public static char[] toHexCharArray(byte orig) {
		return new char[] { getHighHexChar(orig), getLowHexChar(orig) };
	}

	public static char[] toHexCharArray(byte[] orig) {
		return implToHexCharArray(orig, 0, orig.length);
	}

	public static char[] toHexCharArray(byte[] orig, int offset, int len) {
		return implToHexCharArray(orig, offset, len);
	}

	private static char[] implToHexCharArray(byte[] orig, int offset, int len) {
		char[] ch = new char[len * 2];
		for (int i = 0, j = 0; i < len; i++, j += 2) {
			ch[j] = getHighHexChar(orig[offset + i]);
			ch[j + 1] = getLowHexChar(orig[offset + i]);
		}
		return ch;
	}

	//--------------------------------------------------------------------------
	public static byte[] fromHexString(String src) {
		src = src.replaceAll(" |\t|\n", "");
		//        System.out.println(src);
		return fromHexCharArray(src.toCharArray());
	}

	public static byte fromHexChar(char ch, boolean high) {
		int result = 0;
		if (ch >= 'A' & ch <= 'F') {
			result = (ch - 'A' + 10);
		} else if (ch >= 'a' & ch <= 'f') {
			result = (ch - 'a' + 10);
		} else if (ch >= '0' & ch <= '9') {
			result = (ch - '0');
		} else {
			throw new IllegalArgumentException(ch + ">16 or < 0");
		}
		if (high) {
			result <<= 4;
		}
		return (byte) result;
	}

	public static byte fromHexCharArray(char ch1, char ch2) {
		return (byte) (fromHexChar(ch1, true) ^ fromHexChar(ch2, false));
	}

	public static byte[] fromHexCharArray(char[] ch) {
		byte[] result = new byte[ch.length / 2];
		for (int i = 0; i < result.length; i++) {
			result[i] = fromHexCharArray(ch[i * 2], ch[i * 2 + 1]);
		}
		return result;
	}

	public static byte[] copyBytes(byte[] orig, int offset, int len) {
		byte[] result = new byte[len];
		for (int i = 0; i < len; i++) {
			result[i] = orig[offset + i];
		}
		return result;
	}

	public static byte[] copyBytes(byte[] orig, int offset) {
		return copyBytes(orig, offset, orig.length - offset);
	}
	
	public static byte[] reverse(byte[] orig,int offset,int len){
		byte[] result=new byte[len];
		for(int i=0;i<len;i++){
			result[len-1-i]=orig[offset+i];
		}
		return result;
	}

}
