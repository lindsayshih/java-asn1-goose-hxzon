package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class ExecutionArgument extends BerChoice {
//	executionArgument	CHOICE {
//	    simpleString	  [1] IMPLICIT VisibleString,
//	    encodedString	  EXTERNALt
//	    }
	public BerNode create(int tag,BerInputStream stream){
		switch(tag){
		case Tag.CONTEXT|1:
			return Asn1Utils.createBerVisibleString("simpleString", "simpleString", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}
}
