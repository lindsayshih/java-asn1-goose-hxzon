package org.hxzon.util;

public class BitUtil {
    public static final int TestNone = 0;
    public static final int Test1 = 1 << 1;
    public static final int Test2 = 1 << 2;
    public static final int Test3 = 1 << 3;
    public static final int Test4 = 1 << 4;
    public static final int Test5 = 1 << 5;

    public static boolean isSet(int value, int test) {
        return (value & test) != 0;
    }

    public static int remove(int value, int remove) {
        return ~((~value) | remove);
    }

    public static void main(String[] args) {
        int value = Test1 | Test3 | Test4;
        System.out.println(BitUtil.isSet(value, Test1));
        System.out.println(BitUtil.isSet(value, Test2));
        System.out.println(BitUtil.isSet(value, Test3));
        System.out.println(BitUtil.isSet(value, Test4));
        System.out.println(BitUtil.isSet(value, Test5));
        value = BitUtil.remove(value, Test3);
        System.out.println(BitUtil.isSet(value, Test1));
        System.out.println(BitUtil.isSet(value, Test2));
        System.out.println(BitUtil.isSet(value, Test3));
        System.out.println(BitUtil.isSet(value, Test4));
        System.out.println(BitUtil.isSet(value, Test5));
        value = BitUtil.remove(value, Test5);
        System.out.println(BitUtil.isSet(value, Test1));
        System.out.println(BitUtil.isSet(value, Test2));
        System.out.println(BitUtil.isSet(value, Test3));
        System.out.println(BitUtil.isSet(value, Test4));
        System.out.println(BitUtil.isSet(value, Test5));
    }
}
