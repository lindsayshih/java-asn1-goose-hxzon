package test;

/*
 * Created by Fatih Batuk to test the all project.
 */

import java.io.*;

import sequenceOfExample.*;

import choiceInsideSequence.MyChoice;

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.*;

import examples.*;
import example_cdr.*;
import air.*;

public class TestProject {
	
	BufferedReader bw;
	
	public static void main(String[] args) throws IOException {
		
		ManualParser manualParser;	//It will be used to decode a SequenceOf object in the below examples 
									//Usage of ManualParser.java is not prefered. Use it, if you have no other "chance"
		
		AutoParser autoParser;	//Defined here for only remaind. It will not be used directly in below examples,  
								//but when you call simple "decode(BerInputStream in)" method AutoParser will be used automatically.
		
		//outputstream for encoding
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();		
		BerOutputStream out = new BerOutputStream(outStream);
		
		//input stream for decoding
		ByteArrayInputStream inputStream;
		BerInputStream in;
		
		/**
		 * Below examples are doing encoding/decoding over some generated classes in the project.
		 * These are examples of usage of our entire project JAC:
		 */
		
		//MiddleType.java "defined type" encode/decode example 
		//MiddleType is "defined type". (That is: it extends TaggedTypeExample.java class)
		
		outStream.reset();
		MiddleType ex = new MiddleType();  //you can not set value of a "defined type" object by its constructor directly.
		ex.setValue(29);	// you can only initialize a "defined type" object by calling setValue() method.
		ex.encode(out);
		System.out.print("\n  -- MiddleType ");
		printHex(outStream.toByteArray());
		
		//decode
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		MiddleType decodedInt = new MiddleType("decodedInt");
		decodedInt.decode(in);
		System.out.println("  -- decoded MiddleType(integer) value :  " + decodedInt.getValue());
		
		
////////MyCallDetailRecord.java encode/decode example (The class was generated was javacc)
		
		MyCallDetailRecord myCdr = new MyCallDetailRecord();
		
		myCdr.origAddress.setValue(11);
		myCdr.recipAddress.setValue(22);
		myCdr.internal.location.setValue(44);		//nested sequence internal
		myCdr.internal.status.setValue(33);		//nested sequence internal
		myCdr.internal2.location.setValue(66);		//nested sequence internal2
		myCdr.internal2.status.setValue(55);		//nested sequence internal2
		myCdr.origg.setValue(111);
		myCdr.internal3.status2.setValue(98);		//nested sequence internal3
		myCdr.origg2.setValue(222);	//note that "origg2" is Explicitly tagged in at setUpElements() method of MyCallDetailRecord.java class 
		
		outStream.reset();
		myCdr.encode(out);
		System.out.print("\n  -- myCdr ");
		printHex(outStream.toByteArray());
		
		//decode MyCallDetailRecord object :
		
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		
		MyCallDetailRecord generatedCdr = new MyCallDetailRecord();
		
		System.out.println("  -- PREVIOUS (it is empty) :\n" + generatedCdr.toString());
		generatedCdr.decode(in);	//autoParser ýs used
		System.out.println("  -- LATER (it is filled after decoding) :\n" + generatedCdr.toString());
		
		//Check some values whether they are filled correctly or not:
		System.out.println(myCdr.internal.location.getValue() +" =? " +generatedCdr.internal.location.getValue());
		System.out.println(myCdr.internal3.status2.getValue() + " =? " + generatedCdr.internal3.status2.getValue());
		
		outStream.reset();
		generatedCdr.encode(out);
		System.out.print("  -- generatedCDR ");
		printHex(outStream.toByteArray());
		
		
////////Set Of example :
		MyExample exam = new MyExample();
		exam.addElement(new ASN1Integer(12));
		exam.addElement(new ASN1Integer(11));
		outStream.reset();
		exam.encode(out);
		System.out.print("\n  -- Set of object ");
		printHex(outStream.toByteArray());
		
		//	Now decode it:
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		MyExample csd = new MyExample();
		csd.decode(in);
		System.out.println ("  -- Set of decoded version : \n" + csd.toString());
		
		
////////AirRecord example  (There exists a SET Record in a SEQUENCE (AirRecord)
		AirRecord air = new AirRecord();
		air.degree.setValue(28);
		air.hot.setValue(true);
		air.cloud.isBlue.setValue(true);		//nested SET object: cloud
		byte[] arr ={0x00,0x01, 0x7F, -128};
		air.cloud.speed.setValue(arr);
		air.domain.setTo_expired_1();
		System.out.print ("\n  -- AirRecord ");
		outStream.reset();
		air.encode(out);
		printHex(outStream.toByteArray());
		
		// decode it
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		AirRecord rcd = new AirRecord();
		rcd.decode(in);		//AutoParser example. It is more easy and useful.	
		System.out.println ("  -- generatedAirRecord (decoded) version:\n" + rcd.toString());
			
		
////////cloud object : asn.1 SET type
		Cloud cld = new Cloud();
		cld.isBlue.setValue(true);
		cld.speed.setValue(arr);
		outStream.reset();
		cld.encode(out);
		System.out.print ("\n  -- Cloud object (SET) ");
		printHex(outStream.toByteArray());
		
        // decode the SET object:
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		Cloud generatedCld = new Cloud();
		generatedCld.decode(in);	//autoParser
		System.out.println ("  -- generatedCld decoded version: \n" + generatedCld.toString());
		

////////Original CallDetailrecord encoding/decoding
		
		System.out.print("\n  -- cdrOrj ");
		CallDetailRecord cdrOrj = new CallDetailRecord("cdrOrj");

		cdrOrj.origAddress.ton.setTo_abbreviated_6();
		cdrOrj.validityPeriod.hours.setValue(33);
		cdrOrj.validityPeriod.minutes.setValue(22);
		cdrOrj.billid.setValue("oldumu");
		cdrOrj.businessCards.setValue(66);
		cdrOrj.isr.setValue(arr);		// arr is a byte array. "isr" is a Octet String type object.
		
		outStream.reset();
		cdrOrj.encode(out);
		printHex(outStream.toByteArray());
		
		// decode it
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		CallDetailRecord ddr = new CallDetailRecord("ddr");
		ddr.decode(in);		//AutoParser example. It is more easy and useful.
		System.out.println(cdrOrj.validityPeriod.minutes.getValue() + " =? " +ddr.validityPeriod.minutes.getValue());
		System.out.print("Decoded cdrOrj ");
		outStream.reset();
		ddr.encode(out);
		printHex(outStream.toByteArray());
		

////////Sequence with enumerated data type example
		AddressInformation adr = new AddressInformation();
		adr.ton.setTo_reserved7_7();
		outStream.reset();
		System.out.print("\n  -- AddressInformation ");
		adr.encode(out);
		printHex(outStream.toByteArray());

		
////////ENUMERATED example
		TypeOfNumber ty = new TypeOfNumber();
		ty.setTo_reserved7_7();
		outStream.reset();
		System.out.print("\n  -- TypeOfNumber (enumerated) ");
		ty.encode(out);
		printHex(outStream.toByteArray());
		//decode
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		TypeOfNumber ccd = new TypeOfNumber();
		ccd.decode(in);
		System.out.println("  -- Decoded TypeOfNumber:\n" + ccd.toString());

		
////////Single ASN1Integer type encode/decode example
		C7PointCode cc = new C7PointCode(16777215);	//It should not be greater than 16777215. because its max value is set to 16777215.
												// Just try to give a bigger number. You will get exception.
		outStream.reset();
		cc.encode(out);
		C7PointCode ccGen = new C7PointCode();
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		ccGen.decode(in);
		System.out.println("\n"+cc.getValue() + " =? " + ccGen.getValue());

		
////////EXPLICIT examples
		
		System.out.println("\n========= START OF EXPLICIT EXAMPLES =========");
		TaggedTypeExample sem = new TaggedTypeExample(122);
		sem.setTaggingMethod(Tag.EXPLICIT);		//In default 'TaggedTypeExample' is IMPLICIT
		//sem.setTagClass(Tag.CONTEXT);
		//sem.setTagNumber(12);
		outStream.reset();
		sem.encode(out);
		System.out.print("  -- Explicitly encoded Integer with value '122' ");
		printHex(outStream.toByteArray());
		//Now decode it
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		TaggedTypeExample somes = new TaggedTypeExample();
		somes.setTaggingMethod(Tag.EXPLICIT);	//In default 'TaggedTypeExample' is IMPLICIT
		somes.decode(in);
		System.out.println("  -- After decoding its value is \n" + somes.getValue());
		
////////Elements of MySequence.java  are all explicit:
		MySequence mySeq = new MySequence();
		mySeq.status.setValue(619);
		mySeq.location.setValue(arr);
		outStream.reset();
		mySeq.encode(out);
		System.out.print("\n  -- MySequence object (includes explicitly tagged elements) ");
		printHex(outStream.toByteArray());
		
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		MySequence net = new MySequence();
		net.decode(in);  	//AutoParser example. 
		
		System.out.print("  -- Decoded MySequence ");
		outStream.reset();
		net.encode(out);
		printHex(outStream.toByteArray());
		
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		MySequence later = new MySequence();
		later.decode(in);	//AutoParser example.
		
		//Print all octet string objects and check them they are all equal or not :
		System.out.println("  -- Print all octet string objects and check them they are all equal or not:");
		printHex(mySeq.location.getValue());
		printHex(net.location.getValue());
		printHex(later.location.getValue());

		System.out.println("========= END OF EXPLICIT EXAMPLES =========\n");
		
////////Minutes.java: INTEGER range constraint example
		//It is defined in the protocol as :
		// Minutes ::= INTEGER {first (0), last (59)}
		//If you try to set an out of range value, you will get exception. Just try it !
		Minutes mm = new Minutes(59);
		System.out.println("\n  -- Minutes.java example \nIts value is : " + mm.getValue());

		
////////SequenceOf encoding/decoding example. 
		// decode example with both autoParser and manual parser seperately.
		SequenceOf ss = new SequenceOf();	//If you use this constructor call setComponenttype() method just after
		ss.setComponentType(new CallDetailRecord("CallDetailR_"));	
		ss.addElement(cdrOrj);	//add some CallDetailRecord object
		ddr.bit16PortNumberDest.setValue(65233);
		ss.addElement(ddr);		//add some CallDetailRecord object
		//encode it:
		outStream.reset();
		ss.encode(out);
		System.out.print("\n  -- SequenceOf object (SEQUENCE OF CallDetailRecord) at the beginning ");
		printHex(outStream.toByteArray());
		//decode it:
		SequenceOf foo_manual = new SequenceOf(new CallDetailRecord("CallDetailRecord_forDecode"));
		SequenceOf foo_auto = new SequenceOf(new CallDetailRecord("CallDetailRecord_forDecode"));

		
		//Decode with manualParser.. (not preferred! But just to show an example of ManualParser.java)
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		manualParser = new ManualParser();
		foo_manual.decode(manualParser,in);	
		//	Decode with autoParser... This is OK..
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		foo_auto.decode(in);
		
		outStream.reset();
		foo_manual.encode(out);
		System.out.print("  -- Decoded SequenceOf object (with manual Parser)");
		printHex(outStream.toByteArray());
		
		outStream.reset();
		foo_auto.encode(out);
		System.out.print("  -- Decoded SequenceOf object (with auto Parser)");
		printHex(outStream.toByteArray());
		
		//check whether the value of "bit16PortNumberDest" is correctly decoded in the second CallDetailrecord of the Sequenceof object:
		CallDetailRecord cdrx = (CallDetailRecord)foo_auto.get(1);	//get the second CDR in the SequenceOf object
		System.out.println("  -- The value of 'bit16PortNumberDest' in the second CallDetailRecord in the decoded SequenceOf object:\n" + cdrx.bit16PortNumberDest.getValue() + " (So as you see the value is decoded correctly!)\n");
		
		
////////SequenceOf example and it will be decoded with AutoParser.java
		SequenceOf bb = new SequenceOf(new ASN1Integer());
		bb.addElement(new ASN1Integer(23));
		bb.addElement(new ASN1Integer(63));
		bb.addElement(new ASN1Integer(93));
		outStream.reset();
		bb.encode(out);
		System.out.print("\n  -- SEQUENCE OF INTEGER  ");
		printHex(outStream.toByteArray());
		// decode it:
		SequenceOf bar = new SequenceOf(new ASN1Integer());
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		bar.decode(in);		//decode with autoParser
		System.out.println("  -- decoded SEQUENCE OF INTEGER (with autoParser):\n" + bar.toString());
		outStream.reset();
		bar.encode(out);
		System.out.print("  -- re-encoded SEQUENCE OF INTEGER  ");
		printHex(outStream.toByteArray());
		
////////Good example when working with SequenceOf and Sequence objects if they are defined in some complexity:
		//In the next example there is a SequenceOf Record (Cell_List) inside a Sequence (Report). 
		//And this SequenceOf Record (Cell_List) also holds a different Sequence (Cell) objects:
		
		Cell cell1 = new Cell();
        cell1.disc.setValue(new byte[]{1,2,3});
        cell1.cell_id.setValue(new byte[]{4,5,6});

        Cell cell2 = new Cell();
        cell2.disc.setValue(new byte[]{7,8,9});
        cell2.cell_id.setValue(new byte[]{4,9});

        Report report = new Report();
        report.message_Identifier.setValue(3);
        report.cell_List.addElement(cell1);
        report.cell_List.addElement(cell2);

        //encode:
        outStream = new ByteArrayOutputStream();
        out = new BerOutputStream(outStream);
        report.encode(out);

        //decode it:
        inputStream = new ByteArrayInputStream(outStream.toByteArray());
        in = new BerInputStream(inputStream);
        Report generatedReport = new Report();
        generatedReport.decode(in);

        //check some parameter to see that whether it is decoded succesfully or not:
        Cell cell = (Cell) generatedReport.cell_List.get(1); 
        System.out.println("\n'sequenceOfExample' package: In decoded inner sequence (Cell), the octet string values should be {7,8,9} and {4,9} respectively:\n"+cell.toString()+"\n");
        
/////// A simple Choice encode/decode example:
        //Let's encode/decode a simple Choice element:
		MyChoice chc = new MyChoice();
		chc.myString22.setValue(new byte[]{9,2,6});
		//chc.myString11.setValue(new byte[]{2,2,4}); //INVALID: You cannot set more than one element inside a Choice record. This is not allowed in asn.1 definitions. If you do this mistake in your code, JAC will throw Exception
		outStream.reset();
		chc.encode(out);
		System.out.println("  -- Encoded 'MyChoice' record ('myString22' was chosen inside Choice and was set to {9,2,6}):");
		printHex(outStream.toByteArray());

		//Now let's decode the byte array to create a Choice record:
		chc = new MyChoice();
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		chc.decode(in);
		System.out.println("  -- After decoding, the decoded element name inside 'MyChoice' record is: '"+chc.getCurrentChoice().getName()+"'");
		System.out.print  ("     and it's value is : ");
		printArray(((OctetString)(chc.getCurrentChoice())).getValue());
        
/////// Another Choice record example (more complex)
		SmsCdr sms = new SmsCdr("sms");
		outStream.reset();
		sms.callDetailRecord.calendarEntries.setValue(23);
		sms.encode(out);
		System.out.print("\n  -- Choice object ");
		printHex(outStream.toByteArray());
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		sms = new SmsCdr("Decoded_Sms");
		sms.decode(in);
		System.out.println("=> in the decoded choice object the value of 'sms.callDetailRecord.calendarEntries' = "+sms.callDetailRecord.calendarEntries.getValue()+" (should be equal to 23)");
		
		/*
		 * Note: If you do not want to show your Choice elements in public view
		 * go to ASTChoiceType.java and change the visibility from "public" to "private" and then re-parse your asn.1 file.
		 * (Then you will also need to add implementation of getter and setter methods) 
		 */
		
/////// AirRecord2
		AirRecord2 air2 = new AirRecord2(true);
		air2.degree.setValue(23);
		air2.location.setTo_istanbul_1();
		air2.time.setValue(8);
		byte[] arry = {1,2,32};
		air2.cloud.speed.setValue(arry);
		air2.cloud.isBlue.setValue(true);
		air2.cloud.parameters.addElement(new ASN1Integer(13));
		air2.cloud.parameters.addElement(new ASN1Integer(23));
		ByteArrayOutputStream stream2 = new ByteArrayOutputStream();		
		BerOutputStream out2 = new BerOutputStream(stream2);
		air2.encode(out2);
		System.out.print("\n  -- airRecord2 ");
		printHex(stream2.toByteArray());
		ByteArrayInputStream inputStream2 = new ByteArrayInputStream(stream2.toByteArray());
		BerInputStream in2 = new BerInputStream(inputStream2);
		AirRecord2 generatedAir = new AirRecord2(false);
		generatedAir.decode(in2);
		System.out.println("  -- Generated airRecord2 : " + generatedAir.toString());
		System.out.println("  -- generatedAir2.cloud.speed.getValue()   -it is octet string value- : ");
		printHex ( generatedAir.cloud.speed.getValue() );
		
		stream2.reset();
		generatedAir.encode(out2);
		System.out.print("  -- generatedAir2 (re-encode) ");
		printHex(stream2.toByteArray());

		
////////Important example with tagged type : TaggedTypeExample.java
		TaggedTypeExample somet = new TaggedTypeExample(23);
		outStream.reset();
		somet.encode(out);
		System.out.print("\n  -- Tagged type (TaggedTypeExample.java)  ");
		printHex(outStream.toByteArray());
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		TaggedTypeExample tte_decoded = new TaggedTypeExample();
		tte_decoded.decode(in);
		System.out.println("  -- Decoded TaggedTypeExample value is : " + tte_decoded.getValue());
		SetOf setof = new SetOf(new TaggedTypeExample());
		setof.addElement(new TaggedTypeExample(43));
		setof.addElement(new TaggedTypeExample(53));
		outStream.reset();
		setof.encode(out);
		System.out.print("  -- SetOf object holds tagged types (TaggedTypeExample.java)  ");
		printHex(outStream.toByteArray());
		//decode :
		SetOf setof_decoded = new SetOf(new TaggedTypeExample());
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		setof_decoded.decode(in);
		//re-encode :
		outStream.reset();
		setof_decoded.encode(out);
		System.out.print("  -- SetOf object holds tagged types (TaggedTypeExample.java) re-encode (after decoding)  ");
		printHex(outStream.toByteArray());
		
//////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * example to show the original tag is derived by masking with our UNCONSTRUCTED_MASK constant
		 */
		int myTag = Tag.SEQUENCE;		//you can set this tag value whatever you want
    	int first = Tag.CONSTRUCTED | myTag;
    	int last = first & Tag.UNCONSTRUCTED_MASK;
    	boolean status;
    	if (myTag == last)
    		status = true;
    	else
    		status = false;
    	System.out.println("\n=============================\n  -- Compare the tag values :");
    	System.out.println(status + " => " + myTag + "  "+ first + "  "+ last);
    	System.out.println("=============================\n");
    	
    	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
    	/**
		 * below examples are just examples of usage of pure W.Woody's Library:
		 * To see more examples of usage of pure library see 
		 * TestUtil.java under com.chaosinmotion.asn1 package.
		 */
    	
    	TestParser wParser = new TestParser();
		
		// create sequence
		BerSequence seq = new BerSequence();
		BerInteger a = new BerInteger(11);
		seq.add(a);
		seq.add(new BerBoolean(true));

		//encode
		outStream.reset();
		seq.writeElement(out);
		out.flush();
		System.out.println("  -- The created sequence is :");
		System.out.println(seq.toString());
		printHex(outStream.toByteArray());
		
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		BerSequence generatedSeq = (BerSequence)wParser.readPacket(in);	//W.Woody's TestParser.java class decode example
		
		System.out.println("\n  -- Decoded SEQUENCE is : ");
		System.out.println( generatedSeq.toString());
		printHex(outStream.toByteArray());
		
		//BerInteger encode/decode example :
		
		//encode BerInteger
		outStream.reset();
		BerInteger berInt = new BerInteger(22);
		berInt.writeElement(out);
		out.flush();
		
		//decode
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		in = new BerInputStream(inputStream);
		
		BerInteger generatedInt = (BerInteger)wParser.readPacket(in);
		
		System.out.println("\n -- Decoded integer is :\n" + generatedInt.toString());
		printHex(outStream.toByteArray());

	}
	
	public static void printHex(byte[] coded) 
	{
		System.out.println("to byte array in HEX : ");
	    String hexDigits = "0123456789ABCDEF";
	    for (int i=0; i<coded.length; i++) {
	      int c = coded[i];
	      if (c < 0) c += 256;
	      int hex1 = c & 0xF;
	      int hex2 = c >> 4;
	      System.out.print(hexDigits.substring(hex2,hex2+1));
	      System.out.print(hexDigits.substring(hex1,hex1+1) + " ");
	    }
	    System.out.println();
	  }
	
	public static void printArray(byte[] array) {
		//System.out.println("to byte array in DEC : ");
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

}
