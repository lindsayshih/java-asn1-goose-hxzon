package choiceInsideSequence;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerOutputStream;
import com.turkcelltech.jac.OctetString;

public class TestPackage {
	
	public static void main(String[] args) throws Exception {
		//outputstream for encoding
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();		
		BerOutputStream out = new BerOutputStream(outStream);
		
		//inputStream for decoding
		ByteArrayInputStream inputStream;
		BerInputStream in;
		
		MySeq seq = new MySeq();
		seq.myChoice.myString11.setValue(new byte[]{1,2,3});
		seq.someElement.setValue(new byte[]{4,5,6});
		
		seq.encode(out);
		System.out.println("\nENCODED BYTE ARRAY:");
		printHex(outStream.toByteArray());
		System.out.println();
		
		System.out.println(seq.toString());
		
		//decode it:
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		seq = new MySeq();
		seq.decode(in);
		
		System.out.println("decoded value :\n" + seq.toString());
		
		//Check the decoded values are tre or not:
		System.out.print("\nmyString11 OCTET STRING in the choice object has the following value: ");
		printArraySimple(seq.myChoice.myString11.getValue());
		
		//Now let's encode/decode a simple Choice element:
		MyChoice chc = new MyChoice();
		chc.myString22.setValue(new byte[]{9,2,6});
		//chc.myString11.setValue(new byte[]{2,2,4}); //INVALID: You cannot set more than one element inside a Choice record. This is not allowed in asn.1 definitions. If you do this mistake in your code, JAC will throw Exception
		outStream.reset();
		chc.encode(out);
		System.out.println("\n\n-- Encoded choice element ('myString22' was chosen inside choice and was set to {9,2,6})");
		printHex(outStream.toByteArray());

		//Now let's decode the byte array to create a Choice record:
		chc = new MyChoice();
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		chc.decode(in);
		System.out.println("-- After decoding, the decoded inner Choice element name is: '"+chc.getCurrentChoice().getName()+"'");
		System.out.print  ("   and it's value is : ");
		printArraySimple(((OctetString)(chc.getCurrentChoice())).getValue());
	}
	
	public static void printArray(byte[] array) {
		System.out.println("to byte array is : ");
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public static void printArraySimple(byte[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public static void printHex(byte[] coded)
	  {
		System.out.println("Hex :");
	    String hexDigits = "0123456789ABCDEF";
	    for (int i=0; i<coded.length; i++) {
	      int c = coded[i];
	      //System.out.print(" -> " + c +" in hex: ");
	      if (c < 0) c += 256;
	      int hex1 = c & 0xF;
	      int hex2 = c >> 4;
	      System.out.print(hexDigits.substring(hex2,hex2+1));
	      System.out.print(hexDigits.substring(hex1,hex1+1) + " ");
	    }
	    System.out.println();
	  }

}
