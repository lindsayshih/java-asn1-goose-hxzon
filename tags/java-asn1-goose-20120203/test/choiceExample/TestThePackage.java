package choiceExample;

import java.io.*;

import com.chaosinmotion.asn1.*;

/**
 * In this package there are generated java classes from "choiceExample.asn" file.
 * Important thing to mention is, there is a choice record inside a sequence in these asn1 types
 * and we did some encoding/decoding examples in this class to show that it works correctly
 * @author Fatih Batuk
 */
public class TestThePackage {

	public static void main(String[] args)throws Exception {
		
		//outputstream for encoding
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();		
		BerOutputStream out = new BerOutputStream(outStream);
		
		//inputStream for decoding
		ByteArrayInputStream inputStream;
		BerInputStream in;
		
		//UUS1_Content
		UUS1_Content uc = new UUS1_Content();
		uc.lawfullInterceptionIdentifier.setValue(new byte[]{1,2,3});			
		uc.communicationIdentifier.communication_Identity_Number.setValue(new byte[]{11,22,33});		
		uc.communicationIdentifier.network_Identifier.operator_Identifier.setValue(new byte[]{21,32,43});	
		uc.communicationIdentifier.network_Identifier.network_Element_Identifier.e164_Format.setValue(new byte[]{31,42,53});
		uc.direction_Indication.setTo_cc_from_target_1();

		//encode it..
		uc.encode(out);
		System.out.println("\nENCODED BYTE ARRAY:");
		printHex(outStream.toByteArray());
		System.out.println();

		//now lets decode it..
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		uc = new UUS1_Content();
		uc.decode(in);
		
		//Re-encode!
		outStream = new ByteArrayOutputStream();
		out = new BerOutputStream(outStream);
		uc.encode(out);
		System.out.println("\nRE-ENCODED BYTE ARRAY:");
		printHex(outStream.toByteArray());
		System.out.println();
		
		//Re-decode!
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		uc = new UUS1_Content();
		uc.decode(in);
		System.out.println("decoded value :\n" + uc.toString());
		
		//!! check the printed "encoded byte array" results by hand! check they are equal or not. They have to be same!
		
		//now let's print some decoded elements to check whether they are correctly filled or not:
		System.out.print("\nlawfullInterceptionIdentifier OCTET STRING value is: ");
		printArraySimple(uc.lawfullInterceptionIdentifier.getValue());
		
		System.out.print("\ne164_Format OCTET STRING value is: ");
		printArraySimple(uc.communicationIdentifier.network_Identifier.network_Element_Identifier.e164_Format.getValue());
		
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

}
