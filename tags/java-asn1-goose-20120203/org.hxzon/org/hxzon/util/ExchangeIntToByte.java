package org.hxzon.util;

public class ExchangeIntToByte {
    static byte[] bArray;

    public static void intToByte(int a) {
        bArray = new byte[4];

        for (int i = 0; i < bArray.length; i++) {
            bArray[i] = new Integer(a & 0XFF).byteValue();
            a >>= 8;
            System.out.print(bArray[i] + " ");
        }
        System.out.println();
    }

    public static void byteToInt(byte[] bArray) {
        int a = 0;
        for (int i = 0; i < bArray.length; i++) {
            a += (bArray[i] & 0XFF) << (8 * i);
        }
        System.out.println(a);
    }

    public static void longToByte(long a) {
        bArray = new byte[8];

        for (int i = 0; i < bArray.length; i++) {
            bArray[i] = new Long(a & 0XFF).byteValue();
            a >>= 8;
            System.out.print(bArray[i] + " ");
        }
        System.out.println();
    }

    public static void byteToLong(byte[] bArray) {
        long a = 0;

        for (int i = 0; i < bArray.length; i++) {
            a += (long) ((bArray[i] & 0XFF) << (8 * i));
        }
        System.out.println(a);
    }

    public static void main(String args[]) {
        int i = 1000;
        long l = 1000l;

        intToByte(i);
        byteToInt(bArray);
        longToByte(l);
        byteToLong(bArray);
    }
}
