package org.hxzon.util;

import java.util.Arrays;

public class Hex2Float {
	public static int getInt(char ch) {
		if (ch >= '0' && ch <= '9')
			return ch -= '0';
		if (ch >= 'a' && ch <= 'z')
			ch -= 32;
		if (ch < 'A' || ch > 'Z')
			throw new RuntimeException("参数不合法!");
		switch (ch) {
		case 'A':
			return 10;
		case 'B':
			return 11;
		case 'C':
			return 12;
		case 'D':
			return 13;
		case 'E':
			return 14;
		case 'F':
			return 15;
		}
		return 0;
	}

	public static char[] str2BitArray(String str) {
		char chs[] = str.toCharArray();
		char bits[] = new char[chs.length * 4];
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			for (int j = 3; j >= 0; j--) {
				if (((1 << j) & getInt(chs[i])) != 0) {
					bits[index++] = '1';
				} else
					bits[index++] = '0';
			}
		}
		System.out.println(Arrays.toString(bits));
		return bits;
	}

	public static int parseSign(char ch[]) {
		return (ch[0] == '1' ? -1 : 1);
	}

	public static int parseExponent(char ch[]) {
		int result = 0;
		for (int i = 1; i <= 8; i++) {
			result += (ch[i] - '0') * Math.pow(2, 8 - i);
		}
		//System.out.println(result);
		return result;
	}

	public static double parseEnding(char[] ch) {
		double result = 0;
		for (int i = 9; i <= 31; i++) {
			result += (ch[i] - '0') * Math.pow(0.5, i - 8);
		}
		//System.out.println(result);
		return result;
	}

	public static float getFloat(String str) {
		char[] bits = str2BitArray(str);
		int sign = parseSign(bits);
		int e = parseExponent(bits);
		double m = parseEnding(bits);
		System.out.println("sign=" + sign + ",e=" + e + ",m=" + m);
		if (e == 0 && m == 0) {
			return 0;
		} else if ((e == 0) && (m != 0)) {
			return (float) (sign * Math.pow(2.0, -126) * m);
		} else if (e >= 1 && e <= 254 && m != 0) {
			return (float) (sign * Math.pow(2.0, e - 127) * (1 + m));
		} else if ((e == 255) && m != 0) {
			if ((sign == 1) && (m == 0.5))
				return Float.NaN;
			else if ((sign == 1) && (m == 0))
				return Float.NEGATIVE_INFINITY;
			else
				return Float.POSITIVE_INFINITY;
		}
		return 0;
	}

	public static void main(String rags[]) {
		String str = "3ecccccd";
		float f = getFloat(str);
		System.out.println("f=" + f);
	}
}
