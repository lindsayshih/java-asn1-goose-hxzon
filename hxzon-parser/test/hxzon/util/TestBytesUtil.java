package test.hxzon.util;

import org.hxzon.util.BytesUtil;

public class TestBytesUtil {

	public static void testToInt(){
		testToInt( 0x3b, 1, 1,0);//0
		testToInt( 0x3b, 1, 2,1);//1
		testToInt( 0x3b, 1, 3,3);//3
		testToInt( 0x3b, 1, 4,7);//7
		testToInt( 0x3b, 1, 5,14);//14
		System.out.println("--------");
		testToInt( 0x3b, 2, 1,1);//1
		testToInt( 0x3b, 2, 2,3);//3
		testToInt( 0x3b, 2, 3,7);//7
		testToInt( 0x3b, 2, 4,14);//14
		testToInt( 0x3b, 2, 5,29);//29
		testToInt( 0x3b, 2, 6,59);//59
	}
	
	public static void testToInt(int b,int bitOffset,int bitLen,int want){
		int value=BytesUtil.toInt((byte)b, bitOffset,bitLen);
		System.out.println(value+","+(value==want));
	}
	
	public static void testToUInt(int b){
		System.out.println(b+","+(byte)b+","+BytesUtil.toUInt((byte)b));
	}
	
	public static void testToUInt(){
		for(int i=-300;i<300;i++){
			testToUInt(i);
		}
	}
	
	public static void testFromHexChar(char ch1,char ch2){
		byte result=BytesUtil.fromHexCharArray(ch1, ch2);
		String value=BytesUtil.toHexString(result);
		System.out.println(ch1+","+ch2+","+value);
	}
	
	public static void testFromHexChar(){
		testFromHexChar('a','b');
		testFromHexChar('c','1');
		testFromHexChar('2','f');
		testFromHexChar('3','7');
	}
	
	public static void main(String[] args) {
//		testToInt();
		testToUInt();
//		testFromHexChar();
	}
}
